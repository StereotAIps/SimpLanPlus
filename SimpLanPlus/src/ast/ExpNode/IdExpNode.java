package ast.ExpNode;

import java.util.ArrayList;

import ast.Node;
import ast.Types.Type;
//import semanticanalysis.STentry;
import ast.Types.ErrorType;
import symboltable.SemanticError;
import ast.Types.ArrowType;
import symboltable.STentry;
import symboltable.SymbolTable;

import static java.lang.Boolean.FALSE;

/**
 *  exp: ID #idExp
 * **/
public class IdExpNode implements Node {
	private String id ;
	private STentry entry;
	private int nesting ;



	public IdExpNode(String _id) {
		id = _id ;
	}


	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		nesting = _nesting ;
		ST.toPrint("IdExpNode "+id, _nesting);
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		STentry st_type = ST.lookup(id) ;
		if (st_type == null)
			errors.add(new SemanticError("Id " + id + " not declared"));
		else{
			Boolean varInfo = ST.lookupVar(id) ; //Controllo se è assegnato nella tabella degli assegnamenti
			if(varInfo!= null)
				if(varInfo == FALSE && (st_type.getnesting() == nesting)){ //Se la variabile non è assegnata
				//Se la variabile non è assegnata
				errors.add(new SemanticError("Id " + id + " used but not initialized")); //Se non è stato assegnato do errore
			}
			else
				entry = st_type ; //mi salvo l'entry
		}

		return errors;
	}
  
	public Type typeCheck () {
		if (entry.gettype() instanceof ArrowType) { //
			System.out.println("Wrong usage of function identifier");
			return new ErrorType() ;
		}else{
			return entry.gettype() ;
		}
	}

	public String codeGeneration() {
		String getAR="";
		for (int i=0; i < nesting - entry.getnesting(); i++)
			getAR += "store T1 0(T1) //nest "+nesting+"-"+entry.getnesting()+"\n";
		return
				"move AL T1 "+ " //IdExpNode \n"
						+ getAR  //risalgo la catena statica
						+ "subi T1 " + entry.getoffset() +"\n" //metto offset sullo stack
						+ "store A0 0(T1) " + " //EndIdExpNode \n" ; //carico sullo stack il valore all'indirizzo ottenuto
	}

	public String toPrint(String s) {

		return s+"Id:" + id +"\n"; //+ " at nestlev " + type.getnesting() +"\n" ;

	}

	public STentry getEntry() {
		return entry;
	}

	public void setEntry(STentry entry) {
		this.entry = entry;
	}

	public String getId() {
		return id;
	}
}