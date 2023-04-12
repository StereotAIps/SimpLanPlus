package ast;

public class Asg implements Node {

    private String id;
    private Node type;
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
