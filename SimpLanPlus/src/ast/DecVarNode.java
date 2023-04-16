package ast;

import ast.type.Type;

/**
 decVar : type ID ;
 * **/
public class DecVarNode implements Node {
    private Type type;
    private IdNode id;
    private int line;

    public DecVarNode(Type type, IdNode id, int line) {
        this.type = type;
        this.id = id;
        this.line = line;
    }

    public Type getType() {
        return type;
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
