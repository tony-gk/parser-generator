import examples.forloop.ForLoopLexer
import examples.forloop.ForLoopParser
import examples.forloop.Tree
import org.junit.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*
import ru.itmo.gunkin.runtime.ParserException

class ForLoopParserTest {
    private fun Tree.info() = when (this) {
        is Tree.RuleNode -> rule
        is Tree.TerminalNode -> text
    }

    private fun Tree.children(): List<Tree> {
        assertTrue(this is Tree.RuleNode)
        return (this as Tree.RuleNode).children
    }

    private fun parse(input: String): Tree {
        return ForLoopParser(ForLoopLexer(input)).start()
    }

    private fun testThrows(invalidInput: String) {
        assertThrows<ParserException>("<$invalidInput>") {
            parse(invalidInput)
        }
    }

    @Test
    fun `Test correct sample`() {
        val testInput = "for (int i =250; i >-123;i--)"
        val tree = parse(testInput)
        assertAll("<$testInput>", {
            assertEquals("start", tree.info())

            val sChildren = tree.children()
            assertIterableEquals(
                listOf("for", "(", "init", ";", "condition", ";", "update", ")"),
                sChildren.map { it.info() },
                "start children"
            )

            val initChildren = sChildren.find { it.info() == "init" }!!.children()
            assertIterableEquals(
                listOf("int", "i", "=", "250"),
                initChildren.map { it.info() },
                "init children"
            )

            val conditionChildren = sChildren.find { it.info() == "condition" }!!.children()
            assertIterableEquals(
                listOf("i", "compareOp", "-123"),
                conditionChildren.map { it.info() },
                "condition children"
            )

            val updateChildren = sChildren.find { it.info() == "update" }!!.children()
            assertIterableEquals(
                listOf("i", "updateOp"),
                updateChildren.map { it.info() },
                "update children"
            )
        })

    }

    @Test
    fun `Test empty 'for'`() {
        testThrows("for ()")
    }

    @Test
    fun `Test 'for' without init`() {
        testThrows("for (k < 1000; t++)")
    }

    @Test
    fun `Test 'for' without condition`() {
        testThrows("for (int i = 0;j--")
    }

    @Test
    fun `Test 'for' without update`() {
        testThrows("for (int i =0;i <1000")
    }

}