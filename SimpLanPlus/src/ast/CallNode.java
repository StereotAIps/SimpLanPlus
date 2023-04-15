package ast;
import java.util.ArrayList;

public class CallNode implements Node {
    private String id ;
    private ArrayList<Node> parameters ;
    private int nesting ;

    public CallNode(String _id, ArrayList<Node> _parameters) {
        id = _id;
        parameters = _parameters ;
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
