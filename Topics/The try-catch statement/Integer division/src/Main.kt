import java.lang.ArithmeticException
import java.lang.NumberFormatException

fun intDivision(x: String, y: String): Int {
    return try {
        val x1 = x.toInt()
        val y1 = y.toInt()
        (x1 / y1)
    } catch (e: ArithmeticException) {
        println(" Exception: division by zero!")
        0
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
        0
    }
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))

}