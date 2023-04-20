package ast;

import java.util.ArrayList;

import ast.Types.Type;
import semanticanalysis.SemanticError ;

public interface Node {

    ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting);
    Type typeCheck();
    String codeGeneration();

    String toPrint(String s);

}