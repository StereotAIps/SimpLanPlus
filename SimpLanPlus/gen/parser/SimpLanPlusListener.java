// Generated from /Users/mae/Documents/GitHub/SimpLanPlus/SimpLanPlus/src/parser/SimpLanPlus.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpLanPlusParser}.
 */
public interface SimpLanPlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SimpLanPlusParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SimpLanPlusParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asgStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterAsgStm(SimpLanPlusParser.AsgStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asgStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitAsgStm(SimpLanPlusParser.AsgStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code iteStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterIteStm(SimpLanPlusParser.IteStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code iteStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitIteStm(SimpLanPlusParser.IteStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterLetStm(SimpLanPlusParser.LetStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitLetStm(SimpLanPlusParser.LetStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterCallStm(SimpLanPlusParser.CallStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitCallStm(SimpLanPlusParser.CallStmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDec(SimpLanPlusParser.FunDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDec(SimpLanPlusParser.FunDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterVarDec(SimpLanPlusParser.VarDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitVarDec(SimpLanPlusParser.VarDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#decFun}.
	 * @param ctx the parse tree
	 */
	void enterDecFun(SimpLanPlusParser.DecFunContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#decFun}.
	 * @param ctx the parse tree
	 */
	void exitDecFun(SimpLanPlusParser.DecFunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#decVar}.
	 * @param ctx the parse tree
	 */
	void enterDecVar(SimpLanPlusParser.DecVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#decVar}.
	 * @param ctx the parse tree
	 */
	void exitDecVar(SimpLanPlusParser.DecVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#asg}.
	 * @param ctx the parse tree
	 */
	void enterAsg(SimpLanPlusParser.AsgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#asg}.
	 * @param ctx the parse tree
	 */
	void exitAsg(SimpLanPlusParser.AsgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(SimpLanPlusParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(SimpLanPlusParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#ite}.
	 * @param ctx the parse tree
	 */
	void enterIte(SimpLanPlusParser.IteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#ite}.
	 * @param ctx the parse tree
	 */
	void exitIte(SimpLanPlusParser.IteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void enterParBody(SimpLanPlusParser.ParBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void exitParBody(SimpLanPlusParser.ParBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noParBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void enterNoParBody(SimpLanPlusParser.NoParBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noParBody}
	 * labeled alternative in {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void exitNoParBody(SimpLanPlusParser.NoParBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(SimpLanPlusParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(SimpLanPlusParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(SimpLanPlusParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(SimpLanPlusParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdVal(SimpLanPlusParser.IdValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdVal(SimpLanPlusParser.IdValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(SimpLanPlusParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(SimpLanPlusParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBinExp(SimpLanPlusParser.BinExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBinExp(SimpLanPlusParser.BinExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCallExp(SimpLanPlusParser.CallExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCallExp(SimpLanPlusParser.CallExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolVal(SimpLanPlusParser.BoolValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolVal(SimpLanPlusParser.BoolValContext ctx);
}