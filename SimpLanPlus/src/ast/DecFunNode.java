package ast;

import ast.type.Type;

import java.util.ArrayList;

/**
 decFun : (type | 'void') ID '(' (decVar (',' decVar)*)? ')' body ;
 **/
public class DecFunNode implements Node{
//
    private Type type;
    private IdNode id;
    private ArrayList<Node> args;
    private Node body;
    //private Environment localenv;
    private int line;

    public DecFunNode(Node type, Node id, ArrayList<Node> args, Node body, int line) {
        this.type = (Type) type;
        this.id = (IdNode) id;
        this.args = args;
        this.body = body;
        this.line = line;
    }

    @Override
    public String codeGeneration() {
        return null;
    }

    @Override
    public String toPrint(String s) {
        return null;
    }
}
