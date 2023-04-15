package ast;

public class StatementNode implements Node {

    private Node statement;
    public StatementNode(Node statement, int line) {
        this.statement = statement;
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
