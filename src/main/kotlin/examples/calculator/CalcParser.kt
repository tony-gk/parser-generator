package examples.calculator

import ru.itmo.gunkin.runtime.BaseParser
import ru.itmo.gunkin.runtime.BaseLexer

class CalcParser(lexer: BaseLexer<TokenType>) : BaseParser<TokenType>(lexer) {
	override fun start(): Tree {
	    val res = parse_expr{}
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

	private fun parse_expr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("expr", children)
		res.init()
		when (curToken.type) {
			TokenType.MINUS, TokenType.NUMBER, TokenType.LPAREN -> {
				children += parse_bitwiseExpr{}
				res.apply{ value = children[0].value }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_bitwiseExpr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("bitwiseExpr", children)
		res.init()
		when (curToken.type) {
			TokenType.MINUS, TokenType.NUMBER, TokenType.LPAREN -> {
				children += parse_additiveExpr{}
				children += parse_bitwiseExprs{value = children[0].value}
				res.apply{ value = children[1].value }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_bitwiseExprs(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("bitwiseExprs", children)
		res.init()
		when (curToken.type) {
			TokenType.SHL -> {
				children += expectToken(TokenType.SHL)
				children += parse_bitwiseExpr{}
				res.apply{ value = res.value shl children[1].value }
			}
			TokenType.SHR -> {
				children += expectToken(TokenType.SHR)
				children += parse_bitwiseExpr{}
				res.apply{ value = res.value shr children[1].value }
			}
			TokenType.EOF, TokenType.RPAREN -> {
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_additiveExpr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("additiveExpr", children)
		res.init()
		when (curToken.type) {
			TokenType.MINUS, TokenType.NUMBER, TokenType.LPAREN -> {
				children += parse_mulExpr{}
				children += parse_additiveExprs{acc = children[0].value}
				res.apply{ value = children[1].value }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_additiveExprs(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("additiveExprs", children)
		res.init()
		when (curToken.type) {
			TokenType.PLUS -> {
				children += expectToken(TokenType.PLUS)
				children += parse_mulExpr{}
				children += parse_additiveExprs{acc = res.acc + children[1].value}
				res.apply{ value = children[2].value }
			}
			TokenType.MINUS -> {
				children += expectToken(TokenType.MINUS)
				children += parse_mulExpr{}
				children += parse_additiveExprs{acc = res.acc - children[1].value}
				res.apply{ value = children[2].value }
			}
			TokenType.SHL, TokenType.SHR, TokenType.EOF, TokenType.RPAREN -> {
				res.apply{ value = res.acc }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_mulExpr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("mulExpr", children)
		res.init()
		when (curToken.type) {
			TokenType.MINUS, TokenType.NUMBER, TokenType.LPAREN -> {
				children += parse_unaryExpr{}
				children += parse_mulExprs{acc = children[0].value}
				res.apply{ value = children[1].value}
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_mulExprs(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("mulExprs", children)
		res.init()
		when (curToken.type) {
			TokenType.MUL -> {
				children += expectToken(TokenType.MUL)
				children += parse_unaryExpr{}
				children += parse_mulExprs{acc = res.acc * children[1].value}
				res.apply{ value = children[2].value }
			}
			TokenType.DIV -> {
				children += expectToken(TokenType.DIV)
				children += parse_unaryExpr{}
				children += parse_mulExprs{acc = if (children[1].value == 0) Int.MAX_VALUE else (res.acc / children[1].value)}
				res.apply{ value = children[2].value }
			}
			TokenType.PLUS, TokenType.MINUS, TokenType.SHL, TokenType.SHR, TokenType.EOF, TokenType.RPAREN -> {
				res.apply{ value = res.acc }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_unaryExpr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("unaryExpr", children)
		res.init()
		when (curToken.type) {
			TokenType.MINUS -> {
				children += expectToken(TokenType.MINUS)
				children += parse_primaryExpr{}
				res.apply{ value = -children[1].value }
			}
			TokenType.NUMBER, TokenType.LPAREN -> {
				children += parse_primaryExpr{}
				res.apply{ value = children[0].value }
			}
			else -> unexpectedToken()
		}
		return res
	}

	private fun parse_primaryExpr(init : Tree.() -> Unit) : Tree {
		val children = mutableListOf<Tree>()
		val res = Tree.RuleNode("primaryExpr", children)
		res.init()
		when (curToken.type) {
			TokenType.NUMBER -> {
				children += expectToken(TokenType.NUMBER)
				res.apply{ value = children[0].text.toInt() }
			}
			TokenType.LPAREN -> {
				children += expectToken(TokenType.LPAREN)
				children += parse_expr{}
				children += expectToken(TokenType.RPAREN)
				res.apply{ value = children[1].value }
			}
			else -> unexpectedToken()
		}
		return res
	}

}

