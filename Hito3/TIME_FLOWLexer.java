// Generated from TIME_FLOW.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TIME_FLOWLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TASK=1, EXECUTE=2, EVERY=3, IF=4, DO=5, HAS_FINISHED=6, AFTER=7, MINUTES=8, 
		SECONDS=9, HOURS=10, DAYS=11, SEMI=12, LPAREN=13, RPAREN=14, LBRACE=15, 
		RBRACE=16, ID=17, INT_LITERAL=18, WS=19, COMMENT=20, LINE_COMMENT=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TASK", "EXECUTE", "EVERY", "IF", "DO", "HAS_FINISHED", "AFTER", "MINUTES", 
			"SECONDS", "HOURS", "DAYS", "SEMI", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"ID", "INT_LITERAL", "WS", "COMMENT", "LINE_COMMENT"
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


	public TIME_FLOWLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TIME_FLOW.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0015\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u007f\b\u0010\n"+
		"\u0010\f\u0010\u0082\t\u0010\u0001\u0011\u0004\u0011\u0085\b\u0011\u000b"+
		"\u0011\f\u0011\u0086\u0001\u0012\u0004\u0012\u008a\b\u0012\u000b\u0012"+
		"\f\u0012\u008b\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0094\b\u0013\n\u0013\f\u0013\u0097\t\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u00a1\b\u0014\n\u0014\f\u0014\u00a4\t\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0002\u0095"+
		"\u00a2\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"\u0001\u0000\u0004\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u000009\u0003"+
		"\u0000\t\n\r\r  \u00ae\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u00030\u0001"+
		"\u0000\u0000\u0000\u00058\u0001\u0000\u0000\u0000\u0007>\u0001\u0000\u0000"+
		"\u0000\tA\u0001\u0000\u0000\u0000\u000bD\u0001\u0000\u0000\u0000\rQ\u0001"+
		"\u0000\u0000\u0000\u000fW\u0001\u0000\u0000\u0000\u0011_\u0001\u0000\u0000"+
		"\u0000\u0013g\u0001\u0000\u0000\u0000\u0015m\u0001\u0000\u0000\u0000\u0017"+
		"r\u0001\u0000\u0000\u0000\u0019t\u0001\u0000\u0000\u0000\u001bv\u0001"+
		"\u0000\u0000\u0000\u001dx\u0001\u0000\u0000\u0000\u001fz\u0001\u0000\u0000"+
		"\u0000!|\u0001\u0000\u0000\u0000#\u0084\u0001\u0000\u0000\u0000%\u0089"+
		"\u0001\u0000\u0000\u0000\'\u008f\u0001\u0000\u0000\u0000)\u009c\u0001"+
		"\u0000\u0000\u0000+,\u0005T\u0000\u0000,-\u0005A\u0000\u0000-.\u0005S"+
		"\u0000\u0000./\u0005K\u0000\u0000/\u0002\u0001\u0000\u0000\u000001\u0005"+
		"E\u0000\u000012\u0005X\u0000\u000023\u0005E\u0000\u000034\u0005C\u0000"+
		"\u000045\u0005U\u0000\u000056\u0005T\u0000\u000067\u0005E\u0000\u0000"+
		"7\u0004\u0001\u0000\u0000\u000089\u0005E\u0000\u00009:\u0005V\u0000\u0000"+
		":;\u0005E\u0000\u0000;<\u0005R\u0000\u0000<=\u0005Y\u0000\u0000=\u0006"+
		"\u0001\u0000\u0000\u0000>?\u0005I\u0000\u0000?@\u0005F\u0000\u0000@\b"+
		"\u0001\u0000\u0000\u0000AB\u0005D\u0000\u0000BC\u0005O\u0000\u0000C\n"+
		"\u0001\u0000\u0000\u0000DE\u0005H\u0000\u0000EF\u0005A\u0000\u0000FG\u0005"+
		"S\u0000\u0000GH\u0005_\u0000\u0000HI\u0005F\u0000\u0000IJ\u0005I\u0000"+
		"\u0000JK\u0005N\u0000\u0000KL\u0005I\u0000\u0000LM\u0005S\u0000\u0000"+
		"MN\u0005H\u0000\u0000NO\u0005E\u0000\u0000OP\u0005D\u0000\u0000P\f\u0001"+
		"\u0000\u0000\u0000QR\u0005A\u0000\u0000RS\u0005F\u0000\u0000ST\u0005T"+
		"\u0000\u0000TU\u0005E\u0000\u0000UV\u0005R\u0000\u0000V\u000e\u0001\u0000"+
		"\u0000\u0000WX\u0005M\u0000\u0000XY\u0005I\u0000\u0000YZ\u0005N\u0000"+
		"\u0000Z[\u0005U\u0000\u0000[\\\u0005T\u0000\u0000\\]\u0005E\u0000\u0000"+
		"]^\u0005S\u0000\u0000^\u0010\u0001\u0000\u0000\u0000_`\u0005S\u0000\u0000"+
		"`a\u0005E\u0000\u0000ab\u0005C\u0000\u0000bc\u0005O\u0000\u0000cd\u0005"+
		"N\u0000\u0000de\u0005D\u0000\u0000ef\u0005S\u0000\u0000f\u0012\u0001\u0000"+
		"\u0000\u0000gh\u0005H\u0000\u0000hi\u0005O\u0000\u0000ij\u0005U\u0000"+
		"\u0000jk\u0005R\u0000\u0000kl\u0005S\u0000\u0000l\u0014\u0001\u0000\u0000"+
		"\u0000mn\u0005D\u0000\u0000no\u0005A\u0000\u0000op\u0005Y\u0000\u0000"+
		"pq\u0005S\u0000\u0000q\u0016\u0001\u0000\u0000\u0000rs\u0005;\u0000\u0000"+
		"s\u0018\u0001\u0000\u0000\u0000tu\u0005(\u0000\u0000u\u001a\u0001\u0000"+
		"\u0000\u0000vw\u0005)\u0000\u0000w\u001c\u0001\u0000\u0000\u0000xy\u0005"+
		"{\u0000\u0000y\u001e\u0001\u0000\u0000\u0000z{\u0005}\u0000\u0000{ \u0001"+
		"\u0000\u0000\u0000|\u0080\u0007\u0000\u0000\u0000}\u007f\u0007\u0001\u0000"+
		"\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\""+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0085"+
		"\u0007\u0002\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087$\u0001\u0000\u0000\u0000\u0088\u008a\u0007"+
		"\u0003\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0006"+
		"\u0012\u0000\u0000\u008e&\u0001\u0000\u0000\u0000\u008f\u0090\u0005/\u0000"+
		"\u0000\u0090\u0091\u0005/\u0000\u0000\u0091\u0095\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\t\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u0097\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0095"+
		"\u0093\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097"+
		"\u0095\u0001\u0000\u0000\u0000\u0098\u0099\u0005\n\u0000\u0000\u0099\u009a"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0006\u0013\u0000\u0000\u009b(\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0005/\u0000\u0000\u009d\u009e\u0005*\u0000"+
		"\u0000\u009e\u00a2\u0001\u0000\u0000\u0000\u009f\u00a1\t\u0000\u0000\u0000"+
		"\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0005*\u0000\u0000\u00a6\u00a7\u0005/\u0000\u0000\u00a7\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0006\u0014\u0000\u0000\u00a9*\u0001"+
		"\u0000\u0000\u0000\u0006\u0000\u0080\u0086\u008b\u0095\u00a2\u0001\u0006"+
		"\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}