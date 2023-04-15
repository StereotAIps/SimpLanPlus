package ast.type;

import ast.Node;

public class Type implements Node{
    public boolean isEqual(Type A, Type B) {
        if (A.getClass().equals(B.getClass())) return true ;
        else return false ;
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
