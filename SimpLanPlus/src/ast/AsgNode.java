package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

import java.util.ArrayList;

/**
 * stm    : ID '=' exp ';'
 * **/
public class AsgNode implements Node{

    private String id;
    private Node type;

    public AsgNode(String _id, Node _type, Node _exp) {
        id = _id ;
        type = _type ;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        return null;
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
        return null;
    }
}
