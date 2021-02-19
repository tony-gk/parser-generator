package ru.itmo.gunkin.gen

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import ru.itmo.gunkin.InputGrammarLexer
import ru.itmo.gunkin.InputGrammarParser
import ru.itmo.gunkin.data.ProductionElem
import ru.itmo.gunkin.data.RuleProduction
import ru.itmo.gunkin.gen.exception.ensure
import ru.itmo.gunkin.gen.visitor.GrammarVisitor
import java.nio.file.Path

fun generateParser(grammarName: String, grammarFile: Path, generateDir: Path) {
    val grammarLexer = InputGrammarLexer(CharStreams.fromPath(grammarFile))
    val grammarParser = InputGrammarParser(CommonTokenStream(grammarLexer))

    val grammarVisitor = GrammarVisitor()
    grammarVisitor.visit(grammarParser.start())

    ensureSymbolsAreDefined(grammarVisitor.rules, grammarVisitor.tokens)

    LexerGenerator("${grammarName}Lexer", generateDir, grammarVisitor)
        .generate()

    TreeGenerator(generateDir, grammarVisitor)
        .generate()

    ParserGenerator("${grammarName}Parser", generateDir, grammarVisitor)
        .generate()
}

fun ensureSymbolsAreDefined(
    parserRules: Map<String, List<RuleProduction>>,
    lexerRules: Map<String, String>
) {
    for (prods in parserRules.values) {
        for (production in prods) {
            for (prodElem in production.elements) {
                val name = prodElem.name
                when (prodElem) {
                    is ProductionElem.Rule ->
                        ensure(name in parserRules) {
                            "Lexer rule is not defined: $name"
                        }
                    is ProductionElem.Token ->
                        ensure(name in lexerRules) {
                            "Parser rule is not defined: $name"
                        }
                }
            }
        }
    }
}

fun main() {
    generateParser(
        "Forloop", Path.of("examples.forloop.g"), Path.of("src/examples.main/kotlin")
    )
}
