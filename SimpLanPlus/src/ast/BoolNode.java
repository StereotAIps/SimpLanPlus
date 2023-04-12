package ast;

public class BoolNode implements Node{

    private boolean val;

    public  BoolNode (boolean _val){
        val = _val;
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
