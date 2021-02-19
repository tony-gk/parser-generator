package examples.forloop

import java.io.File
import java.io.PrintWriter

fun main() {
    val expr = "for (int i = -10000  ;j < 1000; i ++ )"
    val tree = ForLoopParser(ForLoopLexer(expr)).start()

    File("graphviz/tree.dot").printWriter().use { writer ->
        writer.println("digraph tree {")
        writer.describeTree(tree, 0)
        writer.println("}")
    }

    ProcessBuilder("dot", "-Tpng", "graphviz/tree.dot")
        .redirectOutput(File("graphviz/tree.png"))
        .start()
        .waitFor()
}

fun PrintWriter.describeTree(node: Tree, nodeId: Int): Int {
    val nodeData: String = when(node) {
        is Tree.RuleNode -> node.rule
        is Tree.TerminalNode -> node.text
    }
    println("""     $nodeId [label="$nodeData"];""")
    var nextId = nodeId + 1
    if (node is Tree.RuleNode) {
        for (child in node.children) {
            val childId = nextId
            nextId = describeTree(child, childId)
            println("     $nodeId -> $childId;")
        }
    }
    return nextId
}
