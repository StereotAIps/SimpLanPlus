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
 * exp: leftExp=exp (op='&&' | op='||') rightExp=exp                                                        #opExp
 * */
public class OpExpNode implements Node {

    private String op;
    private Node left;
    private Node right;

    public OpExpNode( Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("OpExpNode", _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        Type leftop = left.typeCheck() ;
        Type rightop = right.typeCheck() ;
        //Controllo che siano dello stesso entrambi bool e ritorno bool
        if ((leftop instanceof BoolType) || (rightop instanceof BoolType))
            return new BoolType();
        else {
            System.out.println("Type Error: incompatible types in op expression");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {

        return s+"Op: == \n" + left.toPrint(s+"  ")  + right.toPrint(s+"  ") ;
    }
}
