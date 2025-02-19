fun main() {
    println("Guess Number App\nTry to guess the number by enter a number.")

    val user = User()
    while (user.isPlaying) {
        println("Enter the max range you want to play with")
        val range = readUserInput()
        val rand = (0..range).random()

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
        user.isPlaying = isTheUserKeepGoing()
    }

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

fun isTheUserKeepGoing(): Boolean {
    var userInput: String? = null
    while (userInput == null) {
        println("Do you want to play again? [y/n]")
        userInput = readln()

       if (userInput != "y" && userInput != "n") userInput = null
    }
    return userInput == "y"
}