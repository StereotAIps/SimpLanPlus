package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;

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
        nesting = _nesting ;
        return new ArrayList<SemanticError>();
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
