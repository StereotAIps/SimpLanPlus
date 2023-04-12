package ast;

public class IntegerNode implements Node{
    private int val;

    public  IntegerNode (int _val){
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
