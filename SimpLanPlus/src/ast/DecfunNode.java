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
    private ArrayList<Node> innerDecs ;
    private ArrayList<Node> innerStms ;
    private Node exp;
//    private Node body ;
    //private ArrowType type ;
    private int nesting ;
    private String flabel ;

    private ArrowType type ;

    public DecfunNode (String _id, Type _type, ArrayList<ParNode> _parlist, ArrayList<Node> _declist, ArrayList<Node> _stmlist) {
        id = _id ;
        returntype = _type;
        parlist = _parlist ;
        innerDecs = _declist;
        innerStms = _stmlist;
    }

    public DecfunNode (String _id, Type _type, ArrayList<ParNode> _parlist, ArrayList<Node> _declist, ArrayList<Node> _stmlist, Node _exp) {
        id = _id ;
        returntype = _type;
        parlist = _parlist ;
        innerDecs = _declist;
        innerStms = _stmlist;
        exp = _exp;
    }

    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("DecfunNode "+id, _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;

        if (ST.lookup(id) != null)
            errors.add(new SemanticError("Identifier " + id + " already declared"));
        else {
            HashMap<String, STentry> HM = new HashMap<String, STentry>();
            ArrayList<Type> partypes = new ArrayList<Type>();

            ST.add(HM);

            for (ParNode arg : parlist) {
                partypes.add(arg.getType());
                if (ST.top_lookup(arg.getId()))
                    errors.add(new SemanticError("Parameter id " + arg.getId() + " already declared"));
                else ST.insert(arg.getId(), arg.getType(), nesting + 1, "");
            }

            type = new ArrowType(partypes, returntype);

            ST.increaseoffset(); // aumentiamo di 1 l'offset per far posto al return value
            for (Node dec : innerDecs)
                errors.addAll(dec.checkSemantics(ST, nesting + 1));
            for (Node stm : innerStms)
                errors.addAll(stm.checkSemantics(ST, nesting + 1));

            if (exp != null)
                errors.addAll(exp.checkSemantics(ST, nesting + 1));

            ST.remove();

            //Inserisco la funzione in tabella
            flabel = SimpLanlib.freshFunLabel();
            ST.insert(id, type, nesting, flabel);
        }
        return errors ; // problemi con la generazione di codice!
    }

    public Type typeCheck () {
            if (innerDecs!=null)
                for (Node dec:innerDecs)
                    dec.typeCheck();
            if (innerStms!=null)
                for (Node dec:innerStms)
                    dec.typeCheck();
            if(exp != null) {
                if ((exp.typeCheck()).getClass().equals(returntype.getClass()))
                    return null;
                else {
                    System.out.println("Wrong return type for function " + id);
                    return new ErrorType();
                }
            }
            return null;
        }

    public String codeGeneration() {

        String declCode = "" ;
//	    String popDecl = "" ;
        if (innerDecs.size() != 0) {
            for (Node dec:innerDecs){
                declCode = declCode + dec.codeGeneration();
//	    			popDecl = popDecl + "pop\n";
            }
        }

        String stmCode = "" ;
        if (innerStms.size() != 0) {
            for (Node stm:innerStms){
                stmCode = stmCode + stm.codeGeneration();
//	    			popDecl = popDecl + "pop\n";
            }
        }

        String expCode = "";
        if(exp != null)
            expCode = exp.codeGeneration();


//	    String popParl="";
//	    for (Node dec:parlist) popParl+="pop\n";

        SimpLanlib.putCode(
                flabel + ": //DecfunNode \n"
                        + "pushr RA \n"
                        + declCode
                        + stmCode
                        + expCode
//	    			+ "move A0 RV \n"
                        + "addi SP " + 	innerDecs.size() + " //innerDecsSize\n"
                        + "popr RA \n"
//                        + "addi SP " + 	innerStms.size() + "\n"
//                        + "popr RA \n"
                        + "addi SP " + 	parlist.size() + " //parSize\n"
                        + "pop \n"
                        + "store FP 0(FP) \n"
                        + "move FP AL \n"
                        + "subi AL 1 \n"
                        + "pop \n"
                        + "rsub RA //EndDecfunNode\n"
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

        return "push "+ flabel +"\n";
    }

    public String toPrint(String s) {
        String parlstr="";
        for (ParNode par:parlist){
            parlstr += par.toPrint(s);
        }
        String declstr= "";
        if (innerDecs!=null)
            for (Node dec:innerDecs)
                declstr+=dec.toPrint(s+"  ");
        String stmstr= "";
        if (innerStms!=null)
            for (Node dec:innerStms)
                stmstr+=dec.toPrint(s+" ");
        String expstr = "";
        if(exp != null)
            expstr = exp.toPrint(s+" ");
        return s+"DecFun "
                +id+":" +returntype.toPrint(" ")+"\n  "
                +parlstr + "\n "
                +declstr + "\n "
                +stmstr + "\n "
                +expstr ;
    }

        //valore di ritorno non utilizzato

}
