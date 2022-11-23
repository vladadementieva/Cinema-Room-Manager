fun main() {
    // put your code here
    val h1 = readln().toInt()
    val h2 = readln().toInt()
    val h3 = readln().toInt()
    println((h2 in h3 - 1 until h1 + 1) || (h2 in h1 - 1 until h3 + 1))
}
