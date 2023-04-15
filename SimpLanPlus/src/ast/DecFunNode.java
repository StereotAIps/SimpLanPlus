package ast;

import ast.type.Type;

import java.util.ArrayList;

public class DecFunNode implements Node{

    private Type type;
    private IdNode id;
    private ArrayList<Node> args;

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return null;
    }
}
