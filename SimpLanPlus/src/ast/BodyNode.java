package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 body   : (dec)* (stm)* (exp)?
        ;
 * **/
public class BodyNode implements Node{

    private ArrayList<Node> declist ;
    private ArrayList<Node> stmlist ;
    private Node exp;

    private int nesting;

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
        nesting = _nesting + 1 ;
        HashMap<String, STentry> H = new HashMap<String, STentry>();
        ST.add(H);

        //declare resulting list
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        for (Node d : declist) {
            errors.addAll(d.checkSemantics(ST, nesting)) ; // nella sintassi non ci sono annidamenti di let
        }
        for (Node d : stmlist) {
            errors.addAll(d.checkSemantics(ST, nesting)) ; // nella sintassi non ci sono annidamenti di let
        }

        //check semantics in the exp body
        if(exp != null)
            errors.addAll(exp.checkSemantics(ST, nesting)) ;

        //clean the scope, we are leaving a let scope
        ST.remove();

        //return the result
        return errors;
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
