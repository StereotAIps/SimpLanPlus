package ast.ExpNode;

import ast.Node;
import ast.Types.Type;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;

public class NumExpNode implements Node {

    private String op;
    private Node left;
    private Node right;

    public NumExpNode(Node left, Node right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("NumExpNode", _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        return null;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return s+"NumExp:"+op+"\n" + left.toPrint(s+"  ")  + right.toPrint(s+"  ") ;
    }
}
