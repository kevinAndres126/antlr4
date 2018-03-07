lexer grammar GPLexer;


//numbers
DIGIT : '0' | '1'..'9';

NUM: '1'..'9' (DIGIT)*;

LETTER: 'a'..'z'|'A'..'Z'| '_' ;

ID: LETTER | (LETTER | NUM)*;

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
PUNTO   :   '.';
PyCOMA	:	';' ;
COMA	:	',' ;
ASIGN	:	'=' ;
PIZQ	:	'(' ;
PDER	:	')' ;
LLAVEIZQ:   '{' ;
LLAVEDER:   '}' ;
CORCHETEIZQ: '[';
CORCHETEDER: ']';


//Tokes para operaciones logicas
AND     :'&&';
OR      :'||';

//Tokes para operaciones relacionales
II :         '==';
DI :         '!=';
MAYORK:      '>';
MENORK:      '<';
MAYORIGUALK: '>=';
MENORIGUALK: '<=';
//Tokens para palabras reservadas
BREAK   :'break';
CLASS   :'class';
CONST   :'const';
ELSE    :'else';
IF      :'if';
IN      :'in';
NEW     :'new';
READ    :'read';
RETURN  :'return';
VOID    :'void';
WHILE   :'while';
FOR     :'for';
WRITE   :'write';
FOREACH :'foreach';
TRUE    :'true';
FALSE   :'false';






//elementos omitidos
LINE_COMMENT:   '//' .*? '\r'? '\n' -> skip ;

SPECIAL_COMMENT
 : '/*' ( SPECIAL_COMMENT | DELIMITED_COMMENT | . )*? '*/' -> skip
 ;

fragment DELIMITED_COMMENT
 : '/*' .*? '*/'
 ;

WS          :   [ \t\n\r]+ -> skip ;