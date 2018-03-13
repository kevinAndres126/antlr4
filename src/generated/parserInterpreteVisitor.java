// Generated from /home/kevin/Escritorio/Compiladores/prograAntrl4/src/parserInterprete.g4 by ANTLR 4.7
package generated;
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
	 * Visit a parse tree produced by {@link parserInterprete#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(parserInterprete.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(parserInterprete.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#letStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStatement(parserInterprete.LetStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(parserInterprete.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(parserInterprete.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(parserInterprete.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(parserInterprete.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#additionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionExpression(parserInterprete.AdditionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#additionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditionFactor(parserInterprete.AdditionFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#multiplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationExpression(parserInterprete.MultiplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#multiplicationFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicationFactor(parserInterprete.MultiplicationFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#elementExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementExpression(parserInterprete.ElementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#elementAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementAccess(parserInterprete.ElementAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(parserInterprete.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#primitiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveExpression(parserInterprete.PrimitiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#arrayFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayFunctions(parserInterprete.ArrayFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(parserInterprete.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteral(parserInterprete.FunctionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#functionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(parserInterprete.FunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#moreIdentifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreIdentifiers(parserInterprete.MoreIdentifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#hashLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashLiteral(parserInterprete.HashLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#hashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHashContent(parserInterprete.HashContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#moreHashContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreHashContent(parserInterprete.MoreHashContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(parserInterprete.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#moreExpressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreExpressions(parserInterprete.MoreExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpression(parserInterprete.PrintExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(parserInterprete.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parserInterprete#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(parserInterprete.BlockStatementContext ctx);
}