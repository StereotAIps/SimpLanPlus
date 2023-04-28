package ast.ExpNode;

import java.util.ArrayList;

import ast.Node;
import ast.Types.Type;
//import semanticanalysis.STentry;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.ArrowType;
import symboltable.STentry;
import symboltable.SymbolTable;

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
		ST.toPrint("IdExpNode "+id, nesting);
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		STentry st_type = ST.lookup(id) ;
		if (st_type == null)
			errors.add(new SemanticError("Id " + id + " not declared"));
		else{
			if(!ST.top_lookup(id) && !st_type.isAssigned()){
				errors.add(new SemanticError("Id " + id + " used but not initialized"));
			}
			else
				entry = st_type ;
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
			getAR += "store T1 0(T1) \n";
		return "//IdExpNode \n"+
				"move AL T1 \n"
						+ getAR  //risalgo la catena statica
						+ "subi T1 " + entry.getoffset() +"\n" //metto offset sullo stack
						+ "store A0 0(T1) \n" ; //carico sullo stack il valore all'indirizzo ottenuto
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
}