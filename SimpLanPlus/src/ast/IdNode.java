package ast;

public class IdNode implements Node {
    private String id;
    private int line;
    public IdNode(String id, int line){
        this.id = id;
        this.line = line;
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
