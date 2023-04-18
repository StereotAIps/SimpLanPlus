// Generated from /Users/mae/Documents/GitHub/SimpLanPlus/SimpLanPlus/src/parser/SimpLanPlus.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpLanPlusParser}.
 */
public interface SimpLanPlusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterSingleExp(SimpLanPlusParser.SingleExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitSingleExp(SimpLanPlusParser.SingleExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterLetInExp(SimpLanPlusParser.LetInExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitLetInExp(SimpLanPlusParser.LetInExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterIdDec(SimpLanPlusParser.IdDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitIdDec(SimpLanPlusParser.IdDecContext ctx);
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
	 * Enter a parse tree produced by {@link SimpLanPlusParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(SimpLanPlusParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(SimpLanPlusParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(SimpLanPlusParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(SimpLanPlusParser.BodyContext ctx);
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
	 * Enter a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void enterIfStm(SimpLanPlusParser.IfStmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 */
	void exitIfStm(SimpLanPlusParser.IfStmContext ctx);
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
	 * Enter a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdExp(SimpLanPlusParser.IdExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdExp(SimpLanPlusParser.IdExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIfExp(SimpLanPlusParser.IfExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIfExp(SimpLanPlusParser.IfExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBoolExp(SimpLanPlusParser.BoolExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBoolExp(SimpLanPlusParser.BoolExpContext ctx);
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
	 * Enter a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNotExp(SimpLanPlusParser.NotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNotExp(SimpLanPlusParser.NotExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIntExp(SimpLanPlusParser.IntExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIntExp(SimpLanPlusParser.IntExpContext ctx);
}