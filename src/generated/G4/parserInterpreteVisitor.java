// Generated from /home/kevin/Documents/Compiladores/PrograCompi2/2.0/antlr4/src/G4/parserInterprete.g4 by ANTLR 4.7
package G4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link parserInterprete}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface parserInterpreteVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code prograstate}
	 * labeled alternative in {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograstate(parserInterprete.PrograstateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statelet}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatelet(parserInterprete.StateletContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statereturn}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatereturn(parserInterprete.StatereturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateexpre}
	 * labeled alternative in {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateexpre(parserInterprete.StateexpreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateletRule}
	 * labeled alternative in {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateletRule(parserInterprete.StateletRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statereturnRule}
	 * labeled alternative in {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatereturnRule(parserInterprete.StatereturnRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stateexpreRule}
	 * labeled alternative in {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStateexpreRule(parserInterprete.StateexpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expreRule}
	 * labeled alternative in {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpreRule(parserInterprete.ExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparRule}
	 * labeled alternative in {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparRule(parserInterprete.ComparRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpreRule}
	 * labeled alternative in {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpreRule(parserInterprete.AddExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addFactRule}
	 * labeled alternative in {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddFactRule(parserInterprete.AddFactRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiExpresRule}
	 * labeled alternative in {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiFactRule}
	 * labeled alternative in {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiFactRule(parserInterprete.MultiFactRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elemExpreRule}
	 * labeled alternative in {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code elemAccesRule}
	 * labeled alternative in {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpreRule}
	 * labeled alternative in {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpreRule(parserInterprete.CallExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreInt}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreStr}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreIdent}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreTrue}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreFalse}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreExpres}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpresArrayliteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreArrayFuntions}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreFuntionLiteral}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreHash}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExprePrint}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primiExpreIf}
	 * labeled alternative in {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayFunLen}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunLen(parserInterprete.ArrayFunLenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayFunFist}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunFist(parserInterprete.ArrayFunFistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayFunLast}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunLast(parserInterprete.ArrayFunLastContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayFunRest}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunRest(parserInterprete.ArrayFunRestContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayFunPush}
	 * labeled alternative in {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunPush(parserInterprete.ArrayFunPushContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteralRule}
	 * labeled alternative in {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funLiteralRule}
	 * labeled alternative in {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funParametersRule}
	 * labeled alternative in {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunParametersRule(parserInterprete.FunParametersRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreIdentsRule}
	 * labeled alternative in {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashLiteralRule}
	 * labeled alternative in {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code hashContRule}
	 * labeled alternative in {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashContRule(parserInterprete.HashContRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreHashContRule}
	 * labeled alternative in {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expreListExpre}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpreListExpre(parserInterprete.ExpreListExpreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expreListEOF}
	 * labeled alternative in {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpreListEOF(parserInterprete.ExpreListEOFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code moreExpreRule}
	 * labeled alternative in {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpreRule}
	 * labeled alternative in {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExpreRule}
	 * labeled alternative in {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpreRule(parserInterprete.IfExpreRuleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatRule}
	 * labeled alternative in {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatRule(parserInterprete.BlockStatRuleContext ctx);
}