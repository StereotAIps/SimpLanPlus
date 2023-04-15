package ast;

public class AsgNode implements Node {
    private IdNode id;
    private Node exp;

    public AsgNode(IdNode ID, Node exp, int line){
        this.id = ID;
        this.exp = exp;
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
