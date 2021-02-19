// Generated from /home/tony/study/mt/mt-lab4/src/main/resources/InputGrammar.g4 by ANTLR 4.9

package ru.itmo.gunkin;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link InputGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface InputGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(InputGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(InputGrammarParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(InputGrammarParser.AttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(InputGrammarParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#rulee}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRulee(InputGrammarParser.RuleeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#ruleProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleProduction(InputGrammarParser.RuleProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#productionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProductionElement(InputGrammarParser.ProductionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#inheritedAttr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritedAttr(InputGrammarParser.InheritedAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#synthesizedAttr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSynthesizedAttr(InputGrammarParser.SynthesizedAttrContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#roundBracketsCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoundBracketsCode(InputGrammarParser.RoundBracketsCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToken(InputGrammarParser.TokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#skipToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipToken(InputGrammarParser.SkipTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link InputGrammarParser#tokenPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTokenPattern(InputGrammarParser.TokenPatternContext ctx);
}