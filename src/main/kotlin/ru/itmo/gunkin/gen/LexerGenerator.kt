package ru.itmo.gunkin.gen

import ru.itmo.gunkin.gen.visitor.GrammarVisitor
import ru.itmo.gunkin.gen.writer.PaddingWriter
import java.io.File
import java.nio.file.Path

class LexerGenerator(
    private val className: String,
    private val dir: Path,
    visitor: GrammarVisitor
) {
    private val tokens = visitor.tokens
    private val skipTokens = visitor.skipTokens
    private val headerCode = visitor.headerCode

    private lateinit var writer: PaddingWriter

    fun generate() {

        val file: File = dir.resolve("$className.kt").toFile()
        writer = PaddingWriter(file.bufferedWriter())
        writer.use {
            separately { writeHeader() }
            separately { writeImports() }
            separately { writeTokenType() }
            separately { writeTokenPatterns() }
            separately { writeSkipTokens() }
            separately { writeClassDeclaration() }
        }
    }

    private fun writeHeader() {
        if (headerCode != null) {
            writeln(headerCode)
        }
    }

    private fun writeImports() {
        writeln("import ru.itmo.gunkin.runtime.BaseLexer")
    }

    private fun writeTokenType() {
        writeln("enum class TokenType {")
        withPadding {
            for ((tokName, _) in tokens) {
                writeln("$tokName,")
            }
        }
        writeln("}")
    }

    private fun writeTokenPatterns() {
        writeln("private val tokenPatterns = mapOf(")
        withPadding {
            val tripleQuotes = "\"\"\""
            for ((tokName, tokPattern) in tokens) {
                val patternString = tripleQuotes + "\\G${tokPattern}" + tripleQuotes
                writeln("TokenType.$tokName to $patternString, ")
            }
        }
        writeln(")")
    }

    private fun writeSkipTokens() {
        writeln("private val skipTokens = setOf<TokenType>(")
        withPadding {
            for (t in skipTokens) {
                writeln("TokenType.$t,")
            }
        }
        writeln(")")
    }

    private fun writeClassDeclaration() {
        writeln(
            "class $className(input : CharSequence) " +
                    ": BaseLexer<TokenType>(input, tokenPatterns, skipTokens)"
        )
    }

    private fun writeln(s: String) = writer.writeln(s)

    private fun separately(action: PaddingWriter.() -> Unit) {
        writer.separately { action() }
    }

    private fun withPadding(action: PaddingWriter.() -> Unit) {
        writer.withPadding { action() }
    }
}

