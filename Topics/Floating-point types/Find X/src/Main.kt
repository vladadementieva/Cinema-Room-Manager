fun main() {
    // put your code here
    val a= readln().toDouble().takeIf { it!= Double.NaN }
    val b= readln().toDouble()
    val c= readln().toDouble()
    println((c-b)/ a!!)
}