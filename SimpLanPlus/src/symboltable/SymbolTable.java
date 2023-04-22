package symboltable;

import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;

import java.util.*;

public class SymbolTable {
	private ArrayList<HashMap<String,STentry>>  symbol_table ;
	private ArrayList<Integer> offset;
	
	public SymbolTable() {
		symbol_table = new ArrayList<HashMap<String,STentry>>() ;
		offset = new ArrayList<Integer>() ;
	}

	public void toPrint(String fun, int nesting){
		System.out.println("ST"+nesting+": "+fun);
		for(HashMap<String,STentry> h : symbol_table){
			h.forEach((s,st) -> {
				System.out.println("string: "+s+st.toPrint());
			});
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

	public void increaseoffset() {
		int n = offset.size() - 1 ;
		int offs = offset.get(n) ;
		offset.remove(n) ;
		offs = offs + 1 ;
		offset.add(offs) ;	
	}

}
