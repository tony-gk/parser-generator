// Generated from /home/tony/study/mt/mt-lab4/src/main/resources/InputGrammar.g4 by ANTLR 4.9

package ru.itmo.gunkin;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class InputGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COLON=4, SEMICOLON=5, ARROW=6, OR=7, OPEN_CURLY=8, 
		CLOSE_CURLY=9, RULE_NAME=10, TOKEN_NAME=11, TOKEN_REGEX=12, TOKEN_STRING=13, 
		CURLY_BRACKET_CODE=14, ROUND_BRACKET_CODE=15, WS=16;
	public static final int
		RULE_start = 0, RULE_header = 1, RULE_attributes = 2, RULE_declarations = 3, 
		RULE_rulee = 4, RULE_ruleProduction = 5, RULE_productionElement = 6, RULE_inheritedAttr = 7, 
		RULE_synthesizedAttr = 8, RULE_roundBracketsCode = 9, RULE_token = 10, 
		RULE_skipToken = 11, RULE_tokenPattern = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "header", "attributes", "declarations", "rulee", "ruleProduction", 
			"productionElement", "inheritedAttr", "synthesizedAttr", "roundBracketsCode", 
			"token", "skipToken", "tokenPattern"
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

	@Override
	public String getGrammarFileName() { return "InputGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public InputGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(InputGrammarParser.EOF, 0); }
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(26);
				header();
				}
			}

			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(29);
				attributes();
				}
			}

			setState(32);
			declarations();
			setState(33);
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode CURLY_BRACKET_CODE() { return getToken(InputGrammarParser.CURLY_BRACKET_CODE, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__0);
			setState(36);
			match(CURLY_BRACKET_CODE);
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

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode CURLY_BRACKET_CODE() { return getToken(InputGrammarParser.CURLY_BRACKET_CODE, 0); }
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__1);
			setState(39);
			match(CURLY_BRACKET_CODE);
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

	public static class DeclarationsContext extends ParserRuleContext {
		public List<RuleeContext> rulee() {
			return getRuleContexts(RuleeContext.class);
		}
		public RuleeContext rulee(int i) {
			return getRuleContext(RuleeContext.class,i);
		}
		public List<TokenContext> token() {
			return getRuleContexts(TokenContext.class);
		}
		public TokenContext token(int i) {
			return getRuleContext(TokenContext.class,i);
		}
		public List<SkipTokenContext> skipToken() {
			return getRuleContexts(SkipTokenContext.class);
		}
		public SkipTokenContext skipToken(int i) {
			return getRuleContext(SkipTokenContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << RULE_NAME) | (1L << TOKEN_NAME))) != 0)) {
				{
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case RULE_NAME:
					{
					setState(41);
					rulee();
					}
					break;
				case TOKEN_NAME:
					{
					setState(42);
					token();
					}
					break;
				case T__2:
					{
					setState(43);
					skipToken();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(48);
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

	public static class RuleeContext extends ParserRuleContext {
		public TerminalNode RULE_NAME() { return getToken(InputGrammarParser.RULE_NAME, 0); }
		public TerminalNode COLON() { return getToken(InputGrammarParser.COLON, 0); }
		public List<RuleProductionContext> ruleProduction() {
			return getRuleContexts(RuleProductionContext.class);
		}
		public RuleProductionContext ruleProduction(int i) {
			return getRuleContext(RuleProductionContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParser.SEMICOLON, 0); }
		public List<TerminalNode> OR() { return getTokens(InputGrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(InputGrammarParser.OR, i);
		}
		public RuleeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rulee; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterRulee(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitRulee(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitRulee(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleeContext rulee() throws RecognitionException {
		RuleeContext _localctx = new RuleeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rulee);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(RULE_NAME);
			setState(50);
			match(COLON);
			setState(51);
			ruleProduction();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(52);
				match(OR);
				setState(53);
				ruleProduction();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(SEMICOLON);
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

	public static class RuleProductionContext extends ParserRuleContext {
		public List<ProductionElementContext> productionElement() {
			return getRuleContexts(ProductionElementContext.class);
		}
		public ProductionElementContext productionElement(int i) {
			return getRuleContext(ProductionElementContext.class,i);
		}
		public SynthesizedAttrContext synthesizedAttr() {
			return getRuleContext(SynthesizedAttrContext.class,0);
		}
		public RuleProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleProduction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterRuleProduction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitRuleProduction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitRuleProduction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleProductionContext ruleProduction() throws RecognitionException {
		RuleProductionContext _localctx = new RuleProductionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ruleProduction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RULE_NAME || _la==TOKEN_NAME) {
				{
				{
				setState(61);
				productionElement();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CURLY_BRACKET_CODE) {
				{
				setState(67);
				synthesizedAttr();
				}
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

	public static class ProductionElementContext extends ParserRuleContext {
		public TerminalNode RULE_NAME() { return getToken(InputGrammarParser.RULE_NAME, 0); }
		public InheritedAttrContext inheritedAttr() {
			return getRuleContext(InheritedAttrContext.class,0);
		}
		public TerminalNode TOKEN_NAME() { return getToken(InputGrammarParser.TOKEN_NAME, 0); }
		public ProductionElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_productionElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterProductionElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitProductionElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitProductionElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductionElementContext productionElement() throws RecognitionException {
		ProductionElementContext _localctx = new ProductionElementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_productionElement);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RULE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(RULE_NAME);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROUND_BRACKET_CODE) {
					{
					setState(71);
					inheritedAttr();
					}
				}

				}
				break;
			case TOKEN_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(TOKEN_NAME);
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

	public static class InheritedAttrContext extends ParserRuleContext {
		public TerminalNode ROUND_BRACKET_CODE() { return getToken(InputGrammarParser.ROUND_BRACKET_CODE, 0); }
		public InheritedAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritedAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterInheritedAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitInheritedAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitInheritedAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritedAttrContext inheritedAttr() throws RecognitionException {
		InheritedAttrContext _localctx = new InheritedAttrContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inheritedAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ROUND_BRACKET_CODE);
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

	public static class SynthesizedAttrContext extends ParserRuleContext {
		public TerminalNode CURLY_BRACKET_CODE() { return getToken(InputGrammarParser.CURLY_BRACKET_CODE, 0); }
		public SynthesizedAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synthesizedAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterSynthesizedAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitSynthesizedAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitSynthesizedAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynthesizedAttrContext synthesizedAttr() throws RecognitionException {
		SynthesizedAttrContext _localctx = new SynthesizedAttrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_synthesizedAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(CURLY_BRACKET_CODE);
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

	public static class RoundBracketsCodeContext extends ParserRuleContext {
		public List<TerminalNode> OPEN_CURLY() { return getTokens(InputGrammarParser.OPEN_CURLY); }
		public TerminalNode OPEN_CURLY(int i) {
			return getToken(InputGrammarParser.OPEN_CURLY, i);
		}
		public TerminalNode CLOSE_CURLY() { return getToken(InputGrammarParser.CLOSE_CURLY, 0); }
		public List<RoundBracketsCodeContext> roundBracketsCode() {
			return getRuleContexts(RoundBracketsCodeContext.class);
		}
		public RoundBracketsCodeContext roundBracketsCode(int i) {
			return getRuleContext(RoundBracketsCodeContext.class,i);
		}
		public RoundBracketsCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roundBracketsCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterRoundBracketsCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitRoundBracketsCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitRoundBracketsCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoundBracketsCodeContext roundBracketsCode() throws RecognitionException {
		RoundBracketsCodeContext _localctx = new RoundBracketsCodeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_roundBracketsCode);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(OPEN_CURLY);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(84);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
					case T__1:
					case T__2:
					case COLON:
					case SEMICOLON:
					case ARROW:
					case OR:
					case CLOSE_CURLY:
					case RULE_NAME:
					case TOKEN_NAME:
					case TOKEN_REGEX:
					case TOKEN_STRING:
					case CURLY_BRACKET_CODE:
					case ROUND_BRACKET_CODE:
					case WS:
						{
						setState(82);
						_la = _input.LA(1);
						if ( _la <= 0 || (_la==OPEN_CURLY) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case OPEN_CURLY:
						{
						setState(83);
						roundBracketsCode();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(89);
			match(CLOSE_CURLY);
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

	public static class TokenContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(InputGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode COLON() { return getToken(InputGrammarParser.COLON, 0); }
		public TokenPatternContext tokenPattern() {
			return getRuleContext(TokenPatternContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParser.SEMICOLON, 0); }
		public TokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenContext token() throws RecognitionException {
		TokenContext _localctx = new TokenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_token);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(TOKEN_NAME);
			setState(92);
			match(COLON);
			setState(93);
			tokenPattern();
			setState(94);
			match(SEMICOLON);
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

	public static class SkipTokenContext extends ParserRuleContext {
		public TerminalNode TOKEN_NAME() { return getToken(InputGrammarParser.TOKEN_NAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(InputGrammarParser.SEMICOLON, 0); }
		public SkipTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skipToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterSkipToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitSkipToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitSkipToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkipTokenContext skipToken() throws RecognitionException {
		SkipTokenContext _localctx = new SkipTokenContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_skipToken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__2);
			setState(97);
			match(TOKEN_NAME);
			setState(98);
			match(SEMICOLON);
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

	public static class TokenPatternContext extends ParserRuleContext {
		public TerminalNode TOKEN_REGEX() { return getToken(InputGrammarParser.TOKEN_REGEX, 0); }
		public TerminalNode TOKEN_STRING() { return getToken(InputGrammarParser.TOKEN_STRING, 0); }
		public TokenPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tokenPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).enterTokenPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof InputGrammarListener ) ((InputGrammarListener)listener).exitTokenPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof InputGrammarVisitor ) return ((InputGrammarVisitor<? extends T>)visitor).visitTokenPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TokenPatternContext tokenPattern() throws RecognitionException {
		TokenPatternContext _localctx = new TokenPatternContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tokenPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==TOKEN_REGEX || _la==TOKEN_STRING) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22i\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\5\2!\n\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\6\3\6\3\6\3"+
		"\6\3\6\7\69\n\6\f\6\16\6<\13\6\3\6\3\6\3\7\7\7A\n\7\f\7\16\7D\13\7\3\7"+
		"\5\7G\n\7\3\b\3\b\5\bK\n\b\3\b\5\bN\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\7\13W\n\13\f\13\16\13Z\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\4\3\2"+
		"\n\n\3\2\16\17\2g\2\35\3\2\2\2\4%\3\2\2\2\6(\3\2\2\2\b\60\3\2\2\2\n\63"+
		"\3\2\2\2\fB\3\2\2\2\16M\3\2\2\2\20O\3\2\2\2\22Q\3\2\2\2\24S\3\2\2\2\26"+
		"]\3\2\2\2\30b\3\2\2\2\32f\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\35\36\3"+
		"\2\2\2\36 \3\2\2\2\37!\5\6\4\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\5\b"+
		"\5\2#$\7\2\2\3$\3\3\2\2\2%&\7\3\2\2&\'\7\20\2\2\'\5\3\2\2\2()\7\4\2\2"+
		")*\7\20\2\2*\7\3\2\2\2+/\5\n\6\2,/\5\26\f\2-/\5\30\r\2.+\3\2\2\2.,\3\2"+
		"\2\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\t\3\2\2\2\62\60"+
		"\3\2\2\2\63\64\7\f\2\2\64\65\7\6\2\2\65:\5\f\7\2\66\67\7\t\2\2\679\5\f"+
		"\7\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7"+
		"\7\2\2>\13\3\2\2\2?A\5\16\b\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2"+
		"CF\3\2\2\2DB\3\2\2\2EG\5\22\n\2FE\3\2\2\2FG\3\2\2\2G\r\3\2\2\2HJ\7\f\2"+
		"\2IK\5\20\t\2JI\3\2\2\2JK\3\2\2\2KN\3\2\2\2LN\7\r\2\2MH\3\2\2\2ML\3\2"+
		"\2\2N\17\3\2\2\2OP\7\21\2\2P\21\3\2\2\2QR\7\20\2\2R\23\3\2\2\2SX\7\n\2"+
		"\2TW\n\2\2\2UW\5\24\13\2VT\3\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2"+
		"\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\13\2\2\\\25\3\2\2\2]^\7\r\2\2^_\7\6\2\2"+
		"_`\5\32\16\2`a\7\7\2\2a\27\3\2\2\2bc\7\5\2\2cd\7\r\2\2de\7\7\2\2e\31\3"+
		"\2\2\2fg\t\3\2\2g\33\3\2\2\2\r\35 .\60:BFJMVX";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}