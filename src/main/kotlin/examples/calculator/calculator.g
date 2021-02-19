
@header {package examples.calculator}

@attributes {
    var value = 0
    var acc = 0
}

expr
    : bitwiseExpr { value = $0.value }
    ;

bitwiseExpr
    : additiveExpr bitwiseExprs(value = $0.value) { value = $1.value }
    ;

bitwiseExprs
    : SHL bitwiseExpr { value = res.value shl $1.value }
    | SHR bitwiseExpr { value = res.value shr $1.value }
    |
    ;

additiveExpr
    : mulExpr additiveExprs(acc = $0.value) { value = $1.value }
    ;

additiveExprs
    : PLUS mulExpr additiveExprs(acc = res.acc + $1.value) { value = $2.value }
    | MINUS mulExpr additiveExprs(acc = res.acc - $1.value) { value = $2.value }
    | { value = res.acc }
    ;

mulExpr
    : unaryExpr mulExprs(acc = $0.value) { value = $1.value}
    ;

mulExprs
    : MUL unaryExpr mulExprs(acc = res.acc * $1.value) { value = $2.value }
    | DIV unaryExpr mulExprs(acc = if ($1.value == 0) Int.MAX_VALUE else (res.acc / $1.value))
            { value = $2.value }
    | { value = res.acc }
    ;

unaryExpr
    : MINUS primaryExpr { value = -$1.value }
    | primaryExpr { value = $0.value }
    ;

primaryExpr
    : NUMBER { value = $0.text.toInt() }
    | LPAREN expr RPAREN  { value = $1.value }
    ;

PLUS  : "+" ;
MINUS : "-" ;
MUL   : "*" ;
DIV   : "/" ;
SHL   : "<<" ;
SHR   : ">>" ;

LPAREN : "(" ;
RPAREN : ")" ;

NUMBER : '[0-9]+' ;

WS : '[ \t\r\n]+';
skip WS;
