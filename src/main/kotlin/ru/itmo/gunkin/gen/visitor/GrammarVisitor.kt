package ru.itmo.gunkin.gen.visitor

import ru.itmo.gunkin.InputGrammarBaseVisitor
import ru.itmo.gunkin.InputGrammarParser

import java.util.regex.Pattern

import ru.itmo.gunkin.data.ProductionElem
import ru.itmo.gunkin.data.RuleProduction
import ru.itmo.gunkin.gen.exception.ensure


class GrammarVisitor : InputGrammarBaseVisitor<Unit>() {
    private val _tokens = mutableMapOf<String, String>()
    private val _skipTokens = mutableSetOf<String>()
    private val _rules = mutableMapOf<String, MutableList<RuleProduction>>()

    val tokens: Map<String, String>
        get() = _tokens
    val skipTokens: Set<String>
        get() = _skipTokens
    val rules: Map<String, List<RuleProduction>>
        get() = _rules
    lateinit var startRule: String
    var headerCode: String? = null
    var attributesCode: String? = null

    override fun visitDeclarations(ctx: InputGrammarParser.DeclarationsContext) {
        val firstParseRule = ctx.rulee(0)
        ensure(firstParseRule != null) { "No parser rules defined" }
        startRule = firstParseRule.RULE_NAME().text

        super.visitDeclarations(ctx)

        _tokens.putIfAbsent("EOF", "\\z")
    }

    override fun visitRulee(ctx: InputGrammarParser.RuleeContext) {
        val ruleName = ctx.RULE_NAME().text
        val ruleProductions = _rules.computeIfAbsent(ruleName) { mutableListOf() }
        for (prodCtx in ctx.ruleProduction()) {
            ruleProductions += getProduction(prodCtx)
        }
    }

    private fun getProduction(
        ctx: InputGrammarParser.RuleProductionContext
    ): RuleProduction {
        val productionElements = ctx.productionElement().map { prodElemCtx ->
            if (prodElemCtx.TOKEN_NAME() != null) {
                ProductionElem.Token(prodElemCtx.TOKEN_NAME().text)
            } else {
                ProductionElem.Rule(
                    prodElemCtx.RULE_NAME().text,
                    prodElemCtx.inheritedAttr()?.text?.trimEdges()
                )
            }
        }
        return RuleProduction(
            productionElements,
            ctx.synthesizedAttr()?.text?.trimEdges()
        )
    }

    override fun visitToken(ctx: InputGrammarParser.TokenContext) {
        addToken(ctx.TOKEN_NAME().text, ctx.tokenPattern()!!)
    }

    override fun visitSkipToken(ctx: InputGrammarParser.SkipTokenContext) {
        val name = ctx.TOKEN_NAME().text

        _skipTokens.add(name)
    }


    private fun addToken(
        name: String,
        tokenPatternCtx: InputGrammarParser.TokenPatternContext
    ) {
        ensure(name !in _tokens) { "Duplicate definition of token: $name" }

        val regex = tokenPatternCtx.TOKEN_REGEX()
        val string = tokenPatternCtx.TOKEN_STRING()

        val pattern =
            if (regex == null) {
                val stringText = string.text.trimEdges()
                Pattern.quote(stringText)
            } else {
                regex.text.trimEdges()
            }

        _tokens[name] = pattern
    }

    override fun visitHeader(ctx: InputGrammarParser.HeaderContext) {
        headerCode = ctx.CURLY_BRACKET_CODE().text.trimEdges()
    }

    override fun visitAttributes(ctx: InputGrammarParser.AttributesContext) {
        attributesCode = ctx.CURLY_BRACKET_CODE().text.trimEdges()
    }

    private fun String.trimEdges() = substring(1, length - 1)
}
