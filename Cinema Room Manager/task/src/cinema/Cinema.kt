package cinema

fun main() {
    // write your code here

    val currentIncome = arrayListOf(0)
    println("Enter the number of rows:")
    val numRows = readln().toInt().takeIf { it <= 9 }!!
    println("Enter the number of seats in each row:")
    val numSeats = readln().toInt().takeIf { it <= 9 }!!
    val list = MutableList(numRows) { MutableList(numSeats) { "S" } }
    printMenu(list, numSeats, numRows, currentIncome)
}

private fun printMenu(
    list: MutableList<MutableList<String>>,
    numSeats: Int,
    numRows: Int,
    currentIncome: ArrayList<Int>
) {
    println(
        """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
    """.trimIndent()
    )
    try {
        when (readln().toInt().takeIf { it in 0..3 }!!) {
            0 -> return
            1 -> {
                showCinema(list)
                printMenu(list, numSeats, numRows, currentIncome)
            }

            2 -> {
                buyTicket(numSeats, numRows, list, currentIncome)
                printMenu(list, numSeats, numRows, currentIncome)
            }

            3 -> {
                getStats(numSeats, numRows, currentIncome)
                printMenu(list, numSeats, numRows, currentIncome)
            }

            else -> return
        }
    } catch (e: Exception)
    {
        println("Wrong input!")
        printMenu(list,numSeats,numRows,currentIncome)
    }
    
}

fun getStats(numSeats: Int, numRows: Int, currentIncome: ArrayList<Int>) {
    val common = numRows * numSeats
    val countB = currentIncome.size-1
    println("Number of purchased tickets: $countB")
    val percentage = (countB.toFloat() * 100 / common.toFloat())
    val formatPercentage = "%.2f".format(percentage)
    println("Percentage: ${formatPercentage}%")
    val totalIncome = if (common <= 60) {
        common * 10
    } else {
        ((numRows / 2) * 10 * numSeats + (numRows - (numRows / 2)) * 8 * numSeats)
    }

    println("Current income: $${currentIncome.sum()}")
    println("Total income: $${totalIncome}")
}

private fun buyTicket(
    numSeats: Int,
    numRows: Int,
    list: MutableList<MutableList<String>>,
    currentIncome: ArrayList<Int>
) {
    val common = numRows * numSeats
    try {
        println("Enter a row number:")
        val numRow = readln().toInt().takeIf { it <= numSeats }!!
        println("Enter a seat number in that row:")
        val numSeat = readln().toInt().takeIf { it <= numRows }!!
        println()
        if (list[numRow - 1][numSeat - 1].contentEquals("B")) {
            println("That ticket has already been purchased!")
            buyTicket(numSeats, numRows, list, currentIncome)
        } else {

            print("Ticket price: $")
            val ticketPrice = if (common <= 60) {
                10
            } else {
                (if ((numRows / 2) >= numRow) 10 else 8)

            }
            println(ticketPrice)
            currentIncome += ticketPrice
            list[(numRow - 1)][(numSeat - 1)] = "B"
        }
    } catch (e: Exception) {
        println("Wrong input!")
        buyTicket(numSeats, numRows, list, currentIncome)
    }
}


private fun showCinema(list: MutableList<MutableList<String>>) {
    println()
    println("Cinema:")
    for ((counter, i) in list.withIndex()) {
        if (counter == 0) {
            print("  ")
            i.indices.forEach { print("${it + 1} ") }
            print("\n")
        }
        println("${counter + 1} ${i.joinToString(" ")}")
    }
    println()

}