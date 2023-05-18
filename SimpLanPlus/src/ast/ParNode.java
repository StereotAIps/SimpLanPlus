package ast;

import ast.Types.Type;
import symboltable.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;

public class ParNode implements Node {

    private String id;
    private Type type;
    private int nesting ;

    public ParNode (String _id, Type _type) {
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
        ST.toPrint("ParNode "+ id, _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
        nesting = _nesting ;
        if (ST.top_lookup(id)) //controllo se esiste già un parametro con questo nome
            errors.add(new SemanticError("Parameter id " + id + " already declared")) ; //se si errore
        else ST.insert(id, type, nesting, true, "") ; //se no aggiungo il nuovo parametro nell'ultimo ambiente della ST
        return errors ;
    }

    //non utilizzato
    public Type typeCheck () {
        return null;
    }

    //non utilizzato
    public String codeGeneration() {
        return " //ParNode \n"+"";
    }

    public String toPrint(String s) {
        return s+"Par " + id + ":" + type.toPrint(s) ;
    }



}