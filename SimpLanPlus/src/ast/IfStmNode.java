package ast;

import ast.Types.BoolType;
import ast.Types.Type;
import ast.Types.VoidType;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

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
        HashMap<String, STentry> HM = new HashMap<String,STentry>() ;
        ST.add(HM); //metto questo nuovo ambiente in testa allo stack
        for (Node d : thenbranch) {
            errors.addAll(d.checkSemantics(ST, nesting+1)) ;
        }
        ST.remove();
        HashMap<String, STentry> HM1 = new HashMap<String,STentry>() ;
        ST.add(HM1); //metto questo nuovo ambiente in testa allo stack
        for (Node d : elsebranch) {
            errors.addAll(d.checkSemantics(ST, nesting+1)) ;
        }
        ST.remove();

        return errors;
    }

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
//        String lthen = SimpLanlib.freshLabel();
//        String lend = SimpLanlib.freshLabel();
//        return guard.codeGeneration() +
//                "storei T1 1 \n" +
//                "beq A0 T1 "+ lthen + "\n" +
//                elsebranch.codeGeneration() +
//                "b " + lend + "\n" +
//                lthen + ":\n" +
//                thenbranch.codeGeneration() +
//                lend + ":\n" ;
        return null;
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
