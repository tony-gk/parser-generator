@header {package examples.forloop}

start
    : FOR OPEN_PARENTHESES init SEMICOLON condition SEMICOLON update CLOSE_PARENTHESES
    ;

init
    : IDENTIFIER IDENTIFIER ASSIGN NUMBER
    ;

condition
    : IDENTIFIER compareOp NUMBER
    ;

compareOp
    : LE | LT | GE | GT | EQ | NE
    ;

update
    : IDENTIFIER updateOp
    ;

updateOp
    :  INCREMENT | DECREMENT
    ;

OPEN_PARENTHESES : "(" ;
CLOSE_PARENTHESES : ")" ;
LE : "<=" ;
LT : "<" ;
GE : ">=" ;
GT : ">" ;
EQ : "==" ;
NE : "!=" ;
INCREMENT : "++" ;
DECREMENT : "--" ;
ASSIGN : "=" ;
FOR : "for" ;
SEMICOLON : ";" ;

IDENTIFIER : '[a-zA-Z][a-zA-Z0-9]*' ;
NUMBER : '[+-]?[0-9]+' ;

WS : '[ \t\r\n]+';
skip WS;

