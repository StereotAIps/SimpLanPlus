package semanticanalysis;

import ast.Types.Type;

public class ErrorType extends Type {
	public String toPrint(String s) {
		return s + "Error\n" ;  
	  }

}
