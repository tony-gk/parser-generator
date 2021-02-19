package examples.calculator

fun main() {
    while(true) {
        val expr = readLine()!!
        println(CalcParser(CalcLexer(expr)).start().value)
    }
}