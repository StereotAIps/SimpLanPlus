package ast.ExpNode;

import java.util.ArrayList;

import ast.Node;
import ast.Types.IntType;
import ast.Types.Type;
import semanticanalysis.SemanticError;
import semanticanalysis.SymbolTable;

public class IntExpNode implements Node {
	private Integer val;
  
	public IntExpNode (Integer _val) {
		val = _val ;
	}
	
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
 	 	  return new ArrayList<SemanticError>();
	}
 	  
	public Type typeCheck(){
		return new IntType();
	} 
  
	public String codeGeneration() {
		return "storei A0 "+val+"\n";
	}

	public String toPrint(String s) {
	    return s + Integer.toString(val) +"\n";  
	}
}  