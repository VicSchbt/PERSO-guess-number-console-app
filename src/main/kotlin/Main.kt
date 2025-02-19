import java.util.Scanner

fun main() {
    println("Guess Number App\nTry to guess the number by enter a number.")
    val rand = (0..100).random()
    var userNumber: Int? = null

    while (userNumber == null || userNumber != rand) {
        println("Enter a number")
        userNumber = readln().toInt()
        if (userNumber > rand) {
            println("Too high")
        } else if (userNumber < rand) {
            println("Too low")
        }
    }

    println("Bravo! The answer was $rand.")
}