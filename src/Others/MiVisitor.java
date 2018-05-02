package Others;

import G4.parserInterprete;
import G4.parserInterpreteBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

/*
        0 = integer
        1 = string
        2 = identifier
        3 = true
        4 = false
        5 = expresion
        6 = arraLiteral
        7 = arrayFuntions
        8 = funtionLiteral
        9 = hashLiteral
        10 = printExpresion
        11 = ifExpresion
 */


public class MiVisitor extends parserInterpreteBaseVisitor {
    private ArrayList<String> parametros;
    private SymbolTable tablaIDs;

    public MiVisitor() {
        this.parametros = new ArrayList<String>();
        this.tablaIDs = new SymbolTable();
    }

    @Override
    public Object visitPrograstate(parserInterprete.PrograstateContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for(parserInterprete.StatementContext ele : ctx.statement()){
            visit(ele);
        }
        return null;
    }

    @Override
    public Object visitStatelet(parserInterprete.StateletContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.letStatement());
        return null;    }

    @Override
    public Object visitStatereturn(parserInterprete.StatereturnContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.returnStatement());
        return null;    }

    @Override
    public Object visitStateexpre(parserInterprete.StateexpreContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expressionStatement());
        return null;    }

    @Override
    public Object visitStateletRule(parserInterprete.StateletRuleContext ctx) {
        System.out.println(ctx.getClass().getName());
        int tipo = (Integer) visit(ctx.expression());
        this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),tipo,ctx);
        this.tablaIDs.imprimir();
        System.out.println(tipo);
        return null;    }

    @Override
    public Object visitStatereturnRule(parserInterprete.StatereturnRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitStateexpreRule(parserInterprete.StateexpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitExpreRule(parserInterprete.ExpreRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        int result = (Integer) visit(ctx.additionExpression());
        visit(ctx.comparison());
        return result;    }

    @Override
    public Object visitComparRule(parserInterprete.ComparRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for (parserInterprete.AdditionExpressionContext ele : ctx.additionExpression()){
            visit(ele);
        }

        return null;    }

    @Override
    public Object visitAddExpreRule(parserInterprete.AddExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        int result = (Integer) visit(ctx.multiplicationExpression());
        visit(ctx.additionFactor());
        return result;    }

    @Override
    public Object visitAddFactRule(parserInterprete.AddFactRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        for(parserInterprete.MultiplicationExpressionContext ele : ctx.multiplicationExpression()){
            visit(ele);
        }
        return null;    }

    @Override
    public Object visitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        int result = (Integer) visit(ctx.elementExpression());
        visit(ctx.multiplicationFactor());
        return result;    }

    @Override
    public Object visitMultiFactRule(parserInterprete.MultiFactRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        for (parserInterprete.ElementExpressionContext ele : ctx.elementExpression())
                visit(ele);
        return null;    }

    @Override
    public Object visitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        int result = (Integer) visit(ctx.primitiveExpression());
        if (ctx.callExpression() != null){
            visit(ctx.callExpression());
        }else if (ctx.elementAccess() != null){
            visit(ctx.elementAccess());
        }
        return result;    }

    @Override
    public Object visitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitCallExpreRule(parserInterprete.CallExpreRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        visit(ctx.expressionList());
        return null;    }

    @Override
    public Object visitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.INTEGER().getSymbol().getText());
        return 0;    }

    @Override
    public Object visitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.STRING().getSymbol().getText());
        return 1;    }

    @Override
    public Object visitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx) {
        //System.out.println(ctx.getClass().getName());
       // System.out.println(ctx.ID().getSymbol().getText());
        return 2;    }

    @Override
    public Object visitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx) {
       // System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.TRUE().getSymbol().getText());
        return 3;    }

    @Override
    public Object visitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.FALSE().getSymbol().getText());
        return 4;    }

    @Override
    public Object visitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //llamada de metodos
        visit(ctx.expression());
        return 5;    }

    @Override
    public Object visitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.arrayLiteral());
        return 6;    }

    @Override
    public Object visitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        return 7;    }

    @Override
    public Object visitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Declaraciones de Metodos
        visit(ctx.functionLiteral());
        return 8;    }

    @Override
    public Object visitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.hashLiteral());
        return 9;    }

    @Override
    public Object visitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.printExpression());
        return 10;    }

    @Override
    public Object visitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.ifExpression());
        return 11;    }

    @Override
    public Object visitArrayFunLen(parserInterprete.ArrayFunLenContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunFist(parserInterprete.ArrayFunFistContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunLast(parserInterprete.ArrayFunLastContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunRest(parserInterprete.ArrayFunRestContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunPush(parserInterprete.ArrayFunPushContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expressionList());
        return null;    }

    @Override
    public Object visitFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.functionParameters());
        visit(ctx.blockStatement());
        return null;
    }

    //Funciones y parametros, se usa lista para validar
    @Override
    public Object visitFunParametersRule(parserInterprete.FunParametersRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        parametros.add(ctx.ID().getSymbol().getText());
        visit(ctx.moreIdentifiers());

        for (String ID: parametros) {
            System.out.println(ID);
        }
        return null;    }

    @Override
    public Object visitMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for (TerminalNode ele : ctx.ID())
            parametros.add(ele.getSymbol().getText());
        return null;    }


    @Override
    public Object visitHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        return null;    }

    @Override
    public Object visitHashContRule(parserInterprete.HashContRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        return null;    }

    @Override
    public Object visitMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for(parserInterprete.HashContentContext ele : ctx.hashContent()){
            visit(ele);
        }
        return null;    }

    @Override
    public Object visitExpreListExpre(parserInterprete.ExpreListExpreContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        visit(ctx.moreExpressions());
        return null;    }

    @Override
    public Object visitExpreListEOF(parserInterprete.ExpreListEOFContext ctx) {
        //System.out.println(ctx.getClass().getName());
        return null;    }

    @Override
    public Object visitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx) {
        System.out.println(ctx.getClass().getName());
        for(parserInterprete.ExpressionContext ele :ctx.expression() ){
            visit(ele);}
        return null;    }

    @Override
    public Object visitPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitIfExpreRule(parserInterprete.IfExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.expression());
        for(parserInterprete.BlockStatementContext ele :ctx.blockStatement() ){
            visit(ele);}
        return null;    }

    @Override
    public Object visitBlockStatRule(parserInterprete.BlockStatRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for(parserInterprete.StatementContext ele :ctx.statement() ){
            visit(ele);}
        return null;    }
}
