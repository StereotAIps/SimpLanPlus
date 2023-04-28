package ast.ExpNode;

import java.util.ArrayList;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.Type;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

public class BoolExpNode implements Node {

	private boolean val;
  
	public BoolExpNode(boolean _val) {
		val = _val ;
	}

	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		return new ArrayList<SemanticError>();
 	}

	public Type typeCheck() {
		return new BoolType();
	}    
    
	public String codeGeneration() {
		return "//BoolExpNode \n"+"storei A0 "+(val?1:0)+"\n";
	}
    
	public String toPrint(String s) {
		return s + String.valueOf(val) +"\n";  
	}

}  