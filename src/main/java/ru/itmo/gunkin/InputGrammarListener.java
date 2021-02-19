// Generated from /home/tony/study/mt/mt-lab4/src/main/resources/InputGrammar.g4 by ANTLR 4.9

package ru.itmo.gunkin;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link InputGrammarParser}.
 */
public interface InputGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(InputGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(InputGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(InputGrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(InputGrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(InputGrammarParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(InputGrammarParser.AttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(InputGrammarParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(InputGrammarParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#rulee}.
	 * @param ctx the parse tree
	 */
	void enterRulee(InputGrammarParser.RuleeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#rulee}.
	 * @param ctx the parse tree
	 */
	void exitRulee(InputGrammarParser.RuleeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#ruleProduction}.
	 * @param ctx the parse tree
	 */
	void enterRuleProduction(InputGrammarParser.RuleProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#ruleProduction}.
	 * @param ctx the parse tree
	 */
	void exitRuleProduction(InputGrammarParser.RuleProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#productionElement}.
	 * @param ctx the parse tree
	 */
	void enterProductionElement(InputGrammarParser.ProductionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#productionElement}.
	 * @param ctx the parse tree
	 */
	void exitProductionElement(InputGrammarParser.ProductionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#inheritedAttr}.
	 * @param ctx the parse tree
	 */
	void enterInheritedAttr(InputGrammarParser.InheritedAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#inheritedAttr}.
	 * @param ctx the parse tree
	 */
	void exitInheritedAttr(InputGrammarParser.InheritedAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#synthesizedAttr}.
	 * @param ctx the parse tree
	 */
	void enterSynthesizedAttr(InputGrammarParser.SynthesizedAttrContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#synthesizedAttr}.
	 * @param ctx the parse tree
	 */
	void exitSynthesizedAttr(InputGrammarParser.SynthesizedAttrContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#roundBracketsCode}.
	 * @param ctx the parse tree
	 */
	void enterRoundBracketsCode(InputGrammarParser.RoundBracketsCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#roundBracketsCode}.
	 * @param ctx the parse tree
	 */
	void exitRoundBracketsCode(InputGrammarParser.RoundBracketsCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void enterToken(InputGrammarParser.TokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#token}.
	 * @param ctx the parse tree
	 */
	void exitToken(InputGrammarParser.TokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#skipToken}.
	 * @param ctx the parse tree
	 */
	void enterSkipToken(InputGrammarParser.SkipTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#skipToken}.
	 * @param ctx the parse tree
	 */
	void exitSkipToken(InputGrammarParser.SkipTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link InputGrammarParser#tokenPattern}.
	 * @param ctx the parse tree
	 */
	void enterTokenPattern(InputGrammarParser.TokenPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link InputGrammarParser#tokenPattern}.
	 * @param ctx the parse tree
	 */
	void exitTokenPattern(InputGrammarParser.TokenPatternContext ctx);
}