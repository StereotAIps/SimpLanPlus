package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;

import java.util.ArrayList;

/**
 body   : (dec)* (stm)* (exp)?
        ;
 * **/
public class BodyNode implements Node{

    private ArrayList<Node> declist ;
    private ArrayList<Node> stmlist ;
    private Node exp;

    public BodyNode (ArrayList<Node> declist, ArrayList<Node> stmlist, Node exp){
        this.declist = declist;
        this.stmlist = stmlist;
        this.exp = exp;
    }

    public BodyNode (ArrayList<Node> declist, ArrayList<Node> stmlist){
        this.declist = declist;
        this.stmlist = stmlist;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        return null;
    }

    @Override
    public Type typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {

        String declstr="";
        for (Node d : declist)
            declstr += d.toPrint(s+"  ");
        String stmstr="";
        for (Node d : stmlist)
            stmstr += d.toPrint(s+"  ");
        return s+"Body\n"
                + ((!declstr.equals(""))?(declstr + ""):"")
                + ((!stmstr.equals(""))?(stmstr + ""):"")
                + ((exp != null)? (exp.toPrint(s+"  ")):"") ;
    }
}
