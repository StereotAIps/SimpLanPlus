package ast;

import ast.Types.Type;
import evaluator.SimpLanlib;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.ArrowType;
import symboltable.STentry;
import symboltable.SymbolTable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * dec    : type ID '(' ( param ( ',' param)* )? ')' '{' body '}'          #funDec
 * **/
public class DecfunNode implements Node{
    private String id;
    private Type returntype ;
    private ArrayList<ParNode> parlist ;
    private Node body ;
    //private ArrowType type ;
    private int nesting ;
    private String flabel ;

    private ArrowType type ;

    public DecfunNode (String _id, Type _type, ArrayList<ParNode> _parlist, Node _body) {
        id = _id ;
        returntype = _type;
        parlist = _parlist ;
        body = _body ;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("DecfunNode", _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;

        if (ST.lookup(id) != null) //vedo se il nome della funz è già stata dichiarata in questo ambiente
            errors.add(new SemanticError("Identifier " + id + " already declared"));
        else { //altrimenti creo un nuovo ambiente
            ArrayList<Type> partypes = new ArrayList<Type>() ;

            for (ParNode arg : parlist){
                partypes.add(arg.getType()); //aggiungo il tipo del parametro alla lista dei tipi dei parametri
                //errors.addAll(arg.checkSemantics(ST, nesting+1));
            }

            type = new ArrowType(partypes, returntype) ; //mi salvo i tipi dei parametri e il tipo di ritorno della funzione

            ST.increaseoffset() ; // aumentiamo di 1 l'offset per far posto al return value

            flabel = SimpLanlib.freshFunLabel() ;

            ST.insert(id, type, nesting, flabel) ;

            HashMap<String, STentry> HM = new HashMap<String,STentry>() ;
            ST.add(HM); //metto questo nuovo ambiente in testa allo stack
            for (ParNode arg : parlist){
                errors.addAll(arg.checkSemantics(ST, nesting+1));
            }

            errors.addAll(body.checkSemantics(ST, nesting+1)); //controllo la semantica del body

            ST.remove(); //rimuvo l'ambiente


        }
        return errors ; // problemi con la generazione di codice!
    }

    public Type typeCheck () {
        if (parlist!=null)
            for (Node dec:parlist)
                dec.typeCheck();
        if ( (body.typeCheck()).getClass().equals(returntype.getClass()))
            return null ;
        else {
            System.out.println("Wrong return type for function "+id);
            return new ErrorType() ;
        }
    }

    public String codeGeneration() {

//        String declCode = "" ;
////	    String popDecl = "" ;
//        if (de .size() != 0) {
//            for (Node dec:declist){
//                declCode = declCode + dec.codeGeneration();
////	    			popDecl = popDecl + "pop\n";
//            }
//        }

//	    String popParl="";
//	    for (Node dec:parlist) popParl+="pop\n";

        SimpLanlib.putCode(
                "//DecFunNodeCODE \n"+
                        flabel + ":\n"
                        + "pushr RA \n"
                       // + declCode
                        + body.codeGeneration()
//	    			+ "move A0 RV \n"
                        //+ "addi SP " + 	declist.size() + "\n"
                        + "popr RA \n"
                        + "addi SP " + 	parlist.size() + "\n"
                        + "pop \n"
                        + "store FP 0(FP) \n"
                        + "move FP AL \n"
                        + "subi AL 1 \n"
                        + "pop \n"
                        + "rsub RA \n"
/*
	    		"lra\n"+ 				// inserimento return address
	    		declCode+ 				// inserimento dichiarazioni locali
	    		body.codeGeneration()+
	    		"srv\n"+ 				// pop del return value e memorizzazione in rv
	    		popDecl+				// rimuove lo spazio per le variabili locali
	    		"sra\n"+ 				// pop del return address e memorizzazione in $ra
	    		popParl+				// rimuove lo spazio dei parametri
	    		"pop\n" +				// cancella access link
	    		"sfp\n"+  				// memorizza in fp il valore del frame pointer precedente (che si trova sulla pila)
	    		"salfpm \n" +			// memorizza in al l'ambiente del chiamante (che si trova a fp -1)
	    		"lrv\n"+ 				// risultato della funzione sullo stack
	    		"lra\n"+
	    		"js\n"  				// salta a ra
	    		*/
        );

        return "//DecFunNode \n"+"push "+ flabel +"\n";
    }

    public String toPrint(String s) {
        String parlstr="";
        for (ParNode par:parlist){
            parlstr += par.toPrint(s);
        }
        return s+"DecFun "+id+":"+returntype.toPrint(" ")+"\n  "+parlstr + "\n"+body.toPrint(s+"  ") ;
    }

        //valore di ritorno non utilizzato

}
