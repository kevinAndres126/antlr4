// Generated from /home/kevin/Documents/Compiladores/PrograCompi2/2.0/antlr4/src/G4/parserInterprete.g4 by ANTLR 4.7
package G4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parserInterprete}.
 */
public interface parserInterpreteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code prograstate}
	 * labeled alternative in {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 */
	void enterPrograstate(parserInterprete.PrograstateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prograstate}
	 * labeled alternative in {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 */
	void exitPrograstate(parserInterprete.PrograstateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statelet}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatelet(parserInterprete.StateletContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statelet}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatelet(parserInterprete.StateletContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statereturn}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatereturn(parserInterprete.StatereturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statereturn}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatereturn(parserInterprete.StatereturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stateexpre}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void enterStateexpre(parserInterprete.StateexpreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stateexpre}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void exitStateexpre(parserInterprete.StateexpreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stateletRule}
	 * labeled alternative in {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterStateletRule(parserInterprete.StateletRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stateletRule}
	 * labeled alternative in {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitStateletRule(parserInterprete.StateletRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statereturnRule}
	 * labeled alternative in {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterStatereturnRule(parserInterprete.StatereturnRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statereturnRule}
	 * labeled alternative in {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitStatereturnRule(parserInterprete.StatereturnRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stateexpreRule}
	 * labeled alternative in {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterStateexpreRule(parserInterprete.StateexpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stateexpreRule}
	 * labeled alternative in {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitStateexpreRule(parserInterprete.StateexpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expreRule}
	 * labeled alternative in {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpreRule(parserInterprete.ExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expreRule}
	 * labeled alternative in {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpreRule(parserInterprete.ExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparRule}
	 * labeled alternative in {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparRule(parserInterprete.ComparRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparRule}
	 * labeled alternative in {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparRule(parserInterprete.ComparRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpreRule}
	 * labeled alternative in {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpreRule(parserInterprete.AddExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpreRule}
	 * labeled alternative in {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpreRule(parserInterprete.AddExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addFactRule}
	 * labeled alternative in {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 */
	void enterAddFactRule(parserInterprete.AddFactRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addFactRule}
	 * labeled alternative in {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 */
	void exitAddFactRule(parserInterprete.AddFactRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiExpresRule}
	 * labeled alternative in {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiExpresRule}
	 * labeled alternative in {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiFactRule}
	 * labeled alternative in {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void enterMultiFactRule(parserInterprete.MultiFactRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiFactRule}
	 * labeled alternative in {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void exitMultiFactRule(parserInterprete.MultiFactRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elemExpreRule}
	 * labeled alternative in {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterElemExpreRule(parserInterprete.ElemExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elemExpreRule}
	 * labeled alternative in {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elemAccesRule}
	 * labeled alternative in {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 */
	void enterElemAccesRule(parserInterprete.ElemAccesRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elemAccesRule}
	 * labeled alternative in {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 */
	void exitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpreRule}
	 * labeled alternative in {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpreRule(parserInterprete.CallExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpreRule}
	 * labeled alternative in {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpreRule(parserInterprete.CallExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreInt}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreInt}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreStr}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreStr}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreIdent}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreIdent}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreTrue}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreTrue}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreFalse}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreFalse}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreExpres}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreExpres}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpresArrayliteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpresArrayliteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreArrayFuntions}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreArrayFuntions}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreFuntionLiteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreFuntionLiteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreHash}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreHash}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExprePrint}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExprePrint}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primiExpreIf}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primiExpreIf}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFunLen}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunLen(parserInterprete.ArrayFunLenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFunLen}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunLen(parserInterprete.ArrayFunLenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFunFist}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunFist(parserInterprete.ArrayFunFistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFunFist}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunFist(parserInterprete.ArrayFunFistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFunLast}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunLast(parserInterprete.ArrayFunLastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFunLast}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunLast(parserInterprete.ArrayFunLastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFunRest}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunRest(parserInterprete.ArrayFunRestContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFunRest}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunRest(parserInterprete.ArrayFunRestContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayFunPush}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunPush(parserInterprete.ArrayFunPushContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayFunPush}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunPush(parserInterprete.ArrayFunPushContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLiteralRule}
	 * labeled alternative in {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLiteralRule}
	 * labeled alternative in {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funLiteralRule}
	 * labeled alternative in {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funLiteralRule}
	 * labeled alternative in {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funParametersRule}
	 * labeled alternative in {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunParametersRule(parserInterprete.FunParametersRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funParametersRule}
	 * labeled alternative in {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunParametersRule(parserInterprete.FunParametersRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreIdentsRule}
	 * labeled alternative in {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void enterMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreIdentsRule}
	 * labeled alternative in {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void exitMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashLiteralRule}
	 * labeled alternative in {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashLiteralRule}
	 * labeled alternative in {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hashContRule}
	 * labeled alternative in {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 */
	void enterHashContRule(parserInterprete.HashContRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hashContRule}
	 * labeled alternative in {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 */
	void exitHashContRule(parserInterprete.HashContRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreHashContRule}
	 * labeled alternative in {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void enterMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreHashContRule}
	 * labeled alternative in {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void exitMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expreListExpre}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpreListExpre(parserInterprete.ExpreListExpreContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expreListExpre}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpreListExpre(parserInterprete.ExpreListExpreContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expreListEOF}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpreListEOF(parserInterprete.ExpreListEOFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expreListEOF}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpreListEOF(parserInterprete.ExpreListEOFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code moreExpreRule}
	 * labeled alternative in {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void enterMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code moreExpreRule}
	 * labeled alternative in {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void exitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpreRule}
	 * labeled alternative in {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpreRule}
	 * labeled alternative in {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExpreRule}
	 * labeled alternative in {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpreRule(parserInterprete.IfExpreRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExpreRule}
	 * labeled alternative in {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpreRule(parserInterprete.IfExpreRuleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatRule}
	 * labeled alternative in {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatRule(parserInterprete.BlockStatRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatRule}
	 * labeled alternative in {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatRule(parserInterprete.BlockStatRuleContext ctx);
}