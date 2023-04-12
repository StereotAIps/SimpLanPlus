// Generated from /Users/mae/Documents/GitHub/SimpLanPlus/SimpLanPlus/src/parser/SimpLanPlus.g4 by ANTLR 4.12.0
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpLanPlusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, BOOL=27, INTEGER=28, ID=29, WS=30, LINECOMENTS=31, 
		BLOCKCOMENTS=32, ERR=33;
	public static final int
		RULE_program = 0, RULE_stm = 1, RULE_dec = 2, RULE_decFun = 3, RULE_decVar = 4, 
		RULE_asg = 5, RULE_call = 6, RULE_ite = 7, RULE_body = 8, RULE_let = 9, 
		RULE_type = 10, RULE_exp = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stm", "dec", "decFun", "decVar", "asg", "call", "ite", "body", 
			"let", "type", "exp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'void'", "'('", "','", "')'", "'='", "'if'", "'else'", 
			"'{'", "'}'", "'let'", "'in'", "'int'", "'bool'", "'*'", "'/'", "'+'", 
			"'-'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "BOOL", "INTEGER", "ID", "WS", "LINECOMENTS", "BLOCKCOMENTS", 
			"ERR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpLanPlus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpLanPlusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536897668L) != 0)) {
				{
				setState(26);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__12:
				case T__13:
					{
					setState(24);
					dec();
					}
					break;
				case T__6:
				case T__10:
				case ID:
					{
					setState(25);
					stm();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmContext extends ParserRuleContext {
		public AsgContext asg() {
			return getRuleContext(AsgContext.class,0);
		}
		public IteContext ite() {
			return getRuleContext(IteContext.class,0);
		}
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
		}
		public StmContext stm() {
			return getRuleContext(StmContext.class,0);
		}
		public DecContext dec() {
			return getRuleContext(DecContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public StmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterStm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitStm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitStm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmContext stm() throws RecognitionException {
		StmContext _localctx = new StmContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stm);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				asg();
				setState(32);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				ite();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				let();
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__6:
				case T__10:
				case ID:
					{
					setState(36);
					stm();
					}
					break;
				case T__1:
				case T__12:
				case T__13:
					{
					setState(37);
					dec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(40);
				call();
				setState(41);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
	 
		public DecContext() { }
		public void copyFrom(DecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunDecContext extends DecContext {
		public DecFunContext decFun() {
			return getRuleContext(DecFunContext.class,0);
		}
		public FunDecContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterFunDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitFunDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitFunDec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDecContext extends DecContext {
		public DecVarContext decVar() {
			return getRuleContext(DecVarContext.class,0);
		}
		public VarDecContext(DecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterVarDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitVarDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dec);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new FunDecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				decFun();
				}
				break;
			case 2:
				_localctx = new VarDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				decVar();
				setState(47);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecFunContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DecVarContext> decVar() {
			return getRuleContexts(DecVarContext.class);
		}
		public DecVarContext decVar(int i) {
			return getRuleContext(DecVarContext.class,i);
		}
		public DecFunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decFun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterDecFun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitDecFun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDecFun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecFunContext decFun() throws RecognitionException {
		DecFunContext _localctx = new DecFunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decFun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
				{
				setState(51);
				type();
				}
				break;
			case T__1:
				{
				setState(52);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(55);
			match(ID);
			setState(56);
			match(T__2);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__13) {
				{
				setState(57);
				decVar();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(58);
					match(T__3);
					setState(59);
					decVar();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(67);
			match(T__4);
			setState(68);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecVarContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public DecVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterDecVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitDecVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitDecVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecVarContext decVar() throws RecognitionException {
		DecVarContext _localctx = new DecVarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			type();
			setState(71);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AsgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AsgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterAsg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitAsg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitAsg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsgContext asg() throws RecognitionException {
		AsgContext _localctx = new AsgContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_asg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			setState(74);
			match(T__5);
			setState(75);
			exp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ID);
			setState(78);
			match(T__2);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524104L) != 0)) {
				{
				setState(79);
				exp(0);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(80);
					match(T__3);
					setState(81);
					exp(0);
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(89);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IteContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public IteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterIte(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitIte(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitIte(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteContext ite() throws RecognitionException {
		IteContext _localctx = new IteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__6);
			setState(92);
			match(T__2);
			setState(93);
			exp(0);
			setState(94);
			match(T__4);
			setState(95);
			body();
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(96);
				match(T__7);
				setState(97);
				body();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<StmContext> stm() {
			return getRuleContexts(StmContext.class);
		}
		public StmContext stm(int i) {
			return getRuleContext(StmContext.class,i);
		}
		public List<DecVarContext> decVar() {
			return getRuleContexts(DecVarContext.class);
		}
		public DecVarContext decVar(int i) {
			return getRuleContext(DecVarContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_body);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(T__8);
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 536897664L) != 0)) {
						{
						setState(108);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__12:
						case T__13:
							{
							{
							setState(101);
							decVar();
							setState(102);
							match(T__0);
							}
							}
							break;
						case T__6:
						case T__10:
						case ID:
							{
							setState(104);
							stm();
							setState(106);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
							case 1:
								{
								setState(105);
								exp(0);
								}
								break;
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(112);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(113);
					exp(0);
					}
					break;
				}
				setState(116);
				match(T__9);
				}
				break;
			case T__2:
			case T__6:
			case T__10:
			case BOOL:
			case INTEGER:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(117);
					stm();
					}
					break;
				case 2:
					{
					setState(118);
					exp(0);
					setState(119);
					match(T__0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ParserRuleContext {
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(T__10);
			setState(127); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(126);
				dec();
				}
				}
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 24580L) != 0) );
			setState(131);
			match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==T__13) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseExpContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BaseExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBaseExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBaseExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBaseExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarExpContext extends ExpContext {
		public TerminalNode ID() { return getToken(SimpLanPlusParser.ID, 0); }
		public VarExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitVarExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitVarExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinExpContext extends ExpContext {
		public ExpContext left;
		public Token op;
		public ExpContext right;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBinExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBinExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBinExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValExpContext extends ExpContext {
		public TerminalNode INTEGER() { return getToken(SimpLanPlusParser.INTEGER, 0); }
		public ValExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterValExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitValExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitValExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolExpContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(SimpLanPlusParser.BOOL, 0); }
		public BoolExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterBoolExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitBoolExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitBoolExp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExpContext extends ExpContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CallExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).enterCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpLanPlusListener ) ((SimpLanPlusListener)listener).exitCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpLanPlusVisitor ) return ((SimpLanPlusVisitor<? extends T>)visitor).visitCallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new BaseExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(136);
				match(T__2);
				setState(137);
				exp(0);
				setState(138);
				match(T__4);
				}
				break;
			case 2:
				{
				_localctx = new VarExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new CallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(141);
				call();
				}
				break;
			case 4:
				{
				_localctx = new BoolExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(142);
				match(BOOL);
				}
				break;
			case 5:
				{
				_localctx = new ValExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(INTEGER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(164);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(146);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(147);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__15) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						((BinExpContext)_localctx).right = exp(10);
						}
						break;
					case 2:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(149);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(150);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						((BinExpContext)_localctx).right = exp(9);
						}
						break;
					case 3:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(152);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(153);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(154);
						((BinExpContext)_localctx).right = exp(8);
						}
						break;
					case 4:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(155);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(156);
						((BinExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((BinExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(157);
						((BinExpContext)_localctx).right = exp(7);
						}
						break;
					case 5:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(158);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(159);
						((BinExpContext)_localctx).op = match(T__24);
						setState(160);
						((BinExpContext)_localctx).right = exp(6);
						}
						break;
					case 6:
						{
						_localctx = new BinExpContext(new ExpContext(_parentctx, _parentState));
						((BinExpContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(161);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(162);
						((BinExpContext)_localctx).op = match(T__25);
						setState(163);
						((BinExpContext)_localctx).right = exp(5);
						}
						break;
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u00aa\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001"+
		"\u0000\u0001\u0000\u0005\u0000\u001b\b\u0000\n\u0000\f\u0000\u001e\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001,\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00022\b\u0002\u0001\u0003\u0001\u0003\u0003\u00036\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003=\b"+
		"\u0003\n\u0003\f\u0003@\t\u0003\u0003\u0003B\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0003"+
		"\u0006X\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007c\b"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bk\b\b\u0005"+
		"\bm\b\b\n\b\f\bp\t\b\u0001\b\u0003\bs\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bz\b\b\u0003\b|\b\b\u0001\t\u0001\t\u0004\t\u0080\b\t"+
		"\u000b\t\f\t\u0081\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0091\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00a5\b\u000b\n\u000b"+
		"\f\u000b\u00a8\t\u000b\u0001\u000b\u0000\u0001\u0016\f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0005\u0001\u0000\r\u000e"+
		"\u0001\u0000\u000f\u0010\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0016"+
		"\u0001\u0000\u0017\u0018\u00bb\u0000\u001c\u0001\u0000\u0000\u0000\u0002"+
		"+\u0001\u0000\u0000\u0000\u00041\u0001\u0000\u0000\u0000\u00065\u0001"+
		"\u0000\u0000\u0000\bF\u0001\u0000\u0000\u0000\nI\u0001\u0000\u0000\u0000"+
		"\fM\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000\u0010{\u0001"+
		"\u0000\u0000\u0000\u0012}\u0001\u0000\u0000\u0000\u0014\u0085\u0001\u0000"+
		"\u0000\u0000\u0016\u0090\u0001\u0000\u0000\u0000\u0018\u001b\u0003\u0004"+
		"\u0002\u0000\u0019\u001b\u0003\u0002\u0001\u0000\u001a\u0018\u0001\u0000"+
		"\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000"+
		"\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000"+
		"\u0000\u0000\u001d\u0001\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000"+
		"\u0000\u0000\u001f \u0003\n\u0005\u0000 !\u0005\u0001\u0000\u0000!,\u0001"+
		"\u0000\u0000\u0000\",\u0003\u000e\u0007\u0000#&\u0003\u0012\t\u0000$\'"+
		"\u0003\u0002\u0001\u0000%\'\u0003\u0004\u0002\u0000&$\u0001\u0000\u0000"+
		"\u0000&%\u0001\u0000\u0000\u0000\',\u0001\u0000\u0000\u0000()\u0003\f"+
		"\u0006\u0000)*\u0005\u0001\u0000\u0000*,\u0001\u0000\u0000\u0000+\u001f"+
		"\u0001\u0000\u0000\u0000+\"\u0001\u0000\u0000\u0000+#\u0001\u0000\u0000"+
		"\u0000+(\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-2\u0003"+
		"\u0006\u0003\u0000./\u0003\b\u0004\u0000/0\u0005\u0001\u0000\u000002\u0001"+
		"\u0000\u0000\u00001-\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u0000"+
		"2\u0005\u0001\u0000\u0000\u000036\u0003\u0014\n\u000046\u0005\u0002\u0000"+
		"\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000078\u0005\u001d\u0000\u00008A\u0005\u0003\u0000\u00009>\u0003"+
		"\b\u0004\u0000:;\u0005\u0004\u0000\u0000;=\u0003\b\u0004\u0000<:\u0001"+
		"\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000"+
		"\u0000A9\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CD\u0005\u0005\u0000\u0000DE\u0003\u0010\b\u0000E\u0007\u0001"+
		"\u0000\u0000\u0000FG\u0003\u0014\n\u0000GH\u0005\u001d\u0000\u0000H\t"+
		"\u0001\u0000\u0000\u0000IJ\u0005\u001d\u0000\u0000JK\u0005\u0006\u0000"+
		"\u0000KL\u0003\u0016\u000b\u0000L\u000b\u0001\u0000\u0000\u0000MN\u0005"+
		"\u001d\u0000\u0000NW\u0005\u0003\u0000\u0000OT\u0003\u0016\u000b\u0000"+
		"PQ\u0005\u0004\u0000\u0000QS\u0003\u0016\u000b\u0000RP\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WO\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0005\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0005\u0007\u0000"+
		"\u0000\\]\u0005\u0003\u0000\u0000]^\u0003\u0016\u000b\u0000^_\u0005\u0005"+
		"\u0000\u0000_b\u0003\u0010\b\u0000`a\u0005\b\u0000\u0000ac\u0003\u0010"+
		"\b\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\u000f\u0001"+
		"\u0000\u0000\u0000dr\u0005\t\u0000\u0000ef\u0003\b\u0004\u0000fg\u0005"+
		"\u0001\u0000\u0000gm\u0001\u0000\u0000\u0000hj\u0003\u0002\u0001\u0000"+
		"ik\u0003\u0016\u000b\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000km\u0001\u0000\u0000\u0000le\u0001\u0000\u0000\u0000lh\u0001\u0000"+
		"\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001"+
		"\u0000\u0000\u0000os\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"qs\u0003\u0016\u000b\u0000rn\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000t|\u0005\n\u0000\u0000uz\u0003\u0002\u0001"+
		"\u0000vw\u0003\u0016\u000b\u0000wx\u0005\u0001\u0000\u0000xz\u0001\u0000"+
		"\u0000\u0000yu\u0001\u0000\u0000\u0000yv\u0001\u0000\u0000\u0000z|\u0001"+
		"\u0000\u0000\u0000{d\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"|\u0011\u0001\u0000\u0000\u0000}\u007f\u0005\u000b\u0000\u0000~\u0080"+
		"\u0003\u0004\u0002\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"\f\u0000\u0000\u0084\u0013\u0001\u0000\u0000\u0000\u0085\u0086\u0007\u0000"+
		"\u0000\u0000\u0086\u0015\u0001\u0000\u0000\u0000\u0087\u0088\u0006\u000b"+
		"\uffff\uffff\u0000\u0088\u0089\u0005\u0003\u0000\u0000\u0089\u008a\u0003"+
		"\u0016\u000b\u0000\u008a\u008b\u0005\u0005\u0000\u0000\u008b\u0091\u0001"+
		"\u0000\u0000\u0000\u008c\u0091\u0005\u001d\u0000\u0000\u008d\u0091\u0003"+
		"\f\u0006\u0000\u008e\u0091\u0005\u001b\u0000\u0000\u008f\u0091\u0005\u001c"+
		"\u0000\u0000\u0090\u0087\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000"+
		"\u0000\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u00a6\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\n\t\u0000\u0000\u0093\u0094\u0007\u0001\u0000"+
		"\u0000\u0094\u00a5\u0003\u0016\u000b\n\u0095\u0096\n\b\u0000\u0000\u0096"+
		"\u0097\u0007\u0002\u0000\u0000\u0097\u00a5\u0003\u0016\u000b\t\u0098\u0099"+
		"\n\u0007\u0000\u0000\u0099\u009a\u0007\u0003\u0000\u0000\u009a\u00a5\u0003"+
		"\u0016\u000b\b\u009b\u009c\n\u0006\u0000\u0000\u009c\u009d\u0007\u0004"+
		"\u0000\u0000\u009d\u00a5\u0003\u0016\u000b\u0007\u009e\u009f\n\u0005\u0000"+
		"\u0000\u009f\u00a0\u0005\u0019\u0000\u0000\u00a0\u00a5\u0003\u0016\u000b"+
		"\u0006\u00a1\u00a2\n\u0004\u0000\u0000\u00a2\u00a3\u0005\u001a\u0000\u0000"+
		"\u00a3\u00a5\u0003\u0016\u000b\u0005\u00a4\u0092\u0001\u0000\u0000\u0000"+
		"\u00a4\u0095\u0001\u0000\u0000\u0000\u00a4\u0098\u0001\u0000\u0000\u0000"+
		"\u00a4\u009b\u0001\u0000\u0000\u0000\u00a4\u009e\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u0017\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u0015\u001a\u001c&+15>ATWbjlnry{\u0081\u0090\u00a4\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}