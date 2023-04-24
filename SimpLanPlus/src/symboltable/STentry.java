package symboltable;


import ast.Types.Type;

public class STentry {
	private Type type ;
	private int offset ;
	private int nesting ;
	private String label ;
	private boolean assigned;

	
	public STentry(Type _type, int _offset, int _nesting) {
		type = _type ;
		offset = _offset ;
		nesting = _nesting ;
		assigned = false;
	}
	
	public STentry(Type _type, int _offset, int _nesting, String  _label) {
		type = _type ;
		offset = _offset ;
		nesting = _nesting ;
		label = _label ;
		assigned = false;
	}
	public STentry(Type _type, int _offset, int _nesting, String  _label, boolean _assigned) {
		type = _type ;
		offset = _offset ;
		nesting = _nesting ;
		label = _label ;
		assigned = _assigned;
	}

	public String toPrint(){
		return "|"+nesting+"|"+offset+"|"+label+"|"+assigned+"|"+type.toPrint("");
	}
	public Type gettype() {
		return type ;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public int getoffset() {
		return offset ;
	}
	
	public int getnesting() {
		return nesting ;
	}
	
	public String getlabel() {
		return label ;
	}

}
