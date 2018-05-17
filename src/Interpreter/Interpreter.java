package Interpreter;

import G4.parserInterprete;
import G4.parserInterpreteBaseVisitor;

public class Interpreter extends parserInterpreteBaseVisitor{

    private DataStorage dataStorage = null;
    private EvaluationStack evaluationStack = null;

    public Interpreter(){
        this.dataStorage = new DataStorage();
        this.evaluationStack = new EvaluationStack();
    }

    @Override
    public Object visitPrograstate(parserInterprete.PrograstateContext ctx) {
        return null;
    }

    @Override
    public Object visitStatelet(parserInterprete.StateletContext ctx) {
        return null;
    }

    @Override
    public Object visitStatereturn(parserInterprete.StatereturnContext ctx) {
        return null;
    }

    @Override
    public Object visitStateexpre(parserInterprete.StateexpreContext ctx) {
        return null;
    }

    @Override
    public Object visitStateletRule(parserInterprete.StateletRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitStatereturnRule(parserInterprete.StatereturnRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitStateexpreRule(parserInterprete.StateexpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitExpreRule(parserInterprete.ExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitComparRule(parserInterprete.ComparRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitAddExpreRule(parserInterprete.AddExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitAddFactRule(parserInterprete.AddFactRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitMultiFactRule(parserInterprete.MultiFactRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitCallExpreRule(parserInterprete.CallExpreRuleContext ctx) {
        return super.visitCallExpreRule(ctx);
    }

    @Override
    public Object visitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx) {
        return null;
    }

    @Override
    public Object visitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunLen(parserInterprete.ArrayFunLenContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunFist(parserInterprete.ArrayFunFistContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunLast(parserInterprete.ArrayFunLastContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunRest(parserInterprete.ArrayFunRestContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayFunPush(parserInterprete.ArrayFunPushContext ctx) {
        return null;
    }

    @Override
    public Object visitArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitFunParametersRule(parserInterprete.FunParametersRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitHashContRule(parserInterprete.HashContRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitExpreListExpre(parserInterprete.ExpreListExpreContext ctx) {
        return null;
    }

    @Override
    public Object visitExpreListEOF(parserInterprete.ExpreListEOFContext ctx) {
        return null;
    }

    @Override
    public Object visitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitIfExpreRule(parserInterprete.IfExpreRuleContext ctx) {
        return null;
    }

    @Override
    public Object visitBlockStatRule(parserInterprete.BlockStatRuleContext ctx) {
        return null;
    }
}
