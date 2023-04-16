// Generated from /Users/mae/Documents/GitHub/SimpLanPlus/SimpLanPlus/src/parser/SimpLanPlus.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpLanPlusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpLanPlusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SimpLanPlusParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asgStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgStm(SimpLanPlusParser.AsgStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code iteStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteStm(SimpLanPlusParser.IteStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetStm(SimpLanPlusParser.LetStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStm(SimpLanPlusParser.CallStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDec(SimpLanPlusParser.FunDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(SimpLanPlusParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#decFun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecFun(SimpLanPlusParser.DecFunContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#decVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecVar(SimpLanPlusParser.DecVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#asg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsg(SimpLanPlusParser.AsgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(SimpLanPlusParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#ite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIte(SimpLanPlusParser.IteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParBody(SimpLanPlusParser.ParBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noParBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoParBody(SimpLanPlusParser.NoParBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(SimpLanPlusParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExp(SimpLanPlusParser.BaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdVal(SimpLanPlusParser.IdValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(SimpLanPlusParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExp(SimpLanPlusParser.BinExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExp(SimpLanPlusParser.CallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(SimpLanPlusParser.BoolValContext ctx);
}