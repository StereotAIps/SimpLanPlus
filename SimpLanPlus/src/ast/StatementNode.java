package ast;

public class StatementNode implements Node {

    private Node statement;
    private int line;

    public StatementNode(Node statement, int line) {
        this.statement = statement;
        this.line = line;
    }

    public Node getStatement() {
        return statement;
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
