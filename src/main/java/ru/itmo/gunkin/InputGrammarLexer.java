// Generated from /home/tony/study/mt/mt-lab4/src/main/resources/InputGrammar.g4 by ANTLR 4.9

package ru.itmo.gunkin;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COLON=4, SEMICOLON=5, ARROW=6, OR=7, OPEN_CURLY=8, 
		CLOSE_CURLY=9, RULE_NAME=10, TOKEN_NAME=11, TOKEN_REGEX=12, TOKEN_STRING=13, 
		CURLY_BRACKET_CODE=14, ROUND_BRACKET_CODE=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "LOWERCASE", "UPPERCASE", "ALPHA_NUM", "COLON", 
			"SEMICOLON", "ARROW", "OR", "OPEN_CURLY", "CLOSE_CURLY", "RULE_NAME", 
			"TOKEN_NAME", "TOKEN_REGEX", "TOKEN_STRING", "CURLY_BRACKET_CODE", "ROUND_BRACKET_CODE", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@header'", "'@attributes'", "'skip'", "':'", "';'", "'->'", "'|'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COLON", "SEMICOLON", "ARROW", "OR", "OPEN_CURLY", 
			"CLOSE_CURLY", "RULE_NAME", "TOKEN_NAME", "TOKEN_REGEX", "TOKEN_STRING", 
			"CURLY_BRACKET_CODE", "ROUND_BRACKET_CODE", "WS"
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


	public InputGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "InputGrammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\22\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\7\16Y\n\16\f\16\16\16\\\13\16\3\17\3\17\3\17\7\17a\n\17\f\17"+
		"\16\17d\13\17\3\20\3\20\3\20\3\20\7\20j\n\20\f\20\16\20m\13\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\7\21u\n\21\f\21\16\21x\13\21\3\21\3\21\3\22\3"+
		"\22\3\22\7\22\177\n\22\f\22\16\22\u0082\13\22\3\22\3\22\3\23\3\23\3\23"+
		"\7\23\u0089\n\23\f\23\16\23\u008c\13\23\3\23\3\23\3\24\6\24\u0091\n\24"+
		"\r\24\16\24\u0092\3\24\3\24\2\2\25\3\3\5\4\7\5\t\2\13\2\r\2\17\6\21\7"+
		"\23\b\25\t\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22\3\2\n\3\2c|\3\2"+
		"C\\\5\2\62;C\\c|\3\2))\3\2$$\3\2}}\3\2**\5\2\13\f\17\17\"\"\2\u009f\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2"+
		"\5\61\3\2\2\2\7=\3\2\2\2\tB\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17H\3\2\2\2"+
		"\21J\3\2\2\2\23L\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2"+
		"\2\35]\3\2\2\2\37e\3\2\2\2!p\3\2\2\2#{\3\2\2\2%\u0085\3\2\2\2\'\u0090"+
		"\3\2\2\2)*\7B\2\2*+\7j\2\2+,\7g\2\2,-\7c\2\2-.\7f\2\2./\7g\2\2/\60\7t"+
		"\2\2\60\4\3\2\2\2\61\62\7B\2\2\62\63\7c\2\2\63\64\7v\2\2\64\65\7v\2\2"+
		"\65\66\7t\2\2\66\67\7k\2\2\678\7d\2\289\7w\2\29:\7v\2\2:;\7g\2\2;<\7u"+
		"\2\2<\6\3\2\2\2=>\7u\2\2>?\7m\2\2?@\7k\2\2@A\7r\2\2A\b\3\2\2\2BC\t\2\2"+
		"\2C\n\3\2\2\2DE\t\3\2\2E\f\3\2\2\2FG\t\4\2\2G\16\3\2\2\2HI\7<\2\2I\20"+
		"\3\2\2\2JK\7=\2\2K\22\3\2\2\2LM\7/\2\2MN\7@\2\2N\24\3\2\2\2OP\7~\2\2P"+
		"\26\3\2\2\2QR\7}\2\2R\30\3\2\2\2ST\7\177\2\2T\32\3\2\2\2UZ\5\t\5\2VY\5"+
		"\r\7\2WY\7a\2\2XV\3\2\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\34"+
		"\3\2\2\2\\Z\3\2\2\2]b\5\13\6\2^a\5\r\7\2_a\7a\2\2`^\3\2\2\2`_\3\2\2\2"+
		"ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\36\3\2\2\2db\3\2\2\2ek\7)\2\2fj\n\5\2"+
		"\2gh\7^\2\2hj\7)\2\2if\3\2\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"ln\3\2\2\2mk\3\2\2\2no\7)\2\2o \3\2\2\2pv\7$\2\2qu\n\6\2\2rs\7^\2\2su"+
		"\7$\2\2tq\3\2\2\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv"+
		"\3\2\2\2yz\7$\2\2z\"\3\2\2\2{\u0080\7}\2\2|\177\n\7\2\2}\177\5#\22\2~"+
		"|\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\177\2\2\u0084"+
		"$\3\2\2\2\u0085\u008a\7*\2\2\u0086\u0089\n\b\2\2\u0087\u0089\5%\23\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2\2\2\u008d"+
		"\u008e\7+\2\2\u008e&\3\2\2\2\u008f\u0091\t\t\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\b\24\2\2\u0095(\3\2\2\2\20\2XZ`biktv~\u0080\u0088\u008a"+
		"\u0092\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}