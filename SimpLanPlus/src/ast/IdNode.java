package ast;

public class IdNode implements Node {
    private String id ;
    //private STentry type ;
    private int nesting ;

    public IdNode (String _id) {
        id = _id ;
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
