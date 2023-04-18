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
	 * Visit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(SimpLanPlusParser.SingleExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link SimpLanPlusParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetInExp(SimpLanPlusParser.LetInExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdDec(SimpLanPlusParser.IdDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDec}
	 * labeled alternative in {@link SimpLanPlusParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDec(SimpLanPlusParser.FunDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(SimpLanPlusParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(SimpLanPlusParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpLanPlusParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asgStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsgStm(SimpLanPlusParser.AsgStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallStm(SimpLanPlusParser.CallStmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStm}
	 * labeled alternative in {@link SimpLanPlusParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStm(SimpLanPlusParser.IfStmContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpLanPlusParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(SimpLanPlusParser.CallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExp(SimpLanPlusParser.BaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExp(SimpLanPlusParser.BinExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExp(SimpLanPlusParser.IdExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExp(SimpLanPlusParser.IfExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExp(SimpLanPlusParser.BoolExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExp(SimpLanPlusParser.CallExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExp(SimpLanPlusParser.NotExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExp}
	 * labeled alternative in {@link SimpLanPlusParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExp(SimpLanPlusParser.IntExpContext ctx);
}