lexer grammar lexerInterprete;

//Tokens para simbolos
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


//Tokes para operaciones relacionales
II :         '==';
MAYORK:      '>';
MENORK:      '<';
MAYORIGUALK: '>=';
MENORIGUALK: '<=';


//Tokes para operaciones matematicas
SUMA	:	'+' ;
RESTA   :   '-';
MUL		:	'*' ;
DIV     :   '/';


//Tokens para palabras reservadas
LET     :'let';
RETURN  :'return';
TRUE    :'true';
FALSE   :'false';
LEN     :'len';
FIST    :'first';
LAST    :'last';
REST    :'rest';
PUSH    :'push';
FN      :'fn';
PUTS    :'puts';
IF      :'if';
ELSE    :'else';





INTEGER: DIGIT DIGIT*;

ID : LETTER ( LETTER | DIGIT)*;

STRING : '"' ('""'|~'"')* '"' ;



fragment LETTER: 'a'..'z'|'A'..'Z'|'_';

fragment DIGIT: '0'..'9';


//elementos omitidos
LINE_COMMENT:   '//' .*? '\r'? '\n' -> skip ;

SPECIAL_COMMENT
 : '/*' ( SPECIAL_COMMENT | DELIMITED_COMMENT | . )*? '*/' -> skip
 ;

fragment DELIMITED_COMMENT
 : '/*' .*? '*/'
 ;

WS          :   [ \t\n\r]+ -> skip ;