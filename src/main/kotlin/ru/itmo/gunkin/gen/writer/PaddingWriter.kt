package ru.itmo.gunkin.gen.writer

import java.io.BufferedWriter
import java.io.Closeable
import java.io.Flushable

class PaddingWriter(
    private val bufferedWriter: BufferedWriter
) : Closeable, Flushable {
    private var padding = 0

    fun writeln(s: String = "") {
        val pad = "\t".repeat(padding)
        for (line in s.lineSequence()) {
            bufferedWriter.write(pad)
            bufferedWriter.write(line)
            bufferedWriter.write(System.lineSeparator())
        }
    }

    fun separately(action: PaddingWriter.() -> Unit) {
        action()
        bufferedWriter.write(System.lineSeparator())
    }

    fun withPadding(action: PaddingWriter.() -> Unit) {
        padding++
        action()
        padding--
    }

    override fun close() {
        bufferedWriter.close()
    }

    override fun flush() {
        bufferedWriter.flush()
    }
}