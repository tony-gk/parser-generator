package examples.forloop

import ru.itmo.gunkin.runtime.BaseParser
import ru.itmo.gunkin.runtime.BaseLexer

class ForLoopParser(lexer: BaseLexer<TokenType>) : BaseParser<TokenType>(lexer) {
	override fun start(): Tree {
	    val res = parse_start{}
	    if (curToken.type != TokenType.EOF)
	        fail("Expected EOF at position" + curToken.pos)
	    return res
	}

	private fun expectToken(vararg types: TokenType) : Tree {
	    val tok = curToken
	    if (types.any { it == tok.type }) {
	        val res = Tree.TerminalNode(tok.type.toString(), tok.text)
	        nextToken()
	        return res
	    }
	    unexpectedToken()
	}

	private fun parse_start(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("start", children)
		res.init()
		when (curToken.type) {
			TokenType.FOR -> {
				children += expectToken(TokenType.FOR)
				children += expectToken(TokenType.OPEN_PARENTHESES)
				children += parse_init{}
				children += expectToken(TokenType.SEMICOLON)
				children += parse_condition{}
				children += expectToken(TokenType.SEMICOLON)
				children += parse_update{}
				children += expectToken(TokenType.CLOSE_PARENTHESES)
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_init(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("init", children)
		res.init()
		when (curToken.type) {
			TokenType.IDENTIFIER -> {
				children += expectToken(TokenType.IDENTIFIER)
				children += expectToken(TokenType.IDENTIFIER)
				children += expectToken(TokenType.ASSIGN)
				children += expectToken(TokenType.NUMBER)
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_condition(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("condition", children)
		res.init()
		when (curToken.type) {
			TokenType.IDENTIFIER -> {
				children += expectToken(TokenType.IDENTIFIER)
				children += parse_compareOp{}
				children += expectToken(TokenType.NUMBER)
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_compareOp(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("compareOp", children)
		res.init()
		when (curToken.type) {
			TokenType.LE -> {
				children += expectToken(TokenType.LE)
			}
			TokenType.LT -> {
				children += expectToken(TokenType.LT)
			}
			TokenType.GE -> {
				children += expectToken(TokenType.GE)
			}
			TokenType.GT -> {
				children += expectToken(TokenType.GT)
			}
			TokenType.EQ -> {
				children += expectToken(TokenType.EQ)
			}
			TokenType.NE -> {
				children += expectToken(TokenType.NE)
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_update(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("update", children)
		res.init()
		when (curToken.type) {
			TokenType.IDENTIFIER -> {
				children += expectToken(TokenType.IDENTIFIER)
				children += parse_updateOp{}
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_updateOp(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("updateOp", children)
		res.init()
		when (curToken.type) {
			TokenType.INCREMENT -> {
				children += expectToken(TokenType.INCREMENT)
			}
			TokenType.DECREMENT -> {
				children += expectToken(TokenType.DECREMENT)
			}
			else -> unexpectedToken()
		}
		return res
	}

}

