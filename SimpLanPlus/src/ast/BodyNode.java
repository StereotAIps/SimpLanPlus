package ast;

import java.util.ArrayList;

public class BodyNode implements Node{
    private ArrayList<Node> declarations;
    private ArrayList<Node> statements;
    private Node exp;

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return null;
    }
}
