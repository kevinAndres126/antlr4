package Others;

import G4.parserInterprete;
import G4.parserInterpreteBaseVisitor;
import jdk.internal.org.objectweb.asm.tree.analysis.Interpreter;
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
    private String funcionActual= "";
    private SymbolTable tablaIDs;

    public MiVisitor() {
        this.parametros = new ArrayList<>();
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
        visit(ctx.letStatement());
        return null;    }

    @Override
    public Object visitStatereturn(parserInterprete.StatereturnContext ctx) {
        visit(ctx.returnStatement());
        return null;    }

    @Override
    public Object visitStateexpre(parserInterprete.StateexpreContext ctx) {
        visit(ctx.expressionStatement());
        return null;    }

    @Override
    public Object visitStateletRule(parserInterprete.StateletRuleContext ctx) {
        ArrayList<String> tempArray = (ArrayList<String>) visit(ctx.expression());
        System.out.println(tempArray);
        String tipo = tempArray.get(0);
        tempArray.remove(0) ;
        System.out.println(tempArray);

        if (tipo.equals("ExpresExpres")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),5,ctx,tipo,tempArray);
        }
        else if (tipo.equals("ArrayLiteral")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),6,ctx,tipo,tempArray);
        }
        else if (tipo.equals("ArrayFuntion")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),7,ctx,tipo,tempArray);
        }
        else if (tipo.equals("neutral")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),8,ctx,tipo,tempArray);
        }
        else if (tipo.equals("ExpreHash")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),9,ctx,tipo,tempArray);
        }
        else if (tipo.equals("Print")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),10,ctx,tipo,tempArray);
        }
        else if (tipo.equals("IFExprs")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),11,ctx,tipo,tempArray);
        }
        else if (tipo.equals("true")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),3,ctx,tipo,tempArray);
        }
        else if (tipo.equals("false")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),3,ctx,tipo,tempArray);
        }
        else if (tipo.contains("#")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),2,ctx,tipo.substring(1,tipo.length()),tempArray);
        }
        else if (tipo.contains("*")){
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),1,ctx,tipo.substring(1,tipo.length()),tempArray);
        }else {
            this.tablaIDs.insertar(ctx.ID().getSymbol().getText(),0,ctx,tipo,tempArray);
        }

        this.tablaIDs.imprimir();
        return null;    }

    @Override
    public Object visitStatereturnRule(parserInterprete.StatereturnRuleContext ctx) {
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitStateexpreRule(parserInterprete.StateexpreRuleContext ctx) {
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitExpreRule(parserInterprete.ExpreRuleContext ctx) {

        String resultAdExp;
        ArrayList<String> resulttemp = (ArrayList<String>) visit(ctx.additionExpression());
        resultAdExp = resulttemp.get(0);

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

        return resulttemp;
    }

    @Override
    public Object visitComparRule(parserInterprete.ComparRuleContext ctx) {
        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.AdditionExpressionContext ele : ctx.additionExpression()){
            ArrayList<String> temp;
            temp = (ArrayList<String>) visit(ele);
            compare.add(temp.get(0));

        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }
    }

    @Override
    public Object visitAddExpreRule(parserInterprete.AddExpreRuleContext ctx) {
        String resultAdExp;
        ArrayList<String> resulttemp = (ArrayList<String>) visit(ctx.multiplicationExpression());
        resultAdExp = resulttemp.get(0);

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

        return resulttemp;
    }

    @Override
    public Object visitAddFactRule(parserInterprete.AddFactRuleContext ctx) {

        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.MultiplicationExpressionContext ele : ctx.multiplicationExpression()){
            ArrayList<String> temp;
            temp = (ArrayList<String>) visit(ele);
            compare.add(temp.get(0));
        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }
    }

    @Override
    public Object visitMultiExpresRule(parserInterprete.MultiExpresRuleContext ctx) {
        String resultAdExp;
        ArrayList<String> resulttemp = (ArrayList<String>) visit(ctx.elementExpression());
        resultAdExp = resulttemp.get(0);

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
        return resulttemp;
    }

    @Override
    public Object visitMultiFactRule(parserInterprete.MultiFactRuleContext ctx) {
        ArrayList<String> compare = new ArrayList<>();
        for(parserInterprete.ElementExpressionContext ele : ctx.elementExpression()){
            ArrayList<String> temp;
            temp = (ArrayList<String>) visit(ele);
            compare.add(temp.get(0));
        }

        if (compare.size() == 0){
            return null;
        }else {
            return compare;
        }

    }

    @Override
    public Object visitElemExpreRule(parserInterprete.ElemExpreRuleContext ctx) {
        String result;
        ArrayList<String> resulttemp = (ArrayList<String>) visit(ctx.primitiveExpression());
        result = resulttemp.get(0);

        int lenResult = result.length();

        if (ctx.elementAccess()!= null){
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
            int resultcall =  (Integer) visit(ctx.callExpression());

            if (resultcall != -2){
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
                ArrayList<String> temp = tablaIDs.getArrayList(result.substring(1,lenResult));
                if (temp.size() != resultcall){
                    if (temp.size() > resultcall){
                        String error = "Error, Faltan parametros en la funcion '"+ result.substring(1,lenResult) +"'";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }else{
                        String error = "Error, Sobran parametros en la funcion '"+ result.substring(1,lenResult) +"'";
                        ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                    }
                }
            }
        }

        return resulttemp;    }

    @Override
    public Object visitElemAccesRule(parserInterprete.ElemAccesRuleContext ctx) {
        return visit(ctx.expression());    }

    @Override
    public Object visitCallExpreRule(parserInterprete.CallExpreRuleContext ctx) {
        return visit(ctx.expressionList());
    }

    @Override
    public Object visitPrimiExpreInt(parserInterprete.PrimiExpreIntContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add(ctx.INTEGER().getSymbol().getText());
        return temp;    }

    @Override
    public Object visitPrimiExpreStr(parserInterprete.PrimiExpreStrContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("*"+ctx.STRING().getSymbol().getText());
        return temp ;    }

    @Override
    public Object visitPrimiExpreIdent(parserInterprete.PrimiExpreIdentContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("#"+ctx.ID().getSymbol().getText());
        return temp;    }

    @Override
    public Object visitPrimiExpreTrue(parserInterprete.PrimiExpreTrueContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("true");
        return temp;    }

    @Override
    public Object visitPrimiExpreFalse(parserInterprete.PrimiExpreFalseContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("false");
        return temp;    }

    @Override
    public Object visitPrimiExpreExpres(parserInterprete.PrimiExpreExpresContext ctx) {
        visit(ctx.expression());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("ExpresExpres");
        return temp;    }

    @Override
    public Object visitPrimiExpresArrayliteral(parserInterprete.PrimiExpresArrayliteralContext ctx) {
        visit(ctx.arrayLiteral());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("ArrayLiteral");
        return temp;   }

    @Override
    public Object visitPrimiExpreArrayFuntions(parserInterprete.PrimiExpreArrayFuntionsContext ctx) {
        visit(ctx.arrayFunctions());
        visit(ctx.expressionList());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("ArrayFuntion");
        return temp;   }

    @Override
    public Object visitPrimiExpreFuntionLiteral(parserInterprete.PrimiExpreFuntionLiteralContext ctx) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("neutral");
        temp.addAll((ArrayList<String>) visit(ctx.functionLiteral()));

        return temp;    }

    @Override
    public Object visitPrimiExpreHash(parserInterprete.PrimiExpreHashContext ctx) {
        visit(ctx.hashLiteral());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("ExpreHash");
        return temp;    }

    @Override
    public Object visitPrimiExprePrint(parserInterprete.PrimiExprePrintContext ctx) {
        visit(ctx.printExpression());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("Print");
        return temp;    }

    @Override
    public Object visitPrimiExpreIf(parserInterprete.PrimiExpreIfContext ctx) {
        visit(ctx.ifExpression());
        ArrayList<String> temp = new ArrayList<>();
        temp.add("IFExprs");
        return temp;    }

    @Override
    public Object visitArrayFunLen(parserInterprete.ArrayFunLenContext ctx) {
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunFist(parserInterprete.ArrayFunFistContext ctx) {
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunLast(parserInterprete.ArrayFunLastContext ctx) {
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunRest(parserInterprete.ArrayFunRestContext ctx) {
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayFunPush(parserInterprete.ArrayFunPushContext ctx) {
        //Programar lo que sea que haga el metodo
        return null;    }

    @Override
    public Object visitArrayLiteralRule(parserInterprete.ArrayLiteralRuleContext ctx) {
        visit(ctx.expressionList());
        return null;    }

    @Override
    public Object visitFunLiteralRule(parserInterprete.FunLiteralRuleContext ctx) {
        ArrayList<String> parameters = (ArrayList<String>) visit(ctx.functionParameters());
        this.tablaIDs.openScope();
        visit(ctx.blockStatement());
        this.tablaIDs.closeScope();
        return parameters;
    }

    //Funciones y parametros, se usa lista para validar
    @Override
    public Object visitFunParametersRule(parserInterprete.FunParametersRuleContext ctx) {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(ctx.ID().getSymbol().getText());
        parameters.addAll((ArrayList<String>) visit(ctx.moreIdentifiers()));
        return parameters;    }

    @Override
    public Object visitMoreIdentsRule(parserInterprete.MoreIdentsRuleContext ctx) {
        ArrayList<String> tempParameters= new ArrayList<>();
        for (TerminalNode ele : ctx.ID())
            tempParameters.add(ele.getSymbol().getText());
        return tempParameters;    }


    @Override
    public Object visitHashLiteralRule(parserInterprete.HashLiteralRuleContext ctx) {
        visit(ctx.hashContent());
        visit(ctx.moreHashContent());
        return null;    }

    @Override
    public Object visitHashContRule(parserInterprete.HashContRuleContext ctx) {
        visit(ctx.expression(0));
        visit(ctx.expression(1));
        return null;    }

    @Override
    public Object visitMoreHashContRule(parserInterprete.MoreHashContRuleContext ctx) {
        for(parserInterprete.HashContentContext ele : ctx.hashContent()){
            visit(ele);
        }
        return null;    }

    @Override
    public Object visitExpreListExpre(parserInterprete.ExpreListExpreContext ctx) {
        String result;
        ArrayList<String> resulttemp = (ArrayList<String>) visit(ctx.expression());
        result = resulttemp.get(0);

        ArrayList<String> parametros = new ArrayList<>();
        parametros.add(result);
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
        if("G4.parserInterprete$CallExpreRuleContext".equals(ctx.getParent().getClass().getName())){
            ArrayList<String> tempParametros = (ArrayList<String>) visit(ctx.moreExpressions());
            if (tempParametros!= null){
                parametros.addAll(tempParametros);
            }
            for (String parametro: parametros
                    ) {
                if (!tablaIDs.buscarTrueFalse(parametro.substring(1,parametro.length()))){
                    String error = "Error, el parametro '"+ parametro.substring(1,parametro.length()) +"' no a sido declarado";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
            }
        }

        return parametros.size();    }

    @Override
    public Object visitExpreListEOF(parserInterprete.ExpreListEOFContext ctx) {
        return 0;    }

    @Override
    public Object visitMoreExpreRule(parserInterprete.MoreExpreRuleContext ctx) {
        ArrayList<String> parametros = new ArrayList<>();
        for(parserInterprete.ExpressionContext ele :ctx.expression() ){
            ArrayList<String> temp;
            temp = (ArrayList<String>) visit(ele);
            String result = temp.get(0);
            if (result != null){
                if (result.equals("ExpresExpres")){
                    String error = "Error, no se permiten expresiones de tipo () en colecciones de datos,ni como parametros en funciones."; //+ ctx.getParent().getChild(0) + ctx.getChild(0).getChild(0).getChild(0).getChild(0).getChild(0).getText()+ ctx.getParent().getChild(2) ;
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
                if (result.equals("Print")){
                    String error = "Error, no se permiten expresiones de impresion en colecciones de datos, ni como parametros en funciones. "; //+ ctx.getParent().getChild(0)+ctx.getParent().getChild(1)+ctx.getChild(0).getChild(0).getChild(0).getChild(0).getText()+ctx.getParent().getChild(3) ;
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);

                }if (result.equals("IFExprs")){
                    String error = "Error, no se permiten expresiones IF como parametros, ni en colecciones de datos.";
                    ThrowingErrorListener.INSTANCE.setErrorMessages(error);
                }
            }
            if (!(result.equals("ExpresExpres") || result.equals("Print" ) || result.equals("IFExprs" ))){
                parametros.add(result);
            }

        }
        if (parametros.size() == 0){
            return null;
        }else {
            return parametros;
        }


    }

    @Override
    public Object visitPrintExpreRule(parserInterprete.PrintExpreRuleContext ctx) {
        visit(ctx.expression());
        return null;    }

    @Override
    public Object visitIfExpreRule(parserInterprete.IfExpreRuleContext ctx) {
        visit(ctx.expression());
        this.tablaIDs.openScope();
        for(parserInterprete.BlockStatementContext ele :ctx.blockStatement() ){
            visit(ele);
        }
        this.tablaIDs.closeScope();
        return null;    }

    @Override
    public Object visitBlockStatRule(parserInterprete.BlockStatRuleContext ctx) {
        tablaIDs.openScope();
        for(parserInterprete.StatementContext ele :ctx.statement() ){
            visit(ele);
        }
        tablaIDs.closeScope();
        return null;    }
}
