package ast;

import ast.Types.BoolType;
import ast.Types.Type;
import evaluator.SimpLanlib;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  exp: 'if' '(' cond=exp ')' '{' (thenStm=stm)* thenExp=exp '}' 'else' '{' (elseStm=stm)* elseExp=exp '}'  #ifExp
 * **/
public class IfExpNode implements Node {
    private Node exp;
    private ArrayList<Node> thenStm;
    private Node thenExp;
    private ArrayList<Node> elseStm;
    private Node elseExp;

    private int nesting;

    public IfExpNode(Node _guard, ArrayList<Node> _thenStm, Node _thenExp, ArrayList<Node> _elseStm, Node _elseExp) {
        exp = _guard;
        thenStm = _thenStm;
        thenExp = _thenExp;
        elseStm = _elseStm;
        elseExp = _elseExp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("IfExpNode", _nesting);
        nesting = _nesting;
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(exp.checkSemantics(ST, nesting));
        HashMap<String, STentry> HM = new HashMap<String,STentry>() ;
        ST.add(HM); //metto questo nuovo ambiente in testa allo stack
        for (Node d : thenStm) {
            errors.addAll(d.checkSemantics(ST, nesting)) ;
        }
        errors.addAll(thenExp.checkSemantics(ST, nesting));
        ST.remove();
        HashMap<String, STentry> HM1 = new HashMap<String,STentry>() ;
        ST.add(HM1); //metto questo nuovo ambiente in testa allo stack
        for (Node d : elseStm) {
            errors.addAll(d.checkSemantics(ST, nesting)) ;
        }
        errors.addAll(elseExp.checkSemantics(ST, nesting));
        ST.remove();
        return errors;
    }

    public Type typeCheck() {
        for (Node d: thenStm)
            d.typeCheck();
        for (Node d: elseStm)
            d.typeCheck();
        if (exp.typeCheck() instanceof BoolType) {
            Type thenexp = thenExp.typeCheck() ;
            Type elseexp = elseExp.typeCheck() ;
            if (thenexp.getClass().equals(elseexp.getClass()))
                return thenexp;
            else {
                System.out.println("Type Error: incompatible types in then and else branches");
                return new ErrorType() ;
            }
        } else {
            System.out.println("Type Error: non boolean condition in if");
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {
        String thenCode="";
        String elseCode="";
        for (Node d: thenStm)
            thenCode += d.codeGeneration();
        for (Node s: elseStm)
            elseCode += s.codeGeneration();

        String lthen = SimpLanlib.freshLabel();
        String lend = SimpLanlib.freshLabel();
        return exp.codeGeneration() +
                "storei T1 1 \n" +
                "beq A0 T1 "+ lthen + "\n" +
                elseCode +
                elseExp.codeGeneration() +
                "b " + lend + "\n" +
                lthen + ":\n" +
                thenCode +
                thenExp.codeGeneration() +
                lend + ":\n" ;

    }

    @Override
    public String toPrint(String s) {
        String thenStmStr=s+"Then: \n";
        for (Node d : thenStm)
            thenStmStr += d.toPrint(s+"  ");
        String elseStmStr=s+"Else:\n";
        for (Node d : elseStm)
            elseStmStr += d.toPrint(s+"  ");
        return s+"IfExp\n" + exp.toPrint(s+"Cond:\n    ") +thenStmStr + thenExp.toPrint(s+"    ")+ elseStmStr+ elseExp.toPrint(s+"    ");

    }
}
