package ast;

import ast.Types.BoolType;
import ast.Types.Type;
import ast.Types.VoidType;
import evaluator.SimpLanlib;
import ast.Types.ErrorType;
import symboltable.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Utils.CompareEnvironmentVariables;
import static utils.Utils.TakeDeclaredVariables;

/**
 * stm    : 'if' '(' exp ')' '{' left=stms '}' ('else' '{' right=stms '}')?                   #ifStm
 * **/
public class IfStmNode implements Node {
    private Node exp;
    private ArrayList<Node> thenbranch;
    private ArrayList<Node> elsebranch;

    private int nesting;

    public IfStmNode(Node _guard, ArrayList<Node> _thenbranch, ArrayList<Node> _elsebranch) {
        exp = _guard;
        thenbranch = _thenbranch;
        elsebranch = _elsebranch;
    }

    public IfStmNode(Node _guard, ArrayList<Node> _thenbranch) {
        exp = _guard;
        thenbranch = _thenbranch;
    }



    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("IfExpNode", _nesting);
        nesting = _nesting;
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(exp.checkSemantics(ST, nesting));
        HashMap<String, Boolean> V1 = new HashMap<String,Boolean>() ;
        ST.addVar(V1);
        for (Node d : thenbranch) {
            errors.addAll(d.checkSemantics(ST, nesting)) ;
        }
        ArrayList<String> V1List = TakeDeclaredVariables(V1);
        ST.removeVar();
        HashMap<String, Boolean> V2 = new HashMap<String,Boolean>() ;
        ST.addVar(V2);
        for (Node d : elsebranch) {
            errors.addAll(d.checkSemantics(ST, nesting)) ;
        }
        ArrayList<String> V2List = TakeDeclaredVariables(V2);
        ST.removeVar();
        ArrayList<String> FinalList= CompareEnvironmentVariables(V1List, V2List);
        for (String id: FinalList)
            ST.insertVar(id, true);
        return errors;
    }


    @Override
    public Type typeCheck() {
        if (exp.typeCheck() instanceof BoolType) {
//            Type thenexp = thenbranch.typeCheck() ;
//            Type elseexp = elsebranch.typeCheck() ;
//            if (thenexp.getClass().equals(elseexp.getClass()))
//                return thenexp;
//            else {
//                System.out.println("Type Error: incompatible types in then and else branches");
//                return new ErrorType() ;
//            }
            //non controllo il tipo di ritorno perché in questo caso non ritorno niente, quindi void
            return new VoidType();
        } else {
            System.out.println("Type Error: non boolean condition in if");
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {
        String lthen = SimpLanlib.freshLabel();
        String lend = SimpLanlib.freshLabel();
        String elseCode="";
        String thenCode="";
        for (Node d: elsebranch)
            elseCode += d.codeGeneration();
        for (Node s: thenbranch)
            thenCode += s.codeGeneration();
        return "//IfStmNode \n"+
                exp.codeGeneration() +
                "storei T1 1 \n" +
                "beq A0 T1 "+ lthen + "\n" +
                elseCode +
                "b " + lend + "\n" +
                lthen + ":\n" +
                thenCode +
                lend + ":\n" ;
    }

    @Override
    public String toPrint(String s) {
        String thenStmStr=s+"Then:\n";
        for (Node d : thenbranch)
            thenStmStr += d.toPrint(s+"  ");
        String elseStmStr=s+"Else:\n";
        if(elsebranch!= null){
            for (Node d : elsebranch)
                elseStmStr += d.toPrint(s+"  ");
        }
        return s+"IfStm\n"
                +s+"Cond: \n"+ exp.toPrint(s+"  ") +thenStmStr + elseStmStr;
    }
}
