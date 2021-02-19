package ru.itmo.gunkin.runtime

import java.util.regex.Pattern

class LexerException(msg: String) : Exception(msg)

open class BaseLexer<T>(
    input: CharSequence,
    tokenPatterns: Map<T, String>,
    private val skipTokens: Set<T>
) {
    private val compiledPatterns =
        tokenPatterns.mapValues { Pattern.compile(it.value) }
    private val matcher =
        Pattern.compile("").matcher(input)
    private var searchPos = 0

    fun nextToken(): Token<T> {
        while (true) {
            val next = tryFindNextToken()
                ?: throw LexerException("Can't parse token at position $searchPos")
            if (next.type !in skipTokens) {
                return next
            }
        }
    }

    private fun tryFindNextToken(): Token<T>? {
        for ((type, pattern) in compiledPatterns) {
            matcher.usePattern(pattern)
            if (matcher.find()) {
                searchPos += matcher.group().length
                return Token(type, matcher.group(), matcher.start())
            }
        }
        return null
    }
}