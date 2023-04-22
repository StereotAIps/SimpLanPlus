package ast;
import java.util.ArrayList;
import java.util.HashMap;

import ast.Types.Type;
import semanticanalysis.SemanticError;
import symboltable.STentry;
import symboltable.SymbolTable;

/**
 * prog   : (dec)+ (stm)* (exp)?
 * **/
public class ProgLetInNode implements Node {
	
	private ArrayList<Node> declist ;

	private ArrayList<Node> stmlist ;
	private Node exp ;
	private int nesting ;
  
	public ProgLetInNode (ArrayList<Node> _dec, ArrayList<Node> _stm, Node _exp) {
		declist = _dec ;
		stmlist = _stm ;
		exp = _exp ;
	}

	public ProgLetInNode (ArrayList<Node> _dec, ArrayList<Node> _stm) {
		declist = _dec ;
		stmlist = _stm ;
	}
  
	public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
		nesting = _nesting + 1 ;
		ST.toPrint("ProgLetInNode", nesting);

		HashMap<String, STentry> H = new HashMap<String, STentry>();
		ST.add(H);

		//declare resulting list
		ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

		for (Node d : declist) {
			errors.addAll(d.checkSemantics(ST, nesting)) ;
		}
		for (Node d : stmlist) {
			errors.addAll(d.checkSemantics(ST, nesting)) ;
		}

		//check semantics in the exp body
		if(exp != null)
			errors.addAll(exp.checkSemantics(ST, nesting)) ;

		//clean the scope, we are leaving a let scope
		ST.remove();

		//return the result
		return errors;
	}
	public Type typeCheck () {
		for (Node d: declist)
		    d.typeCheck();
		return exp.typeCheck();
	}
		  
	public String codeGeneration() {
//		String declCode="";
//		for (Node d: dec)
//				    declCode += d.codeGeneration();
//		return  "move SP FP  \n"
//				+ "pushr FP \n"
//				+ "move SP AL \n"
//				+ "pushr AL \n"
//				+ declCode
//				+ exp.codeGeneration()
//				+ "halt\n" +
//				SimpLanlib.getCode();
		return null;
	} 
		  
	public String toPrint(String s) {
		String declstr="";
		for (Node d : declist)
			declstr += d.toPrint(s+"  ");
		String stmlstr="";
		for (Node d : stmlist)
			stmlstr += d.toPrint(s+"  ");
		return s+"ProgLetIn\n"
				+ ((declstr!="")?declstr:"")
				+ ((stmlstr!="")?stmlstr:"")
				+ ((exp!=null)?exp.toPrint(s+""):"");
	}
     
}  