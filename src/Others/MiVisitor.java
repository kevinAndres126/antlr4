package Others;

import G4.parserInterprete;
import G4.parserInterpreteBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        this.tablaIDs.openScope();
        for(parserInterprete.StatementContext ele : ctx.statement()){
            visit(ele);
        }
        this.tablaIDs.closeScope();
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
        //System.out.println(ctx.getClass().getName())
        String tipo = (String) visit(ctx.expression());
       // System.out.println(tipo);
        if (tipo.equals("ExpresExpres")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),5,ctx,tipo);
        }
        else if (tipo.equals("ArrayLiteral")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),6,ctx,tipo);
        }
        else if (tipo.equals("ArrayFuntion")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),7,ctx,tipo);
        }
        else if (tipo.equals("neutral")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),8,ctx,tipo);
        }
        else if (tipo.equals("ExpreHash")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),9,ctx,tipo);
        }
        else if (tipo.equals("Print")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),10,ctx,tipo);
        }
        else if (tipo.equals("IFExprs")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),11,ctx,tipo);
        }
        else if (tipo.equals("true")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),3,ctx,tipo);
        }
        else if (tipo.equals("false")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),3,ctx,tipo);
        }
        else if (tipo.contains("#")){
            //System.out.println(tipo);
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),2,ctx,tipo.substring(1,tipo.length()));
        }
        else if (tipo.contains("*")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),1,ctx,tipo.substring(1,tipo.length()));
        }else {
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),0,ctx,tipo);
        }

        //this.tablaIDs.imprimir();
        //System.out.println(tipo);
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
        String resultAdExp = (String) visit(ctx.additionExpression());

        if (visit(ctx.comparison()) != null){

            ArrayList<String> compare = (ArrayList<String>) visit(ctx.comparison());
            for (String value: compare) {
                String varDosComp = value;
                int lenResult =resultAdExp.length();
                int lenVarDos =varDosComp.length();

                String tempResult = resultAdExp.substring(1, lenResult);
                String tempVarDos = varDosComp.substring(1,lenVarDos);

                int varUnoType = this.tablaIDs.buscar(tempResult);
                int varDosType = this.tablaIDs.buscar(tempVarDos);
                if (varUnoType == -1){
                    if (resultAdExp.contains("#")){
                        String error = "El identificador " + "'" + tempResult +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varUnoType = 2;
                    }else if (resultAdExp.contains("*")){
                        varUnoType = 1;
                    }else if (resultAdExp.equals("true") || resultAdExp.equals("false")){
                        varUnoType = 3;
                    } else {
                        varUnoType = 0;
                    }
                }
                if(varDosType == -1){
                    if (varDosComp.contains("#")){
                        String error = "El identificador " + "'" + tempVarDos +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varDosType = 2;
                    }else if (varDosComp.contains("*")){
                        varDosType = 1;
                    }else if (varDosComp.equals("true") || varDosComp.equals("false")){
                        varDosType = 3;
                    }else {
                        varDosType = 0;
                    }
                }


                if (varUnoType != varDosType){
                    if (resultAdExp.contains("#") || resultAdExp.contains("*")){
                        resultAdExp = tempResult;
                    }
                    if (varDosComp.contains("#") || varDosComp.contains("*")){
                        varDosComp = tempVarDos;
                    }
                    String error = "Error de tipos, en comparacion de variables " + "'" + resultAdExp+ "'" + " y " + "'" + varDosComp+ "'";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);


                }
            }

        }

        return resultAdExp;
    }

    @Override
    public Object visitComparRule(parserInterprete.ComparRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.AdditionExpressionContext ele : ctx.additionExpression()){
            compare.add((String) visit(ele));

        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }
    }

    @Override
    public Object visitAddExpreRule(parserInterprete.AddExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());

        String resultAdExp = (String) visit(ctx.multiplicationExpression());

        if (visit(ctx.additionFactor()) != null){

            ArrayList<String> compare = (ArrayList<String>) visit(ctx.additionFactor());
            for (String value: compare) {
                String varDosComp = value;
                int lenResult =resultAdExp.length();
                int lenVarDos =varDosComp.length();

                String tempResult = resultAdExp.substring(1, lenResult);
                String tempVarDos = varDosComp.substring(1,lenVarDos);

                int varUnoType = this.tablaIDs.buscar(tempResult);
                int varDosType = this.tablaIDs.buscar(tempVarDos);
                if (varUnoType == -1){
                    if (resultAdExp.contains("#")){
                        String error = "El identificador " + "'" + tempResult +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varUnoType = 2;
                    }else if (resultAdExp.contains("*")){
                        varUnoType = 1;
                    }else if (resultAdExp.equals("true") || resultAdExp.equals("false")){
                        varUnoType = 3;
                    } else {
                        varUnoType = 0;
                    }
                }
                if(varDosType == -1){
                    if (varDosComp.contains("#")){
                        String error = "El identificador " + "'" + tempVarDos +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varDosType = 2;
                    }else if (varDosComp.contains("*")){
                        varDosType = 1;
                    }else if (varDosComp.equals("true") || varDosComp.equals("false")){
                        varDosType = 3;
                    }else {
                        varDosType = 0;
                    }
                }


                if (varUnoType != varDosType){
                    if (resultAdExp.contains("#") || resultAdExp.contains("*")){
                        resultAdExp = tempResult;
                    }
                    if (varDosComp.contains("#") || varDosComp.contains("*")){
                        varDosComp = tempVarDos;
                    }
                    String error = "Error de tipos, en operacion "+ resultAdExp + ctx.children.get(1).getText();
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);

                }
            }

        }

        return resultAdExp;
    }

    @Override
    public Object visitAddFactRule(parserInterprete.AddFactRuleContext ctx) {

        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.MultiplicationExpressionContext ele : ctx.multiplicationExpression()){
            compare.add((String) visit(ele));
        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }
    }

    @Override
    public Object visitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        String resultAdExp = (String) visit(ctx.elementExpression());


        if (visit(ctx.multiplicationFactor()) != null){

            ArrayList<String> compare = (ArrayList<String>) visit(ctx.multiplicationFactor());
            for (String value: compare) {
                String varDosComp = value;
                int lenResult =resultAdExp.length();
                int lenVarDos =varDosComp.length();

                String tempResult = resultAdExp.substring(1, lenResult);
                String tempVarDos = varDosComp.substring(1,lenVarDos);

                int varUnoType = this.tablaIDs.buscar(tempResult);
                int varDosType = this.tablaIDs.buscar(tempVarDos);
                if (varUnoType == -1){
                    if (resultAdExp.contains("#")){
                        String error = "El identificador " + "'" + tempResult +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varUnoType = 2;
                    }else if (resultAdExp.contains("*")){
                        varUnoType = 1;
                    }else if (resultAdExp.equals("true") || resultAdExp.equals("false")){
                        varUnoType = 3;
                    } else {
                        varUnoType = 0;
                    }
                }
                if(varDosType == -1){
                    if (varDosComp.contains("#")){
                        String error = "El identificador " + "'" + tempVarDos +  "'" + " no ha sido declarado.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                        varDosType = 2;
                    }else if (varDosComp.contains("*")){
                        varDosType = 1;
                    }else if (varDosComp.equals("true") || varDosComp.equals("false")){
                        varDosType = 3;
                    }else {
                        varDosType = 0;
                    }
                }

                if (resultAdExp.contains("#") || resultAdExp.contains("*")){
                    resultAdExp = tempResult;
                }
                if (varDosComp.contains("#") || varDosComp.contains("*")) {
                    varDosComp = tempVarDos;
                }
                System.out.println(ctx.multiplicationFactor().getChild(0).getText());
                if ((varDosType == 0 && varDosComp.equals("0") || varDosType == 0 && tablaIDs.buscarValor(tempVarDos).equals("0")) && ctx.multiplicationFactor().getChild(0).getText().equals("/")){
                    String error = "Operacion invalida,Division por cero en operacion "+ resultAdExp + ctx.children.get(1).getText();
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
                if (varUnoType != varDosType){
                    String error = "Error de tipos, en operacion "+ resultAdExp + ctx.children.get(1).getText();
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
            }
        }
        return resultAdExp;
    }

    @Override
    public Object visitMultiFactRule(parserInterprete.MultiFactRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.ElementExpressionContext ele : ctx.elementExpression()){
            compare.add((String) visit(ele));
        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }

    }

    @Override
    public Object visitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        String result = (String) visit(ctx.primitiveExpression());
        int lenResult = result.length();
        if (ctx.elementAccess()!= null){
            System.out.println(tablaIDs.buscar(result.substring(1,lenResult)));
            String resultelement = (String) visit(ctx.elementAccess());
            if (resultelement != null){
                if (tablaIDs.buscar(result.substring(1,lenResult)) != 6){
                    if (tablaIDs.buscar(result.substring(1,lenResult)) == 2){
                        String error = "Error, la variable '"+ result.substring(1,lenResult) +"' no es tipo array.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }
                    else if (tablaIDs.buscar(result.substring(1,lenResult)) == 8){
                        String error = "Error, variable '"+ result.substring(1,lenResult) +"' de tipo funcion, no valida";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }else {
                        String error = "Error, el array '"+ result.substring(1,lenResult) +"' no a sido declarado o la expresion no es valida";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }
                }
            }
        }
        if (ctx.callExpression()!= null){
            String resultcall = (String) visit(ctx.callExpression());
            if (resultcall != null){
                if (tablaIDs.buscar(result.substring(1,lenResult)) != 8){
                    if (tablaIDs.buscar(result.substring(1,lenResult)) == 2){
                        String error = "Error, la variable '"+ result.substring(1,lenResult) +"' no es una funcion.";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }
                    else if (tablaIDs.buscar(result.substring(1,lenResult)) == 6){
                        String error = "Error, variable '"+ result.substring(1,lenResult) +"' de tipo array, no valida";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }else {
                        String error = "Error, la funcion '"+ result.substring(1,lenResult) +"' no a sido declarada o la expresion no es valida";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }
                }
            }
        }
        return result;    }

    @Override
    public Object visitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        return visit(ctx.expression());    }

    @Override
    public Object visitCallExpreRule(parserInterprete.CallExpreRuleContext ctx) {
       // System.out.println(ctx.getClass().getName());
        return visit(ctx.expressionList());
    }

    @Override
    public Object visitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.INTEGER().getSymbol().getText());
        return ctx.INTEGER().getSymbol().getText();    }

    @Override
    public Object visitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.STRING().getSymbol().getText());
        return "*"+ ctx.STRING().getSymbol().getText() ;    }

    @Override
    public Object visitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx) {
        //System.out.println(ctx.getClass().getName());
       // System.out.println(ctx.ID().getSymbol().getText());
        return "#"+ctx.ID().getSymbol().getText();    }

    @Override
    public Object visitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx) {
       // System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.TRUE().getSymbol().getText());
        return "true";    }

    @Override
    public Object visitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //System.out.println(ctx.FALSE().getSymbol().getText());
        return "false";    }

    @Override
    public Object visitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //llamada de metodos
        visit(ctx.expression());
        return "ExpresExpres";    }

    @Override
    public Object visitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.arrayLiteral());
        return "ArrayLiteral";    }

    @Override
    public Object visitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        return "ArrayFuntion";    }

    @Override
    public Object visitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx) {
        //System.out.println(ctx.getClass().getName());
        //Declaraciones de Metodos
        visit(ctx.functionLiteral());
        return "neutral";    }

    @Override
    public Object visitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.hashLiteral());
        return "ExpreHash";    }

    @Override
    public Object visitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.printExpression());
        return "Print";    }

    @Override
    public Object visitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx) {
        //System.out.println(ctx.getClass().getName());
        visit(ctx.ifExpression());
        return "IFExprs";    }

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
        this.tablaIDs.openScope();
        visit(ctx.blockStatement());
        this.tablaIDs.closeScope();
        return null;
    }

    //Funciones y parametros, se usa lista para validar
    @Override
    public Object visitFunParametersRule(parserInterprete.FunParametersRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        parametros.add(ctx.ID().getSymbol().getText());
        visit(ctx.moreIdentifiers());

        for (String ID: parametros) {
            //System.out.println(ID);
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
        String result = (String) visit(ctx.expression());
        if (result != null){
            if (result.equals("ExpresExpres")){
                String error = "Error, no se permiten expresiones de tipo () en colecciones de datos,ni como parametros en funciones."; //+ ctx.getParent().getChild(0) + ctx.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText()+ ctx.getParent().getChild(2) ;
                ThrowingErrorListener.INSTANCE.setErrorMessages(error);
            }
            if (result.equals("Print")){
                String error = "Error, no se permiten expresiones de impresion en colecciones de datos, ni como parametros en funciones. "; //+ ctx.getParent().getChild(0)+ctx.getParent().getChild(1)+ctx.getChild(0).getChild(0).getChild(0).getChild(0).getText()+ctx.getParent().getChild(3) ;
                ThrowingErrorListener.INSTANCE.setErrorMessages(error);
            }
            if (result.equals("IFExprs")){
                String error = "Error, no se permiten expresiones IF como parametros, ni en colecciones de datos.";
                ThrowingErrorListener.INSTANCE.setErrorMessages(error);
            }
        }
        visit(ctx.moreExpressions());

        return result;    }

    @Override
    public Object visitExpreListEOF(parserInterprete.ExpreListEOFContext ctx) {
        //System.out.println(ctx.getClass().getName());
        return null;    }

    @Override
    public Object visitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for(parserInterprete.ExpressionContext ele :ctx.expression() ){
            String result = (String) visit(ele);
           // System.out.println(result);
            if (result != null){
                if (result.equals("ExpresExpres")){
                    String error = "Error, no se permiten expresiones de tipo () en colecciones de datos,ni como parametros en funciones."; //+ ctx.getParent().getChild(0) + ctx.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText()+ ctx.getParent().getChild(2) ;
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
                if (result.equals("Print")){
                    String error = "Error, no se permiten expresiones de impresion en colecciones de datos, ni como parametros en funciones. "; //+ ctx.getParent().getChild(0)+ctx.getParent().getChild(1)+ctx.getChild(0).getChild(0).getChild(0).getChild(0).getText()+ctx.getParent().getChild(3) ;
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
                if (result.equals("IFExprs")){
                    String error = "Error, no se permiten expresiones IF como parametros, ni en colecciones de datos.";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
            }
        }
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
        this.tablaIDs.openScope();
        for(parserInterprete.BlockStatementContext ele :ctx.blockStatement() ){
            visit(ele);
        }
        this.tablaIDs.closeScope();
        return null;    }

    @Override
    public Object visitBlockStatRule(parserInterprete.BlockStatRuleContext ctx) {
        //System.out.println(ctx.getClass().getName());
        for(parserInterprete.StatementContext ele :ctx.statement() ){
            visit(ele);
        }
        return null;    }
}
