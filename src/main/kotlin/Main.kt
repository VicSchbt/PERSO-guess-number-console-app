fun main() {
    println("Guess Number App\nTry to guess the number by enter a number.")
    println("Enter the max range you want to play with")
    val range = readUserInput()

    val user = User(range)
    val rand = (0..user.userRange).random()

    while (user.userNumber == null || user.userNumber != rand) {
        user.userNumber = readUserInput()
        if (user.userNumber!! > rand) {
            println("Too high, ${getRandomMessage()}")
        } else if (user.userNumber!! < rand) {
            println("Too low, , ${getRandomMessage()}")
        }
        user.userAttempt++
    }

    println("🎉 Bravo! The answer was $rand, and you try ${user.userAttempt} time(s).")
}

fun readUserInput(): Int {
    var input: String? = null
    while (input == null || input.toIntOrNull() == null) {
        if(input != null)  println("You enter a wrong format 😬")
        println("🎲 Enter a number")
        input = readln()
    }
    return input.toInt()
}

fun getRandomMessage(): String = MOTIVATION_MESSAGES[MOTIVATION_MESSAGES.indices.random()]