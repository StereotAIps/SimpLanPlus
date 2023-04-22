package ast.ExpNode;

import ast.Node;
import ast.Types.Type;
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
        return null;
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
