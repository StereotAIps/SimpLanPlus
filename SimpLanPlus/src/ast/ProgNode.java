package ast;

import java.util.ArrayList;

import ast.Types.Type;
import semanticanalysis.SemanticError ;
import symboltable.SymbolTable;

/**
 * prog   : exp                        #singleExp
 * **/
public class ProgNode implements Node {
	private Node exp;
  
	public ProgNode (Node _exp) {
		exp = _exp ;
	}


	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		ST.toPrint("ProgNode", _nesting);
		return exp.checkSemantics(ST, _nesting);
	}

	public Type typeCheck() {
		return exp.typeCheck();
	}  
  
	public String codeGeneration() {
		return exp.codeGeneration()+"halt\n";
	}  
  
	public String toPrint(String s) {
		return "Prog\n" + exp.toPrint("  ") ;
	}

}  