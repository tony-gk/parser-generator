package examples.forloop

import ru.itmo.gunkin.runtime.BaseLexer

enum class TokenType {
	OPEN_PARENTHESES,
	CLOSE_PARENTHESES,
	LE,
	LT,
	GE,
	GT,
	EQ,
	NE,
	INCREMENT,
	DECREMENT,
	ASSIGN,
	FOR,
	SEMICOLON,
	IDENTIFIER,
	NUMBER,
	WS,
	EOF,
}

private val tokenPatterns = mapOf(
	TokenType.OPEN_PARENTHESES to """\G\Q(\E""", 
	TokenType.CLOSE_PARENTHESES to """\G\Q)\E""", 
	TokenType.LE to """\G\Q<=\E""", 
	TokenType.LT to """\G\Q<\E""", 
	TokenType.GE to """\G\Q>=\E""", 
	TokenType.GT to """\G\Q>\E""", 
	TokenType.EQ to """\G\Q==\E""", 
	TokenType.NE to """\G\Q!=\E""", 
	TokenType.INCREMENT to """\G\Q++\E""", 
	TokenType.DECREMENT to """\G\Q--\E""", 
	TokenType.ASSIGN to """\G\Q=\E""", 
	TokenType.FOR to """\G\Qfor\E""", 
	TokenType.SEMICOLON to """\G\Q;\E""", 
	TokenType.IDENTIFIER to """\G[a-zA-Z][a-zA-Z0-9]*""", 
	TokenType.NUMBER to """\G[+-]?[0-9]+""", 
	TokenType.WS to """\G[ \t\r\n]+""", 
	TokenType.EOF to """\G\z""", 
)

private val skipTokens = setOf(
	TokenType.WS,
)

class ForLoopLexer(input : CharSequence) : BaseLexer<TokenType>(input, tokenPatterns, skipTokens)

