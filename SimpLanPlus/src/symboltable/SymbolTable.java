package symboltable;

import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;

import java.util.*;

public class SymbolTable {
	private ArrayList<HashMap<String,STentry>>  symbol_table ;
	private ArrayList<Integer> offset;
	private ArrayList<HashMap<String,VarInfo>>  var_table ;
	public SymbolTable() {
		symbol_table = new ArrayList<HashMap<String,STentry>>() ;
		offset = new ArrayList<Integer>() ;
		var_table = new ArrayList<HashMap<String,VarInfo>>();
	}

	public void toPrint(String fun, int nesting){
		System.out.println("--------------------------------");
		System.out.println("ST"+nesting+": "+fun);
		for(HashMap<String,STentry> h : symbol_table){
			if(h.size()>0){
				System.out.println("[");
				h.forEach((s,st) -> {
					System.out.println(s+st.toPrint());
				});
				System.out.println("]");
			}
			else System.out.println("[]");
		}
		System.out.println("VarTable: ");
		for(HashMap<String,VarInfo> h : var_table){
			if(h.size()>0){
				System.out.println("[");
				h.forEach((s,st) -> {
					System.out.println("|"+s+":"+st.toPrint()+"|");
				});
				System.out.println("]");
			}
			else System.out.println("[]");
		}
	}
	public Integer nesting() {
		return symbol_table.size() -1 ;
	}

	//lookup a name in the current and enclosing scopes
	// • to check if it is multiply declared
	//• to check for a use of an undeclared name, and
	//• to link a use with the corresponding symbol-table entry
	public STentry lookup(String id) {
		int n = symbol_table.size() - 1 ;
		boolean found = false ;
		STentry T = null ;
		while ((n >= 0) && !found) {
			HashMap<String,STentry> H = symbol_table.get(n) ;
			T = H.get(id) ;
			if (T != null) found = true ;
			else n = n-1 ;
		}
		return T ;
	}

	public Integer nslookup(String id) {
		int n = symbol_table.size() - 1 ;
		boolean found = false ;
		while ((n >= 0) && !found) {
			HashMap<String,STentry> H = symbol_table.get(n) ;
			if (H.get(id) != null) found = true ;
			else n = n-1 ;
		}
		return n ;
	}

	//a new name into the symbol table with its attributes
	public void add(HashMap<String,STentry> H) {
		symbol_table.add(H) ;
		offset.add(1) ;		// si inizia da 2 perche` prima ci sonop FP e AL
	}

	//do what must be done when a scope is exited
	public void remove() {
		int x = symbol_table.size() ;
		symbol_table.remove(x-1) ;
		offset.remove(x-1) ;
	}
	
	public boolean top_lookup(String id) {
		int n = symbol_table.size() - 1 ;
		STentry T = null ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		T = H.get(id) ;
		return (T != null) ;
	}


	public void insert(String id, Type type, int _nesting, String _label) {
		int n = symbol_table.size() - 1 ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		symbol_table.remove(n) ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		STentry idtype = new STentry(type,offs,_nesting, _label) ;
		H.put(id,idtype) ;
		symbol_table.add(H) ;
		if (type.getClass().equals((new BoolType()).getClass()))
			offs = offs + 1 ; // we always increment the offset by 1 otherwise we need ad-hoc
							  // bytecode operations
		else if (type.getClass().equals((new IntType()).getClass()))
			offs = offs + 1 ;
		else offs = offs + 1 ;
		offset.add(offs) ;
	}

	public void insert(String id, Type type,  int _nesting, boolean assigned, String _label) {
		int n = symbol_table.size() - 1 ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		symbol_table.remove(n) ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		STentry idtype = new STentry(type,offs,_nesting, _label, true) ;
		H.put(id,idtype) ;
		symbol_table.add(H) ;
		if (type.getClass().equals((new BoolType()).getClass()))
			offs = offs + 1 ; // we always increment the offset by 1 otherwise we need ad-hoc
			// bytecode operations
		else if (type.getClass().equals((new IntType()).getClass()))
			offs = offs + 1 ;
		else offs = offs + 1 ;
		offset.add(offs) ;
	}

	public void insert(String id, Type type, int o, int _nesting, boolean assigned, String _label) {
		int n = symbol_table.size() - 1 ;
		HashMap<String,STentry> H = symbol_table.get(n) ;
		symbol_table.remove(n) ;
		int offs = o;//offset.get(n) ;
		//offset.remove(n) ;
		STentry idtype = new STentry(type,offs,_nesting, _label, true) ;
		H.put(id,idtype) ;
		symbol_table.add(H) ;
		if (type.getClass().equals((new BoolType()).getClass()))
			offs = offs + 1 ; // we always increment the offset by 1 otherwise we need ad-hoc
			// bytecode operations
		else if (type.getClass().equals((new IntType()).getClass()))
			offs = offs + 1 ;
		else offs = offs + 1 ;
		//offset.add(offs) ;
	}

	public void increaseoffset() {
		int n = offset.size() - 1 ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		offs = offs + 1 ;
		offset.add(offs) ;	
	}

	public void addVar(HashMap<String,VarInfo> H) {
		var_table.add(H) ;
	}

	//do what must be done when a scope is exited
	public void removeVar() {
		int x = var_table.size() ;
		var_table.remove(x-1) ;
	}

	public void insertVar(String id) {
		int n = var_table.size() - 1 ;
		HashMap<String,VarInfo> H = var_table.get(n) ;
		var_table.remove(n) ;
		VarInfo varInfo = new VarInfo() ;
		H.put(id,varInfo) ;
		var_table.add(H) ;
	}

	public void insertVar(String id, boolean _asg) {
		int n = var_table.size() - 1 ;
		HashMap<String,VarInfo> H = var_table.get(n) ;
		var_table.remove(n) ;
		VarInfo varInfo = new VarInfo(_asg) ;
		H.put(id,varInfo) ;
		var_table.add(H) ;
	}

	public boolean top_lookupVar(String id) {
		int n = var_table.size() - 1 ;
		VarInfo T = null ;
		HashMap<String,VarInfo> H = var_table.get(n) ;
		T = H.get(id) ;
		return (T != null) ;
	}

	public VarInfo lookupVar(String id) {
		int n = var_table.size() - 1 ;
		boolean found = false ;
		VarInfo T = null ;
		while ((n >= 0) && !found) {
			HashMap<String,VarInfo> H = var_table.get(n) ;
			T = H.get(id) ;
			if (T != null) found = true ;
			else n = n-1 ;
		}
		return T ;
	}
}
