package ast;

import ast.type.VoidType;
import parser.SimpLanPlusBaseVisitor;
import parser.SimpLanPlusParser;

import java.util.ArrayList;

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {


    /**
     program : (dec | stm )* ;
     * **/
    @Override
    public Node visitProgram(SimpLanPlusParser.ProgramContext ctx) {
        ProgramNode res;
        ArrayList<Node> decs = new ArrayList<Node>();
        ArrayList<Node> stms = new ArrayList<Node>();

        for(SimpLanPlusParser.DecContext dc: ctx.dec()){
            decs.add(visit(dc));
        }
        // For each statement...
        for(SimpLanPlusParser.StmContext sc: ctx.stm()){
            stms.add(visit(sc));
        }
        res = new ProgramNode(decs, stms);
        return res;
    }

    /**
     stm: asg ';'    #asgStm
         | ite       #iteStm
         | let       #letStm
         | call ';'  #callStm;
     */
    @Override
    public Node visitAsgStm(SimpLanPlusParser.AsgStmContext ctx) {
        Node res;
        res = visit(ctx.asg());
        return res;
    }

    @Override
    public Node visitIteStm(SimpLanPlusParser.IteStmContext ctx) {
        Node res;
        res = visit(ctx.ite());
        return res;
    }
    @Override
    public Node visitLetStm(SimpLanPlusParser.LetStmContext ctx) {
        Node res;
        res = visit(ctx.let());
        return res;
    }
    @Override
    public Node visitCallStm(SimpLanPlusParser.CallStmContext ctx) {
        Node res;
        res = visit(ctx.call());
        return res;
    }

    /**
     dec : decFun    #funDec
         | decVar ';'#varDec;
     */
    @Override
    public Node visitFunDec(SimpLanPlusParser.FunDecContext ctx) {
        Node res;
        res = visit(ctx.decFun());
        return res;
    }
    @Override
    public Node visitVarDec(SimpLanPlusParser.VarDecContext ctx) {
        Node res;
        res = visit(ctx.decVar());
        return res;
    }

    /**
     decFun : (type | 'void') ID '(' (decVar (',' decVar)*)? ')' body;
     */
    @Override
    public Node visitDecFun(SimpLanPlusParser.DecFunContext ctx) {
        DecFunNode res;
        ArrayList<Node> decs = new ArrayList<Node>();

        for(SimpLanPlusParser.DecVarContext dtx: ctx.decVar()){
            decs.add(visit(dtx));
        }

        if(ctx.type()!=null){
            res = new DecFunNode(visit(ctx.type()), new IdNode(ctx.ID().getText(), ctx.getStart().getLine()), decs, visit(ctx.body()), ctx.getStart().getLine());
        }
        else{
            res = new DecFunNode(new VoidType(), new IdNode(ctx.ID().getText(), ctx.getStart().getLine()), decs, visit(ctx.body()), ctx.getStart().getLine());
        }

        return res;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitDecVar(SimpLanPlusParser.DecVarContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitAsg(SimpLanPlusParser.AsgContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitCall(SimpLanPlusParser.CallContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIte(SimpLanPlusParser.IteContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitParBody(SimpLanPlusParser.ParBodyContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitNoParBody(SimpLanPlusParser.NoParBodyContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitLet(SimpLanPlusParser.LetContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitType(SimpLanPlusParser.TypeContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIdVal(SimpLanPlusParser.IdValContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitIntVal(SimpLanPlusParser.IntValContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBinExp(SimpLanPlusParser.BinExpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public T visitBoolVal(SimpLanPlusParser.BoolValContext ctx) {
        return visitChildren(ctx);
    }

}