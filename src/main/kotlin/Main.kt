fun main() {
    println("Guess Number App\nTry to guess the number by enter a number.")
    val rand = (0..100).random()
    var userNumber: Int? = null
    var userAttempt = 0

    while (userNumber == null || userNumber != rand) {
        println("Enter a number")
        userNumber = readln().toInt()
        if (userNumber > rand) {
            println("Too high")
        } else if (userNumber < rand) {
            println("Too low")
        }
        userAttempt++
    }

    println("Bravo! The answer was $rand, and you try $userAttempt time(s).")
}