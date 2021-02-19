package examples.forloop

import ru.itmo.gunkin.runtime.ParseTree

sealed class Tree : ParseTree {
	
   
    class RuleNode(val rule: String, val children: List<Tree>) : Tree() {
        override val text: String
            get() = children.joinToString { it.text }
    }
     
    class TerminalNode(val tokenType: String, override val text: String) : Tree()
}

