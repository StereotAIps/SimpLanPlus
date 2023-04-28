package ast.ExpNode;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.Type;
import ast.Types.VoidType;
import evaluator.SimpLanlib;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;

/**
 * exp:'!' exp                                                                                             #notExp
 * */
public class NotExpNode implements Node {

    private Node exp;

    public NotExpNode( Node exp) {
        this.exp = exp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        ST.toPrint("NotExpNode", _nesting);
        errors.addAll(exp.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        //exp deve essere bool e ritorna bool
        if(exp instanceof BoolType){
            return new BoolType();
        }
        else{
            System.out.println("Type Error: type not allowed in not expression");
            return new ErrorType() ;
        }
    }

    @Override
    public String codeGeneration() {
        String ltrue = SimpLanlib.freshLabel();
        String lend = SimpLanlib.freshLabel();
        return "//NotExpNode \n"+
                exp.codeGeneration() +
                "storei T1 1 \n" +
                "beq A0 T1 "+ ltrue + "\n" +
                //Se sono diversi allora ho 1 e 0 allora metto 1 in A0
                "storei A0 1 \n"+
                "b " + lend + "\n" +
                ltrue + ":\n" +
                //Se sono uguali allora ho 1 e 1 allora metto 0 in A0
                "storei A0 0 \n"+
                lend + ":\n" ;

    }

    @Override
    public String toPrint(String s) {
        return s+"Op:!= \n" + exp.toPrint(s+"  ") ;
    }
}
