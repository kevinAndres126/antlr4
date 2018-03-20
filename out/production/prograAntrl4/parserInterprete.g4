parser grammar parserInterprete;

// indicar de donde toma la gramatica
options {
    tokenVocab = lexerInterprete;
}

program     :(statement)*                                                        #prograstate
            ;

statement   : LET letStatement                                                  #statelet
            | RETURN returnStatement                                            #statereturn
            | expressionStatement                                               #stateexpre
            ;

letStatement    : IDENT ASIGN expression (PyCOMA | EOF)                         #stateletRule
                ;

returnStatement :expression (PyCOMA | EOF)                                      #statereturnRule
                ;

expressionStatement :expression (PyCOMA | EOF)                                  #stateexpreRule
                    ;

expression  :additionExpression comparison                                      #expreRule
            ;

comparison  :((MENORK|MAYORK|MENORIGUALK|MAYORIGUALK|II) additionExpression)*   #comparRule
            ;

additionExpression  :multiplicationExpression additionFactor                    #addExpreRule
                    ;

additionFactor  :((SUMA|RESTA) multiplicationExpression)*                       #addFactRule
                ;

multiplicationExpression :elementExpression multiplicationFactor                #multiExpresRule
                         ;

multiplicationFactor    :((MUL|DIV) elementExpression)*                         #multiFactRule
                        ;

elementExpression   :primitiveExpression (elementAccess|callExpression |EOF)    #elemExpreRule
                    ;

elementAccess   :CORCHETEIZQ expression CORCHETEDER                             #elemAccesRule
                ;

callExpression  :PIZQ expressionList PDER                                       #callExpreRule
                ;

primitiveExpression :INTEGER                                                    #primiExpreInt
                    | STRING                                                    #primiExpreStr
                    | IDENT                                                     #primiExpreIdent
                    | TRUE                                                      #primiExpreTrue
                    | FALSE                                                     #primiExpreFalse
                    | PIZQ expression PDER                                      #primiExpreExpres
                    | arrayLiteral                                              #primiExpresArrayliteral
                    | arrayFunctions PIZQ expressionList PDER                   #primiExpreArrayFuntions
                    | functionLiteral                                           #primiExpreFuntionLiteral
                    | hashLiteral                                               #primiExpreHash
                    | printExpression                                           #primiExprePrint
                    | ifExpression                                              #primiExpreIf
                    ;

arrayFunctions  : LEN                                                           #arrayFunLen
                | FIST                                                          #arrayFunFist
                | LAST                                                          #arrayFunLast
                | REST                                                          #arrayFunRest
                | PUSH                                                          #arrayFunPush
                ;

arrayLiteral    : CORCHETEIZQ expressionList CORCHETEDER                        #arrayLiteralRule
                ;

functionLiteral : FN PIZQ functionParameters PDER blockStatement                #funLiteralRule
                ;

functionParameters  :IDENT moreIdentifiers                                      #funParametersRule
                    ;

moreIdentifiers : (COMA IDENT)*                                                 #moreIdentsRule
                ;

hashLiteral :CORCHETEIZQ hashContent moreHashContent CORCHETEDER                #hashLiteralRule
            ;

hashContent : expression DP expression                                          #hashContRule
            ;

moreHashContent :(COMA hashContent)*                                            #moreHashContRule
                ;

expressionList : expression moreExpressions                                     #expreListExpre
               | EOF                                                            #expreListEOF
               ;

moreExpressions :(COMA expression)*                                             #moreExpreRule
                ;

printExpression :PUTS PIZQ expression PDER                                      #printExpreRule
                ;

ifExpression    :IF expression blockStatement (ELSE blockStatement | EOF)       #ifExpreRule
                ;

blockStatement  : CORCHETEIZQ statement* CORCHETEDER                            #blockStatRule
                ;
