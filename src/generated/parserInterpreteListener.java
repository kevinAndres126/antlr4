// Generated from /home/kevin/Escritorio/Compiladores/prograAntrl4/src/parserInterprete.g4 by ANTLR 4.7
package generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parserInterprete}.
 */
public interface parserInterpreteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(parserInterprete.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(parserInterprete.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(parserInterprete.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(parserInterprete.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 */
	void enterLetStatement(parserInterprete.LetStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 */
	void exitLetStatement(parserInterprete.LetStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(parserInterprete.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(parserInterprete.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(parserInterprete.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(parserInterprete.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(parserInterprete.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(parserInterprete.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(parserInterprete.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(parserInterprete.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(parserInterprete.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(parserInterprete.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 */
	void enterAdditionFactor(parserInterprete.AdditionFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 */
	void exitAdditionFactor(parserInterprete.AdditionFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(parserInterprete.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(parserInterprete.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationFactor(parserInterprete.MultiplicationFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationFactor(parserInterprete.MultiplicationFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 */
	void enterElementExpression(parserInterprete.ElementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 */
	void exitElementExpression(parserInterprete.ElementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 */
	void enterElementAccess(parserInterprete.ElementAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 */
	void exitElementAccess(parserInterprete.ElementAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpression(parserInterprete.CallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpression(parserInterprete.CallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveExpression(parserInterprete.PrimitiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveExpression(parserInterprete.PrimitiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void enterArrayFunctions(parserInterprete.ArrayFunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 */
	void exitArrayFunctions(parserInterprete.ArrayFunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(parserInterprete.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(parserInterprete.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFunctionLiteral(parserInterprete.FunctionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFunctionLiteral(parserInterprete.FunctionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(parserInterprete.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(parserInterprete.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void enterMoreIdentifiers(parserInterprete.MoreIdentifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 */
	void exitMoreIdentifiers(parserInterprete.MoreIdentifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void enterHashLiteral(parserInterprete.HashLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 */
	void exitHashLiteral(parserInterprete.HashLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 */
	void enterHashContent(parserInterprete.HashContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 */
	void exitHashContent(parserInterprete.HashContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void enterMoreHashContent(parserInterprete.MoreHashContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 */
	void exitMoreHashContent(parserInterprete.MoreHashContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(parserInterprete.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(parserInterprete.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void enterMoreExpressions(parserInterprete.MoreExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 */
	void exitMoreExpressions(parserInterprete.MoreExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpression(parserInterprete.PrintExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpression(parserInterprete.PrintExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(parserInterprete.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(parserInterprete.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(parserInterprete.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(parserInterprete.BlockStatementContext ctx);
}