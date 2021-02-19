package ru.itmo.gunkin.runtime

class ParserException(msg: String) : Exception(msg)

abstract class BaseParser<T>(
    private val lexer: BaseLexer<T>,
) {
    protected var curToken: Token<T>

    init {
        curToken = lexer.nextToken()
    }

    abstract fun start(): ParseTree

    protected fun nextToken() {
        curToken = lexer.nextToken()
    }

    protected fun unexpectedToken(): Nothing {
        fail("Unexpected token ${curToken.type} at position ${curToken.pos}")
    }

    protected fun fail(msg: String): Nothing = throw ParserException(msg)
}