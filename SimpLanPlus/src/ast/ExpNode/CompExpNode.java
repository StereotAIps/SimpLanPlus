package ast.ExpNode;

import ast.Node;
import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;
import evaluator.SimpLanlib;
import ast.Types.ErrorType;
import symboltable.SemanticError;
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
            return new BoolType();
        } else {
            System.out.println("Type Error: incompatible types in left and right operands");
            return new ErrorType();
        }
    }

    @Override
    public String codeGeneration() {
        String ltrue = SimpLanlib.freshLabel();
        String lend = SimpLanlib.freshLabel();
        String leq = SimpLanlib.freshLabel();
        String ret = "";
        switch (op){
            case ">":
                ret +=	left.codeGeneration()+
                        "pushr A0 " + " //CompExpNode \n"+
                        right.codeGeneration()+
                        "popr T1 \n" +
                        "bleq A0 T1 "+ ltrue +"\n"+ // r <= l
                        leq + ":\n"+
                        "storei A0 0 \n"+ // se l < r allora no
                        "b " + lend + "\n" +
                        ltrue + ":\n"+
                        "beq T1 A0 "+ leq +"\n"+ //se sono uguali allora 0
                        "storei A0 1 \n" +
                        lend + ":";
                break;
            case "<":
                ret+=	left.codeGeneration()+
                        "pushr A0 " + " //CompExpNode \n"+
                        right.codeGeneration()+
                        "popr T1 \n" +
                        "bleq T1 A0 "+ ltrue +"\n"+ // l <= r
                        leq + ":\n"+
                        "storei A0 0 \n"+ // se r < l allora no
                        "b " + lend + "\n" +
                        ltrue + ":\n"+
                        "beq T1 A0 "+ leq +"\n"+ //se sono uguali allora 0
                        "storei A0 1 \n" +
                        lend + ":";
                break;
            case ">=": // l >= r
                ret+=	left.codeGeneration()+
                        "pushr A0 " + " //CompExpNode \n"+
                        right.codeGeneration()+
                        "popr T1 \n" +
                        "bleq A0 T1 "+ ltrue +"\n"+ //se r <= l
                        "storei A0 0 \n"+ //se così non fosse allora 0
                        "b " + lend + "\n" +
                        ltrue + ":\n"+ //se vero restituisco 1
                        "storei A0 1 \n" +
                        lend + ":";
                break;
            case "<=": // l <= r
                ret+=	left.codeGeneration()+
                        "pushr A0 " + " //CompExpNode \n"+
                        right.codeGeneration()+
                        "popr T1 \n" +
                        "bleq T1 A0 "+ ltrue +"\n"+ //se l <= r
                        "storei A0 0 \n"+ //se così non fosse allora 0
                        "b " + lend + "\n" +
                        ltrue + ":\n"+ //se vero restituisco 1
                        "storei A0 1 \n" +
                        lend + ":";
                break;
        }
        return ret+ " //EndCompExpNode \n";
    }

    @Override
    public String toPrint(String s) {
        return s+"Op:"+op+"\n" + left.toPrint(s+"  ")  + right.toPrint(s+"  ") ;
    }
}
