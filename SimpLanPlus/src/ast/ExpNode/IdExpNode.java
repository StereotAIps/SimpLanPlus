package ast.ExpNode;

import java.util.ArrayList;

import ast.Node;
import ast.Types.Type;
//import semanticanalysis.STentry;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

/**
 *  exp: ID #idExp
 * **/
public class IdExpNode implements Node {
	private String id ;
	private STentry type ;
	private int nesting ;
  
	public IdExpNode(String _id) {
		id = _id ;
	}
  
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		ST.toPrint("IdExpNode "+id, nesting);
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
		nesting = _nesting ;

		STentry st_type = ST.lookup(id) ;
		if (st_type == null)
			errors.add(new SemanticError("Id " + id + " not declared"));
		else type = st_type ;

		return errors;
	}
  
	public Type typeCheck () {
//		if (type.gettype() instanceof ArrowType) { //
//			System.out.println("Wrong usage of function identifier");
//			return new ErrorType() ;
//		} else return type.gettype() ;
		return null;
	}
  
	public String codeGeneration() {
//		String getAR="";
//		for (int i=0; i < nesting - type.getnesting(); i++)
//	    	 getAR += "store T1 0(T1) \n";
//	    return
//		       "move AL T1 \n"
//		       + getAR  //risalgo la catena statica
//		       + "subi T1 " + type.getoffset() +"\n" //metto offset sullo stack
//			   + "store A0 0(T1) \n" ; //carico sullo stack il valore all'indirizzo ottenuto
		return null;
	}

	public String toPrint(String s) {

		return s+"Id:" + id +"\n"; //+ " at nestlev " + type.getnesting() +"\n" ;

	}
  
}  