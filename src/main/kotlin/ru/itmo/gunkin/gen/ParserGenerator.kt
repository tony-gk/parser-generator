package ru.itmo.gunkin.gen

import ru.itmo.gunkin.data.ProductionElem
import ru.itmo.gunkin.data.RuleProduction
import ru.itmo.gunkin.gen.exception.ensure
import ru.itmo.gunkin.gen.ll1.Grammar
import ru.itmo.gunkin.gen.ll1.Grammar.Companion.END
import ru.itmo.gunkin.gen.ll1.Grammar.Companion.EPS
import ru.itmo.gunkin.gen.visitor.GrammarVisitor
import ru.itmo.gunkin.gen.writer.PaddingWriter

import java.io.File
import java.nio.file.Path

class ParserGenerator(
    private val className: String,
    private val dir: Path,
    visitor: GrammarVisitor
) {
    private val rules = visitor.rules
    private val startRule = visitor.startRule
    private val header = visitor.headerCode
    private val grammar = Grammar(rules, visitor.tokens.keys, startRule)

    private lateinit var writer: PaddingWriter

    fun generate() {
        ensure(grammar.checkLL1()) { "Grammar is not LL1" }

        val file: File = dir.resolve("$className.kt").toFile()
        writer = PaddingWriter(file.bufferedWriter())
        writer.use {
            separately { writeHeader() }
            separately { writeImports() }
            separately { writeParser() }
        }
    }

    private fun writeHeader() {
        if (header != null) {
            writeln(header)
        }
    }

    private fun writeImports() {
        writeln("import ru.itmo.gunkin.runtime.BaseParser")
        writeln("import ru.itmo.gunkin.runtime.BaseLexer")
    }

    private fun writeParser() {
        writeln("class $className(lexer: BaseLexer<TokenType>) : BaseParser<TokenType>(lexer) {")
        withPadding {
            separately { writeStartFunction() }
            separately { writeExpectTokenFunction() }
            writeParseFunctions()
        }
        writeln("}")
    }

    private fun writeStartFunction() {
        writeln(
            """
           |override fun start(): Tree {
           |    val res = ${functionName(startRule)}{}
           |    if (curToken.type != TokenType.EOF)
           |        fail("Expected EOF at position" + curToken.pos)
           |    return res
           |}
        """.trimMargin()
        )
    }

    private fun writeExpectTokenFunction() {
        writeln(
            """
           |private fun expectToken(vararg types: TokenType) : Tree {
           |    val tok = curToken
           |    if (types.any { it == tok.type }) {
           |        val res = Tree.TerminalNode(tok.type.toString(), tok.text)
           |        nextToken()
           |        return res
           |    }
           |    unexpectedToken()
           |}
        """.trimMargin()
        )
    }

    private fun writeParseFunctions() {
        for ((ruleName, productions) in rules) {
            separately { writeParseFunction(ruleName, productions) }
        }
    }

    private fun writeParseFunction(
        ruleName: String,
        productions: List<RuleProduction>
    ) {
        writeln("private fun ${functionName(ruleName)}(init : Tree.() -> Unit) : Tree {")
        withPadding {
            writeln("val children = mutableListOf<Tree>()")
            writeln("val res = Tree.RuleNode(\"$ruleName\", children)")
            writeln("res.init()")
            writeln("when (curToken.type) {")
            withPadding { writeWhenCases(ruleName, productions) }
            writeln("}")
            writeln("return res")
        }
        writeln("}")
    }

    private fun writeWhenCases(ruleName: String, productions: List<RuleProduction>) {
        for (prod in productions) {
            val firstSet = grammar.getFirstOfSeq(prod.elements)
            val tokens = firstSet.toMutableSet()
            if (tokens.contains(EPS)) {
                tokens.remove(EPS)
                tokens.addAll(
                    grammar.getFollow(ruleName)
                        .map { if (it == END) "EOF" else it }
                )
            }
            writeWhenCase(tokens, prod)
        }
        writeln("else -> unexpectedToken()")
    }

    private fun writeWhenCase(tokens: Iterable<String>, prod: RuleProduction) {
        writeln(tokens.joinToString { "TokenType.$it" } + " -> {")
        withPadding { writeWhenCaseBody(prod) }
        writeln("}")
    }

    private fun writeWhenCaseBody(prod: RuleProduction) {
        for (prodElem in prod.elements) {
            val name = prodElem.name
            when (prodElem) {
                is ProductionElem.Token -> {
                    writeln("children += expectToken(TokenType.$name)")
                }
                is ProductionElem.Rule -> {
                    val attr = substituteAttr(prodElem.inheritedAttr ?: "")
                    writeln("children += ${functionName(name)}{$attr}")
                }
            }
        }
        val attr = substituteAttr(prod.synthesizedAttr ?: return)
        writeln("res.apply{$attr}")
    }

    private fun substituteAttr(attrCode: String): String {
        return attrCode.replace("\\\$([0-9]+)".toRegex()) {
            val n = it.groupValues[1]
            "children[$n]"
        }
    }

    private fun functionName(rule: String): String {
        return "parse_$rule"
    }

    private fun writeln(s: String) = writer.writeln(s)

    private fun separately(action: PaddingWriter.() -> Unit) {
        writer.separately { action() }
    }

    private fun withPadding(action: PaddingWriter.() -> Unit) {
        writer.withPadding { action() }
    }

}

