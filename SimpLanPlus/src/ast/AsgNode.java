package ast;

import ast.Types.Type;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;

/**
 * stm    : ID '=' exp ';'
 * **/
public class AsgNode implements Node{

    private String id;
    private Node exp;

    private STentry entry;

    private int nesting;
    public AsgNode(String _id, Node _exp) {
        id = _id ;
        exp = _exp ;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;
        STentry tmp = ST.lookup(id) ;
        if (tmp != null) {
            entry = tmp ;
        } else {
            errors.add(new SemanticError("Id " + id + " not declared")) ;
        }
        errors.addAll(exp.checkSemantics(ST, nesting));
        return errors ;
    }

    @Override
    public Type typeCheck() {

        //controllo che il tipo dell'espressione è uguale al tipo dell'oggetto con nome x in questo evironment
        Type _type = entry.gettype();
        if (exp.typeCheck().getClass().equals(_type.getClass()))
            return null ;
        else {
            System.out.println("Type Error: incompatible type of expression for variable "+id) ;
            return new ErrorType() ;
        }
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return s + "Asg:" +"\n"+s+"  ID:"+ id + "\n" + exp.toPrint(s+"  ");
    }
}
