package ast.ExpNode;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;
import ast.Types.VoidType;
import semanticanalysis.ErrorType;
import semanticanalysis.SemanticError;
import symboltable.SymbolTable;

import java.util.ArrayList;
/**
 * exp: leftExp=exp ('>' | '<' | '>=' | '<=' ) rightExp=exp                                                 #compExp
 */
public class CompExpNode implements Node {

    private String op;
    private Node left;
    private Node right;

    public CompExpNode( Node left, Node right, String op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }
    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("CompExpNode", _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {

        Type leftop = left.typeCheck() ;
        Type rightop = right.typeCheck() ;
        if ((leftop instanceof IntType) && (rightop instanceof IntType)) {
//
            return new BoolType();
        } else {
            System.out.println("Type Error: incompatible types in left and right operands");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return s+"Op:"+op+"\n" + left.toPrint(s+"  ")  + right.toPrint(s+"  ") ;
    }
}
