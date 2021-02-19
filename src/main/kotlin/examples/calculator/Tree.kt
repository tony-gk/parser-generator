package examples.calculator

import ru.itmo.gunkin.runtime.ParseTree

sealed class Tree : ParseTree {
	var value = 0
	var acc = 0
   
    class RuleNode(val rule: String, val children: List<Tree>) : Tree() {
        override val text: String
            get() = children.joinToString { it.text }
    }
     
    class TerminalNode(val tokenType: String, override val text: String) : Tree()
}

