package ast;

import ast.ExpNode.IdExpNode;
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
        ST.toPrint("AsgNode "+ id, _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;
        STentry tmp = ST.lookup(id) ;
        if (tmp != null) {
            entry = tmp ;
            //Se b non si trova in quest'ultimo ambiente allora lo aggiungo, indicando che è stato assegnato
            //if(!ST.top_lookup(id)) {

            //}
        } else {
            errors.add(new SemanticError("Id " + id + " not declared")) ;
        }

        errors.addAll(exp.checkSemantics(ST, nesting));
        ST.insert(id, tmp.gettype(), nesting, true, ""); //ora so che è stato assegnato
        return errors ;
    }

    @Override
    public Type typeCheck() {

        //controllo che il tipo dell'espressione è uguale al tipo dell'oggetto con nome x in questo evironment
        Type _type = entry.gettype();
        if (exp.typeCheck().getClass().equals(_type.getClass())) {
            if (exp.typeCheck().getClass().equals(new IdExpNode("").getClass())) {
                STentry entry = ((IdExpNode) exp).getEntry();
                if(!entry.isAssigned()){
                    System.out.println("Identifier "+ id +" is used but never assigned");
                    return new ErrorType() ;
                }
            }
            return null;
        }
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
