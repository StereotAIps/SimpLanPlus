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
 * exp: leftExp=exp  '==' rightExp=exp                                                                      #eqExp
 * */
public class EqExpNode implements Node {

    private Node left;
    private Node right;

    public EqExpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
        ST.toPrint("EqExpNode", _nesting);
        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();

        errors.addAll(left.checkSemantics(ST, _nesting));
        errors.addAll(right.checkSemantics(ST, _nesting));

        return errors;
    }

    @Override
    public Type typeCheck() {
        Type leftop = left.typeCheck() ;
        Type rightop = right.typeCheck() ;
        //Controllo se un operando è void, in quel caso errore
        if((leftop instanceof VoidType) || (rightop instanceof VoidType) ){
            System.out.println("Type Error: type void is not allowed in equal expression");
            return new ErrorType() ;
        }
        else {
            //Controllo che siano dello stesso tipo, che questo sia int o bool e ritorna bool
            if (leftop.getClass().equals(rightop.getClass()))
                return new BoolType();
            else {
                System.out.println("Type Error: incompatible types in equal expression");
                return new ErrorType();
            }
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
