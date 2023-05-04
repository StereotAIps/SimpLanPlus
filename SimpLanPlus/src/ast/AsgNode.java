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
        if(!ST.top_lookup(id)) { //INSERISCO
            ST.insert(id, tmp.gettype(), nesting, true, ""); //ora so che è stato assegnato
        }
        else { //UPDATE
            ST.insert(id, tmp.gettype(),tmp.getoffset(), nesting, true, "");
        }
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
//        return "//AsgNode \n"+
//                exp.codeGeneration() +
//                "pushr A0 \n" ;
//        if(entry.getnesting() == nesting){ //se la variabile è definita in quell'ambiente
//            return
//                    exp.codeGeneration()
//                            +"pushr A0" + " //AsgNode \n" ;
//        }
//        else { //se la variabile è definita in un ambiente superiore
            String getAR = "";
            for (int i = 0; i < nesting - entry.getnesting(); i++)
                getAR += "store T1 0(T1) \n";
            return
                    exp.codeGeneration()
                            + "move AL T1 "+ " //AsgNode \n"
                            + getAR  //risalgo la catena statica
                            + "subi T1 " + entry.getoffset() +"\n" //metto offset sullo stack
                            + "load A0 0(T1) " +" //EndAsgNode \n" ; //carico sullo stack il valore all'indirizzo ottenuto
        }
//    }

    @Override
    public String toPrint(String s) {
        return s + "Asg:" +"\n"+s+"  ID:"+ id + "\n" + exp.toPrint(s+"  ");
    }
}
