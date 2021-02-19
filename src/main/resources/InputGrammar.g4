grammar InputGrammar;

@header {
package ru.itmo.gunkin;
}

start
    : header? attributes? declarations EOF
    ;

header
    : '@header' CURLY_BRACKET_CODE
    ;

attributes
    : '@attributes' CURLY_BRACKET_CODE
    ;

declarations
    : (rulee | token | skipToken)*
    ;

rulee
    : RULE_NAME ':' ruleProduction (OR ruleProduction)* ';'
    ;

ruleProduction
    : productionElement* synthesizedAttr?
    ;

productionElement
    : RULE_NAME inheritedAttr?
    | TOKEN_NAME
    ;

inheritedAttr
    : ROUND_BRACKET_CODE
    ;

synthesizedAttr
    : CURLY_BRACKET_CODE
    ;

roundBracketsCode
    : '{' (~'{' | roundBracketsCode)* '}'
    ;

token
    : TOKEN_NAME ':' tokenPattern ';'
    ;

skipToken
    : 'skip' TOKEN_NAME ';'
    ;

tokenPattern
    : TOKEN_REGEX | TOKEN_STRING
    ;


fragment LOWERCASE: [a-z] ;
fragment UPPERCASE: [A-Z] ;
fragment ALPHA_NUM: [a-zA-Z0-9] ;

COLON: ':' ;
SEMICOLON: ';' ;
ARROW: '->' ;
OR: '|' ;
OPEN_CURLY: '{';
CLOSE_CURLY: '}';

RULE_NAME: LOWERCASE (ALPHA_NUM | '_')* ;

TOKEN_NAME: UPPERCASE (ALPHA_NUM | '_')* ;
TOKEN_REGEX: '\'' ( ~('\'') | '\\\'')* '\'' ;
TOKEN_STRING: '"' (~('"') | '\\"')* '"' ;

CURLY_BRACKET_CODE : '{' (~'{' | CURLY_BRACKET_CODE)* '}';
ROUND_BRACKET_CODE : '(' (~'(' | ROUND_BRACKET_CODE)* ')';

WS : [ \t\n\r]+ -> skip ;



