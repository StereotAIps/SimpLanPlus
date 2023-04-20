package ast;

import ast.Types.Type;
import semanticanalysis.SemanticError;

import java.util.ArrayList;

/**
 *  exp: 'if' '(' cond=exp ')' '{' (thenStm=stm)* thenExp=exp '}' 'else' '{' (elseStm=stm)* elseExp=exp '}'  #ifExp
 * **/
public class IfExpNode implements Node {
    private Node exp;
    private ArrayList<Node> thenStm;
    private Node thenExp;
    private ArrayList<Node> elseStm;
    private Node elseExp;

    public IfExpNode(Node _guard, ArrayList<Node> _thenStm, Node _thenExp, ArrayList<Node> _elseStm, Node _elseExp) {
        exp = _guard;
        thenStm = _thenStm;
        thenExp = _thenExp;
        elseStm = _elseStm;
        elseExp = _elseExp;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(SymbolTable ST, int _nesting) {
//        ArrayList<SemanticError> errors = new ArrayList<SemanticError>();
//
//        errors.addAll(guard.checkSemantics(ST, _nesting));
//        errors.addAll(thenbranch.checkSemantics(ST, _nesting));
//        errors.addAll(elsebranch.checkSemantics(ST, _nesting));
//
//        return errors;
        return null;
    }

    public Type typeCheck() {
//        if (guard.typeCheck() instanceof BoolType) {
//            Type thenexp = thenbranch.typeCheck() ;
//            Type elseexp = elsebranch.typeCheck() ;
//            if (thenexp.getClass().equals(elseexp.getClass()))
//                return thenexp;
//            else {
//                System.out.println("Type Error: incompatible types in then and else branches");
//                return new ErrorType() ;
//            }
//        } else {
//            System.out.println("Type Error: non boolean condition in if");
//            return new ErrorType() ;
//        }
        return null;
    }

    public String codeGeneration() {
//        String lthen = SimpLanlib.freshLabel();
//        String lend = SimpLanlib.freshLabel();
//        return guard.codeGeneration() +
//                "storei T1 1 \n" +
//                "beq A0 T1 "+ lthen + "\n" +
//                elsebranch.codeGeneration() +
//                "b " + lend + "\n" +
//                lthen + ":\n" +
//                thenbranch.codeGeneration() +
//                lend + ":\n" ;
        return null;
    }

    @Override
    public String toPrint(String s) {
        String thenStmStr=s+"Then: \n";
        for (Node d : thenStm)
            thenStmStr += d.toPrint(s+"  ");
        String elseStmStr=s+"Else:\n";
        for (Node d : elseStm)
            elseStmStr += d.toPrint(s+"  ");
        return s+"IfExp\n" + exp.toPrint(s+"Cond:\n    ") +thenStmStr + thenExp.toPrint(s+"    ")+ elseStmStr+ elseExp.toPrint(s+"    ");

    }
}
