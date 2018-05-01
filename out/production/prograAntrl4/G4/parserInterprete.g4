parser grammar parserInterprete;

options {
    tokenVocab = lexerInterprete;
}

program     :(statement)*                                                       #prograstate
            ;

statement   : LET letStatement                                                  #statelet
            | RETURN returnStatement                                            #statereturn
            | expressionStatement                                               #stateexpre
            ;

letStatement    : ID ASIGN expression (PyCOMA | )                           #stateletRule
                ;

returnStatement :expression (PyCOMA | )                                      #statereturnRule
                ;

expressionStatement :expression (PyCOMA | )                                  #stateexpreRule
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

elementExpression   :primitiveExpression (elementAccess|callExpression | )    #elemExpreRule
                    ;

elementAccess   :CORCHETEIZQ expression CORCHETEDER                             #elemAccesRule
                ;

callExpression  :PIZQ expressionList PDER                                       #callExpreRule
                ;

primitiveExpression :INTEGER                                                    #primiExpreInt
                    | STRING                                                    #primiExpreStr
                    | ID                                                        #primiExpreIdent
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

functionParameters  :ID moreIdentifiers                                         #funParametersRule
                    ;

moreIdentifiers : (COMA ID)*                                                    #moreIdentsRule
                ;

hashLiteral :LLAVEIZQ hashContent moreHashContent LLAVEDER                #hashLiteralRule
            ;

hashContent : expression DP expression                                          #hashContRule
            ;

moreHashContent :(COMA hashContent)*                                            #moreHashContRule
                ;

expressionList : expression moreExpressions                                     #expreListExpre
               |                                                                #expreListEOF
               ;

moreExpressions :(COMA expression)*                                             #moreExpreRule
                ;

printExpression :PUTS PIZQ expression PDER                                      #printExpreRule
                ;

ifExpression    :IF expression blockStatement (ELSE blockStatement | )       #ifExpreRule
                ;

blockStatement  : LLAVEIZQ statement* LLAVEDER                            #blockStatRule
                ;
