package ast.ExpNode;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;
import ast.Types.VoidType;
import evaluator.SimpLanlib;
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
        String ltrue = SimpLanlib.freshLabel();
        String lend = SimpLanlib.freshLabel();
        String leq = SimpLanlib.freshLabel();
        String ret = "//OpExpNode \n"+"";
        switch (op) {
            case "&&":
                ret += left.codeGeneration() +
                        "pushr A0 \n" +
                        right.codeGeneration() +
                        "popr T1 \n" +
                        "beq A0 T1 " + ltrue + "\n" +
                        leq + ":\n" +
                        "storei A0 0 \n" +
                        "b " + lend + "\n" +
                        ltrue + ":\n" +
                        "storei A0 0 \n" +
                        "beq T1 A0 " + leq + "\n" +
                        "storei A0 1 \n" +
                        lend + ":\n";
                break;
            case "||":
                ret +=  left.codeGeneration() +
                        "pushr A0 \n" +
                        right.codeGeneration() +
                        "popr T1 \n" +
                        "beq A0 T1 " + ltrue + "\n" +
                        leq + ":\n" +
                        "storei A0 1 \n" +
                        "b " + lend + "\n" +
                        ltrue + ":\n" +
                        "storei A0 1 \n" +
                        "beq T1 A0 " + leq + "\n" +
                        "storei A0 0 \n" +
                        lend + ":\n";
                break;
        }
        return ret;
    }

    @Override
    public String toPrint(String s) {

        return s+"Op: == \n" + left.toPrint(s+"  ")  + right.toPrint(s+"  ") ;
    }
}
