package examples.calculator

import ru.itmo.gunkin.runtime.BaseLexer

enum class TokenType {
	PLUS,
	MINUS,
	MUL,
	DIV,
	SHL,
	SHR,
	LPAREN,
	RPAREN,
	NUMBER,
	WS,
	EOF,
}

private val tokenPatterns = mapOf(
	TokenType.PLUS to """\G\Q+\E""", 
	TokenType.MINUS to """\G\Q-\E""", 
	TokenType.MUL to """\G\Q*\E""", 
	TokenType.DIV to """\G\Q/\E""", 
	TokenType.SHL to """\G\Q<<\E""", 
	TokenType.SHR to """\G\Q>>\E""", 
	TokenType.LPAREN to """\G\Q(\E""", 
	TokenType.RPAREN to """\G\Q)\E""", 
	TokenType.NUMBER to """\G[0-9]+""", 
	TokenType.WS to """\G[ \t\r\n]+""", 
	TokenType.EOF to """\G\z""", 
)

private val skipTokens = setOf(
	TokenType.WS,
)

class CalcLexer(input : CharSequence) : BaseLexer<TokenType>(input, tokenPatterns, skipTokens)

