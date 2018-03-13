lexer grammar lexerInterprete;

//INTEGER
INTEGER: '0'..'9' ('0'..'9')*;


LETTER: 'a'..'z'|'A'..'Z';

//STRING
STRING : '"' ('""'|~'"')* '"' ;

//'"' (LETTER | IDENT | SYMBOLS | INTEGER)* '"';

//IDENT: LETTER | (LETTER | INTEGER | '_' )*;

//Tokes para operaciones matematicas
SUMA	:	'+' ;
MUL		:	'*' ;
RESTA   :   '-';
DIV     :   '/';

/*
DIVMOD  :   '%';
MASMAS  :   '++';
MENOSMENOS : '--';
*/

//Tokens para simbolos
//PUNTO   :   '.';
PyCOMA	:	';' ;
DP      :   ':' ;
COMA	:	',' ;
ASIGN	:	'=' ;
PIZQ	:	'(' ;
PDER	:	')' ;
LLAVEIZQ:   '{' ;
LLAVEDER:   '}' ;
CORCHETEIZQ: '[';
CORCHETEDER: ']';


//Tokes para operaciones logicas
//AND     :'&&';
//OR      :'||';

//Tokes para operaciones relacionales
II :         '==';
//DI :         '!=';
MAYORK:      '>';
MENORK:      '<';
MAYORIGUALK: '>=';
MENORIGUALK: '<=';

//Tokens para palabras reservadas
//BREAK   :'break';
//CLASS   :'class';
//CONST   :'const';
LET     :'let';
ELSE    :'else';
IF      :'if';
LEN     :'len';
FIST    :'first';
LAST    :'last';
REST    :'rest';
PUSH    :'push';
FN      :'fn';
PUTS    :'puts';
//IN      :'in';
//NEW     :'new';
//READ    :'read';
RETURN  :'return';
//VOID    :'void';
//WHILE   :'while';
//FOR     :'for';
//WRITE   :'write';
//FOREACH :'foreach';
TRUE    :'true';
FALSE   :'false';

//IDENTIFIER
IDENT: LETTER(LETTER | INTEGER | '_' )*;


fragment SYMBOLS
    :
    '!'|
     '"'|
     '#'|
     '$'|
     '%'|
     '&'|
     '\''|
     '('|
     ')'|
     '*'|
     '+'|
     ','|
     '-'|
     '.'|
     '/'|
     ':'|
     ';'|
     '<'|
     '='|
     '>'|
     '?'
     ;





//elementos omitidos
LINE_COMMENT:   '//' .*? '\r'? '\n' -> skip ;

SPECIAL_COMMENT
 : '/*' ( SPECIAL_COMMENT | DELIMITED_COMMENT | . )*? '*/' -> skip
 ;

fragment DELIMITED_COMMENT
 : '/*' .*? '*/'
 ;

WS          :   [ \t\n\r]+ -> skip ;