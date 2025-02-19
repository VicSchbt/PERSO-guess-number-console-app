fun main() {
    println("Guess Number App\nTry to guess the number by enter a number.")
    println("Enter the max range you want to play with:")
    val range = readln().toInt()

    val user = User(range)
    val rand = (0..user.userRange).random()

    while (user.userNumber == null || user.userNumber != rand) {
        println("Enter a number")
        user.userNumber = readln().toInt()
        if (user.userNumber!! > rand) {
            println("Too high")
        } else if (user.userNumber!! < rand) {
            println("Too low")
        }
        user.userAttempt++
    }

    println("Bravo! The answer was $rand, and you try ${user.userAttempt} time(s).")
}