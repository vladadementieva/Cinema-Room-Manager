import java.lang.Math.abs
import kotlin.Exception

fun calculateBrakingDistance(v1: String, a: String): Int {
    // write your code here
    return try {
        if (v1.toInt()==v1.toInt()) {
            if (a.toInt() == 0) {
                throw (Exception("The car does not slow down!"))
            }
        }
        abs(v1.toInt() * v1.toInt() / 2 * a.toInt())

    } catch (e: Exception) {
        println(e.message)
        //println(-1)
        -1

    }
}