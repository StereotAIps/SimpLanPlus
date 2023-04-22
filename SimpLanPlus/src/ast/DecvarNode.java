package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;

public class DecvarNode implements Node {
    private String id;
    private Type type;
    private int nesting ;

    public DecvarNode (String _id, Type _type) {
        id = _id ;
        type = _type ;
    }

    public String getId(){
        return id;
    }

    public Type getType(){
        return type;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("DecvarNode", nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;

        if (ST.top_lookup(id) == true)
            errors.add(new SemanticError("Var id " + id + " already declared"));
        else ST.insert(id, (Type) type, nesting,"") ;

        return errors ;
    }

    //non utilizzato
    public Type typeCheck () {
        return null;
    }

    //non utilizzato
    public String codeGeneration() {
        return "";
    }

    public String toPrint(String s) {
        return s+"DecVar " + id + ":" + type.toPrint(s)+"\n" ;
    }

}
