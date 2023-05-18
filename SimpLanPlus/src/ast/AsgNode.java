package ast;

import ast.Types.Type;
import ast.Types.ErrorType;
import symboltable.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;

/**
 * stm    : ID '=' exp ';'
 * **/
public class AsgNode implements Node{

    private String id;
    private Node exp;

    //private boolean assigned;

    private STentry entry;

    private int nesting;
    public AsgNode(String _id, Node _exp) {
        id = _id ;
        exp = _exp ;
        //assigned = false;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("AsgNode "+ id, _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;
        //Controllo sull'id di sinistra
        STentry tmp = ST.lookup(id) ;
        if (tmp != null) {
            entry = tmp ; //Se è stato dichiarato allora ok prendo l'entry
        } else { //Se non è stato dichiarato allora errore
            errors.add(new SemanticError("Id " + id + " not declared")) ;
        }
        //Controllo gli errori su exp
        errors.addAll(exp.checkSemantics(ST, nesting));
        //Ora so che id è stato assegnato quindi lo metto nell'ultimo ambiente della tabella delle assegnazioni
        ST.insertVar(id, true);
        return errors ;
    }

    @Override
    public Type typeCheck() {

        //controllo che il tipo dell'espressione è uguale al tipo dell'oggetto con nome id in questo evironment
        Type _type = entry.gettype();
        if (exp.typeCheck().getClass().equals(_type.getClass())) {
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
