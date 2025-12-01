// Generated from TIME_FLOW.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TIME_FLOWParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TASK=1, EXECUTE=2, EVERY=3, IF=4, DO=5, HAS_FINISHED=6, AFTER=7, MINUTES=8, 
		SECONDS=9, HOURS=10, DAYS=11, SEMI=12, LPAREN=13, RPAREN=14, LBRACE=15, 
		RBRACE=16, ID=17, INT_LITERAL=18, WS=19, COMMENT=20, LINE_COMMENT=21;
	public static final int
		RULE_program = 0, RULE_task_declaration = 1, RULE_task_body = 2, RULE_restriction = 3, 
		RULE_execute_restriction = 4, RULE_conditional_restriction = 5, RULE_temporal_condition = 6, 
		RULE_task_ref = 7, RULE_action_body = 8, RULE_duration = 9, RULE_time_unit = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "task_declaration", "task_body", "restriction", "execute_restriction", 
			"conditional_restriction", "temporal_condition", "task_ref", "action_body", 
			"duration", "time_unit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TASK'", "'EXECUTE'", "'EVERY'", "'IF'", "'DO'", "'HAS_FINISHED'", 
			"'AFTER'", "'MINUTES'", "'SECONDS'", "'HOURS'", "'DAYS'", "';'", "'('", 
			"')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TASK", "EXECUTE", "EVERY", "IF", "DO", "HAS_FINISHED", "AFTER", 
			"MINUTES", "SECONDS", "HOURS", "DAYS", "SEMI", "LPAREN", "RPAREN", "LBRACE", 
			"RBRACE", "ID", "INT_LITERAL", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "TIME_FLOW.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TIME_FLOWParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TIME_FLOWParser.EOF, 0); }
		public List<Task_declarationContext> task_declaration() {
			return getRuleContexts(Task_declarationContext.class);
		}
		public Task_declarationContext task_declaration(int i) {
			return getRuleContext(Task_declarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TASK) {
				{
				{
				setState(22);
				task_declaration();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
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
	public static class Task_declarationContext extends ParserRuleContext {
		public TerminalNode TASK() { return getToken(TIME_FLOWParser.TASK, 0); }
		public TerminalNode ID() { return getToken(TIME_FLOWParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(TIME_FLOWParser.LBRACE, 0); }
		public Task_bodyContext task_body() {
			return getRuleContext(Task_bodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TIME_FLOWParser.RBRACE, 0); }
		public TerminalNode SEMI() { return getToken(TIME_FLOWParser.SEMI, 0); }
		public Task_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterTask_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitTask_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitTask_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Task_declarationContext task_declaration() throws RecognitionException {
		Task_declarationContext _localctx = new Task_declarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_task_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(TASK);
			setState(31);
			match(ID);
			setState(32);
			match(LBRACE);
			setState(33);
			task_body();
			setState(34);
			match(RBRACE);
			setState(35);
			match(SEMI);
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
	public static class Task_bodyContext extends ParserRuleContext {
		public List<RestrictionContext> restriction() {
			return getRuleContexts(RestrictionContext.class);
		}
		public RestrictionContext restriction(int i) {
			return getRuleContext(RestrictionContext.class,i);
		}
		public Task_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterTask_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitTask_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitTask_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Task_bodyContext task_body() throws RecognitionException {
		Task_bodyContext _localctx = new Task_bodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_task_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXECUTE || _la==IF) {
				{
				{
				setState(37);
				restriction();
				}
				}
				setState(42);
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
	public static class RestrictionContext extends ParserRuleContext {
		public Execute_restrictionContext execute_restriction() {
			return getRuleContext(Execute_restrictionContext.class,0);
		}
		public Conditional_restrictionContext conditional_restriction() {
			return getRuleContext(Conditional_restrictionContext.class,0);
		}
		public RestrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterRestriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitRestriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitRestriction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestrictionContext restriction() throws RecognitionException {
		RestrictionContext _localctx = new RestrictionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_restriction);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EXECUTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				execute_restriction();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				conditional_restriction();
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
	public static class Execute_restrictionContext extends ParserRuleContext {
		public TerminalNode EXECUTE() { return getToken(TIME_FLOWParser.EXECUTE, 0); }
		public TerminalNode EVERY() { return getToken(TIME_FLOWParser.EVERY, 0); }
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TIME_FLOWParser.SEMI, 0); }
		public Execute_restrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execute_restriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterExecute_restriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitExecute_restriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitExecute_restriction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Execute_restrictionContext execute_restriction() throws RecognitionException {
		Execute_restrictionContext _localctx = new Execute_restrictionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_execute_restriction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(EXECUTE);
			setState(48);
			match(EVERY);
			setState(49);
			duration();
			setState(50);
			match(SEMI);
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
	public static class Conditional_restrictionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TIME_FLOWParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(TIME_FLOWParser.LPAREN, 0); }
		public Temporal_conditionContext temporal_condition() {
			return getRuleContext(Temporal_conditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TIME_FLOWParser.RPAREN, 0); }
		public TerminalNode DO() { return getToken(TIME_FLOWParser.DO, 0); }
		public TerminalNode LBRACE() { return getToken(TIME_FLOWParser.LBRACE, 0); }
		public Action_bodyContext action_body() {
			return getRuleContext(Action_bodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(TIME_FLOWParser.RBRACE, 0); }
		public TerminalNode SEMI() { return getToken(TIME_FLOWParser.SEMI, 0); }
		public Conditional_restrictionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional_restriction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterConditional_restriction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitConditional_restriction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitConditional_restriction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Conditional_restrictionContext conditional_restriction() throws RecognitionException {
		Conditional_restrictionContext _localctx = new Conditional_restrictionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conditional_restriction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(IF);
			setState(53);
			match(LPAREN);
			setState(54);
			temporal_condition();
			setState(55);
			match(RPAREN);
			setState(56);
			match(DO);
			setState(57);
			match(LBRACE);
			setState(58);
			action_body();
			setState(59);
			match(RBRACE);
			setState(60);
			match(SEMI);
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
	public static class Temporal_conditionContext extends ParserRuleContext {
		public Task_refContext task_ref() {
			return getRuleContext(Task_refContext.class,0);
		}
		public TerminalNode HAS_FINISHED() { return getToken(TIME_FLOWParser.HAS_FINISHED, 0); }
		public TerminalNode AFTER() { return getToken(TIME_FLOWParser.AFTER, 0); }
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public Temporal_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporal_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterTemporal_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitTemporal_condition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitTemporal_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Temporal_conditionContext temporal_condition() throws RecognitionException {
		Temporal_conditionContext _localctx = new Temporal_conditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_temporal_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			task_ref();
			setState(63);
			match(HAS_FINISHED);
			setState(64);
			match(AFTER);
			setState(65);
			duration();
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
	public static class Task_refContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TIME_FLOWParser.ID, 0); }
		public Task_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterTask_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitTask_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitTask_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Task_refContext task_ref() throws RecognitionException {
		Task_refContext _localctx = new Task_refContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_task_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
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
	public static class Action_bodyContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(TIME_FLOWParser.SEMI, 0); }
		public List<TerminalNode> ID() { return getTokens(TIME_FLOWParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TIME_FLOWParser.ID, i);
		}
		public Action_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterAction_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitAction_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitAction_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_bodyContext action_body() throws RecognitionException {
		Action_bodyContext _localctx = new Action_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_action_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				match(ID);
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(74);
			match(SEMI);
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
	public static class DurationContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(TIME_FLOWParser.INT_LITERAL, 0); }
		public Time_unitContext time_unit() {
			return getRuleContext(Time_unitContext.class,0);
		}
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_duration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(INT_LITERAL);
			setState(77);
			time_unit();
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
	public static class Time_unitContext extends ParserRuleContext {
		public TerminalNode MINUTES() { return getToken(TIME_FLOWParser.MINUTES, 0); }
		public TerminalNode SECONDS() { return getToken(TIME_FLOWParser.SECONDS, 0); }
		public TerminalNode HOURS() { return getToken(TIME_FLOWParser.HOURS, 0); }
		public TerminalNode DAYS() { return getToken(TIME_FLOWParser.DAYS, 0); }
		public Time_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).enterTime_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TIME_FLOWListener ) ((TIME_FLOWListener)listener).exitTime_unit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TIME_FLOWVisitor ) return ((TIME_FLOWVisitor<? extends T>)visitor).visitTime_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Time_unitContext time_unit() throws RecognitionException {
		Time_unitContext _localctx = new Time_unitContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_time_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3840L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u0015R\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018"+
		"\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0005\u0002\'\b\u0002\n\u0002\f\u0002*\t\u0002\u0001\u0003"+
		"\u0001\u0003\u0003\u0003.\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0004\bG\b\b\u000b\b\f\bH\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0000\u0000\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0001\u0001\u0000\b\u000b"+
		"J\u0000\u0019\u0001\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000\u0000"+
		"\u0004(\u0001\u0000\u0000\u0000\u0006-\u0001\u0000\u0000\u0000\b/\u0001"+
		"\u0000\u0000\u0000\n4\u0001\u0000\u0000\u0000\f>\u0001\u0000\u0000\u0000"+
		"\u000eC\u0001\u0000\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012L"+
		"\u0001\u0000\u0000\u0000\u0014O\u0001\u0000\u0000\u0000\u0016\u0018\u0003"+
		"\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d\u0001\u0001"+
		"\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0005\u0011"+
		"\u0000\u0000 !\u0005\u000f\u0000\u0000!\"\u0003\u0004\u0002\u0000\"#\u0005"+
		"\u0010\u0000\u0000#$\u0005\f\u0000\u0000$\u0003\u0001\u0000\u0000\u0000"+
		"%\'\u0003\u0006\u0003\u0000&%\u0001\u0000\u0000\u0000\'*\u0001\u0000\u0000"+
		"\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\u0005\u0001"+
		"\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+.\u0003\b\u0004\u0000,.\u0003"+
		"\n\u0005\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000\u0000\u0000.\u0007"+
		"\u0001\u0000\u0000\u0000/0\u0005\u0002\u0000\u000001\u0005\u0003\u0000"+
		"\u000012\u0003\u0012\t\u000023\u0005\f\u0000\u00003\t\u0001\u0000\u0000"+
		"\u000045\u0005\u0004\u0000\u000056\u0005\r\u0000\u000067\u0003\f\u0006"+
		"\u000078\u0005\u000e\u0000\u000089\u0005\u0005\u0000\u00009:\u0005\u000f"+
		"\u0000\u0000:;\u0003\u0010\b\u0000;<\u0005\u0010\u0000\u0000<=\u0005\f"+
		"\u0000\u0000=\u000b\u0001\u0000\u0000\u0000>?\u0003\u000e\u0007\u0000"+
		"?@\u0005\u0006\u0000\u0000@A\u0005\u0007\u0000\u0000AB\u0003\u0012\t\u0000"+
		"B\r\u0001\u0000\u0000\u0000CD\u0005\u0011\u0000\u0000D\u000f\u0001\u0000"+
		"\u0000\u0000EG\u0005\u0011\u0000\u0000FE\u0001\u0000\u0000\u0000GH\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JK\u0005\f\u0000\u0000K\u0011\u0001\u0000\u0000"+
		"\u0000LM\u0005\u0012\u0000\u0000MN\u0003\u0014\n\u0000N\u0013\u0001\u0000"+
		"\u0000\u0000OP\u0007\u0000\u0000\u0000P\u0015\u0001\u0000\u0000\u0000"+
		"\u0004\u0019(-H";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}