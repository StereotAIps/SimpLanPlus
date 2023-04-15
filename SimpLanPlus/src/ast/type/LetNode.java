package ast.type;

import ast.Node;

import java.util.ArrayList;

public class LetNode implements Node {

    private ArrayList<Node> let_statements;
    private Node in_statement;

    public LetNode(ArrayList<Node> let_statements, Node in_statement) {
        this.let_statements = let_statements;
        this.in_statement = in_statement;
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
