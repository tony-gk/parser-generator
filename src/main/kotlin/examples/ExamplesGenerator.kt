package examples

import ru.itmo.gunkin.gen.generateParser
import java.nio.file.Path

val curDir: Path = Path.of("src/main/kotlin/examples")

fun genForLoop() {
    generateParser(
        "ForLoop",
        curDir.resolve("forloop/forloop.g"),
        curDir.resolve("forloop")
    )
}

fun genCalculator() {
    generateParser(
        "Calc",
        curDir.resolve("calculator/calculator.g"),
        curDir.resolve("calculator")
    )
}

fun main() {
    genForLoop()
//    genCalculator()
}

