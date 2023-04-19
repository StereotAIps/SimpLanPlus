package ast;

import ast.ExpNode.*;
import ast.Types.BoolType;
import ast.Types.IntType;
import ast.Types.Type;
import ast.Types.VoidType;
import parser.SimpLanPlusBaseVisitor;
import parser.SimpLanPlusParser;
import parser.SimpLanPlusParser.DecContext;
import parser.SimpLanPlusParser.StmContext;
import parser.SimpLanPlusParser.ExpContext;
import parser.SimpLanPlusParser.ParamContext;
import java.util.ArrayList;

public class SimpLanPlusVisitorImpl extends SimpLanPlusBaseVisitor<Node> {
    /**
     prog   : exp                                                            #expProg
     */
    @Override public Node visitExpProg(SimpLanPlusParser.ExpProgContext ctx) {
        return new ProgNode(visit(ctx.exp()));
    }
    /**
     prog   : (dec)+ (stm)* (exp)?                                           #letProg
     */
    @Override public Node visitLetProg(SimpLanPlusParser.LetProgContext ctx) {
        //list of declarations in @res
        ArrayList<Node> declarations = new ArrayList<Node>();
        ArrayList<Node> statements = new ArrayList<Node>();

        for (DecContext dc : ctx.dec()){
            declarations.add( visit(dc) );
        }

        for (StmContext st : ctx.stm()){
            statements.add( visit(st) );
        }

        if(ctx.exp()!=null){
            //visit exp context
            Node exp = visit( ctx.exp() );

            return new ProgLetInNode(declarations, statements, exp);
        }

        //build @res accordingly with the result of the visits to its content
        return new ProgLetInNode(declarations, statements);
    }
    /**
     dec    : type ID ';'                                                    #varDec
     */
    @Override public Node visitVarDec(SimpLanPlusParser.VarDecContext ctx) {
        return new ParNode(ctx.ID().getText(), (Type) visit( ctx.type() ));
    }
    /**
     dec    : type ID '(' ( param ( ',' param)* )? ')' '{' body '}'          #funDec
     */
    @Override public Node visitFunDec(SimpLanPlusParser.FunDecContext ctx) {
        //initialize @res with the visits to the type and its ID

        //add argument declarations
        //we are getting a shortcut here by constructing directly the ParNode
        //this could be done differently by visiting instead the VardecContext
        ArrayList<ParNode> _param = new ArrayList<ParNode>() ;

        for (ParamContext vc : ctx.param())
            _param.add( new ParNode(vc.ID().getText(), (Type) visit( vc.type() )) );

        Node body = visit(ctx.body());

        return new DecfunNode(ctx.ID().getText(), (Type) visit(ctx.type()), _param, body);

    }
    /**
     param  : type ID ;
     */
    @Override public Node visitParam(SimpLanPlusParser.ParamContext ctx) {
        return new ParNode(ctx.ID().getText(), (Type) visit( ctx.type() ));
    }
    /**
     body   : (dec)* (stm)* (exp)?
     */
    @Override public Node visitBody(SimpLanPlusParser.BodyContext ctx) {
        ArrayList<Node> declarations = new ArrayList<Node>();
        ArrayList<Node> statements = new ArrayList<Node>();

        for (DecContext dc : ctx.dec()){
            declarations.add( visit(dc) );
        }

        for (StmContext st : ctx.stm()){
            statements.add( visit(st) );
        }

        if(ctx.exp()!=null){
            //visit exp context
            Node exp = visit( ctx.exp() );

            return new BodyNode(declarations, statements, exp);
        }

        //build @res accordingly with the result of the visits to its content
        return new BodyNode(declarations, statements);
    }
    /**
     type   : 'int'
             | 'bool'
             | 'void'
             ;
     */
    @Override public Node visitType(SimpLanPlusParser.TypeContext ctx) {

        if(ctx.getText().equals("int"))
            return new IntType();
        if(ctx.getText().equals("bool"))
            return new BoolType();
        else return new VoidType();
    }
    /**
     stm    : ID '=' exp ';'                                                 #asgStm
     */
    @Override public Node visitAsgStm(SimpLanPlusParser.AsgStmContext ctx) {
        return new AsgNode(ctx.ID().getText(), visit(ctx.exp()));
    }
    /**
     stm    : ID '(' (exp (',' exp)* )? ')' ';'                                                                   #callStm
     */
    @Override public Node visitCallStm(SimpLanPlusParser.CallStmContext ctx) {
        ArrayList<Node> explist = new ArrayList<Node>();

        for (ExpContext exp : ctx.exp())
            explist.add(visit(exp));

        return new CallNode(ctx.ID().getText(), explist);
    }
    /**
     stm    : 'if' '(' exp ')' '{' (stm)+ '}' ('else' '{' (stm)+ '}')?      #ifStm
     */
    @Override public Node visitIfStm(SimpLanPlusParser.IfStmContext ctx) {

        ArrayList<Node> _stm = new ArrayList<Node>() ;

        for (StmContext st : ctx.stm())
            _stm.add( visit(st) );

        return new IfStmNode(visit(ctx.exp()), _stm);
    }
    /**
     * exp: '(' exp ')' #baseExp
     * */
    @Override public Node visitBaseExp(SimpLanPlusParser.BaseExpContext ctx) {
        return visit(ctx.exp());
    }
    /**
     * exp: | ID                                                                                                  #idExp
     */
    @Override public Node visitIdExp(SimpLanPlusParser.IdExpContext ctx) {
        return new IdNode(ctx.ID().getText());
    }
    /**
     * exp: 'if' '(' cond=exp ')' '{' (thenStm=stm)* thenExp=exp '}' 'else' '{' (elseStm=stm)* elseExp=exp '}'  #ifExp
     */
    @Override public Node visitIfExp(SimpLanPlusParser.IfExpContext ctx) {
        ArrayList<Node> _stm = new ArrayList<Node>() ;

        for (StmContext st : ctx.stm())
            _stm.add( visit(st) );

        return new IfExpNode(visit(ctx.cond),_stm, visit(ctx.thenExp),_stm, visit(ctx.elseExp));
    }
    /**
     * exp: leftExp=exp ('>' | '<' | '>=' | '<=' ) rightExp=exp                                                 #compExp
     */
    @Override public Node visitCompExp(SimpLanPlusParser.CompExpContext ctx) {
        return new CompExpNode(visit(ctx.leftExp), visit(ctx.rightExp));
    }
    /**
     * exp: ('true' | 'false')                                                                                  #boolExp
     */
    @Override public Node visitBoolExp(SimpLanPlusParser.BoolExpContext ctx) {
        return new BoolNode(Boolean.parseBoolean(ctx.getText()));
    }
    /**
     * exp: ID '(' (exp (',' exp)* )? ')'                                                                       #callExp
     */
    @Override public Node visitCallExp(SimpLanPlusParser.CallExpContext ctx) {
        ArrayList<Node> args = new ArrayList<Node>();

        for (ExpContext exp : ctx.exp())
            args.add(visit(exp));

        return new CallNode(ctx.ID().getText(), args);
    }
    /**
     * exp: leftExp=exp ('&&' | '||') rightExp=exp                                                              #opExp
     */
    @Override public Node visitOpExp(SimpLanPlusParser.OpExpContext ctx) {
        return new OpExpNode(visit(ctx.leftExp), visit(ctx.rightExp));
    }
    /**
     * exp:'!' exp                                                                                             #notExp
     * */
    @Override public Node visitNotExp(SimpLanPlusParser.NotExpContext ctx) {
        return new NotExpNode(visit(ctx.exp()));
    }
    /**
     * exp    :  INTEGER                                                                                            #intExp
     */
    @Override public Node visitIntExp(SimpLanPlusParser.IntExpContext ctx) {
        return new IntExpNode(Integer.parseInt(ctx.INTEGER().getText()));
    }
    /**
     * exp: leftExp=exp ('*' | '/') rightExp=exp                                                                #numExp
     *    | leftExp=exp ('+' | '-') rightExp=exp                                                                #numExp
     */
    @Override public Node visitNumExp(SimpLanPlusParser.NumExpContext ctx) {
        return new NumExpNode(visit(ctx.leftExp), visit(ctx.rightExp));
    }
}
