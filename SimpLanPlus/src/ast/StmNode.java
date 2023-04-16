package ast;

public class StmNode implements Node{

    private Node stm;

    public StmNode(Node statement) {
        this.stm = statement;
    }

    public Node getStatement() {
            return stm;
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
