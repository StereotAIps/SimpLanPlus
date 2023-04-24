package ast.ExpNode;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.Type;
import ast.Types.VoidType;
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
        return null;
    }

    @Override
    public String toPrint(String s) {
        return s+"Op:!= \n" + exp.toPrint(s+"  ") ;
    }
}
