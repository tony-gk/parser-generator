package ru.itmo.gunkin.gen

import ru.itmo.gunkin.gen.visitor.GrammarVisitor
import ru.itmo.gunkin.gen.writer.PaddingWriter
import java.io.File
import java.nio.file.Path

class TreeGenerator(
    private val dir: Path,
    visitor: GrammarVisitor
) {
    private val header = visitor.headerCode
    private val attributes = visitor.attributesCode
    private lateinit var writer: PaddingWriter

    fun generate() {
        val file: File = dir.resolve("Tree.kt").toFile()
        writer = PaddingWriter(file.bufferedWriter())
        writer.use {
            it.separately { writeHeader() }
            it.separately { writeImports() }
            it.separately { writeTreeClass() }
        }
    }

    private fun writeHeader() {
        if (header != null) {
            writer.writeln(header)
        }
    }

    private fun writeImports() {
        writer.writeln("import ru.itmo.gunkin.runtime.ParseTree")
    }

    private fun writeTreeClass() = with(writer) {
        val attrs = (attributes ?: "").trimIndent().lines()
        writeln("sealed class Tree : ParseTree {")
        withPadding {
            for (attr in attrs) {
                writeln(attr)
            }
        }
        writeln(
            """
        |   
        |    class RuleNode(val rule: String, val children: List<Tree>) : Tree() {
        |        override val text: String
        |            get() = children.joinToString { it.text }
        |    }
        |     
        |    class TerminalNode(val tokenType: String, override val text: String) : Tree()
        |}
        """.trimMargin()
        )
    }
}