import examples.calculator.CalcLexer
import examples.calculator.CalcParser
import org.junit.Test
import org.junit.jupiter.api.assertThrows
import ru.itmo.gunkin.runtime.ParserException
import kotlin.test.assertEquals

class CalcParserTest {
    private fun evaluate(expr: String): Int {
        val tree = CalcParser(CalcLexer(expr)).start()
        return tree.value
    }

    private fun testThrows(expr: String) {
        assertThrows<ParserException> { evaluate(expr) }
    }

    private fun testEvaluating(vararg testCases: Pair<Int, String>) {
        for (case in testCases) {
            assertEquals(case.first, evaluate(case.second))
        }
    }

    @Test
    fun `Test empty input`() {
        testThrows("")
    }

    @Test
    fun `Test just parentheses`() {
        testThrows("()")
    }

    @Test
    fun `Test unbalanced parentheses`() {
        testThrows("2 + 3 )")
        testThrows("(1 + 3 * (1 - 1)")
        testThrows("(2 / (3 )")
    }

    @Test
    fun `Test missing factor`() {
        testThrows("2*")
        testThrows("/3")
        testThrows("1 + 3 / ()")
    }

    @Test
    fun `Test missing operators`() {
        testThrows("2 3 + 15")
        testThrows("2 /3 /4 5")
        testThrows("12 (2 + 3)")
    }

    @Test
    fun `Test expression evaluating`() {
        testEvaluating(
            100 to " (100) ",
            15 to "10 + 5",
            0 to "12 - 3 - 5 - 4",
            55 to "20 * 3 - 10 / 2",
            85 to "20 * (3 - 1 / 1) + 15 * (0 + 3)"
        )
    }
}