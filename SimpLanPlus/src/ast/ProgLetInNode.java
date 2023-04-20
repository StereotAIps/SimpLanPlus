package ast;
import java.util.ArrayList;

import ast.Types.Type;
//import evaluator.SimpLanlib;
//import semanticanalysis.STentry;
import semanticanalysis.SemanticError;

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
//		  nesting = _nesting + 1 ;
//	      HashMap<String,STentry> H = new HashMap<String, STentry>();
//	      ST.add(H);
//
//	      //declare resulting list
//	      ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
//
//	      for (Node d : dec) {
//	    	  	errors.addAll(d.checkSemantics(ST, nesting)) ; // nella sintassi non ci sono annidamenti di let
//	      }												  // ad eccezione delle funzioni ...
//
//	      //check semantics in the exp body
//	      errors.addAll(exp.checkSemantics(ST, nesting)) ;
//
//	      //clean the scope, we are leaving a let scope
//	      ST.remove();
//
//	      //return the result
//	      return errors;
		return null;
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