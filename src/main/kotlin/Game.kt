class Game() {
  var gameMode: GameMode = GameMode.EASY
  var players: List<Player>
    private set
  var maxRange: Int
  var numberToGuess: Int
  var isRunning = true
  var turnNumber = 1

  init {
    gameMode = pickGameMode()
    players = initPlayers()
    println("Enter the max range you want to play with")
    maxRange = readIntUserInput(null)
    numberToGuess = (1..maxRange).random()
  }

  private fun pickGameMode(): GameMode {
    var userInput: String? = null
    while (userInput == null) {
      println("Pick your mode: [1]🐣easy [2]😈hard")
      userInput = readln()
      if (userInput != "1" && userInput != "2") userInput = null
    }
    if (userInput == "1") return GameMode.EASY
    return GameMode.HARD
  }

  private fun initPlayers(): List<Player> {
    println("How many player are playing?")
    val numberOfPlayer = readIntUserInput(null)
    val players = mutableListOf<Player>()
    for (i in 1..numberOfPlayer ) {
      println("Player $i: enter your name")
      val userName = readln()
      players += Player(userName)
    }
    return players.toList()
  }

  fun isGameEnds(): Boolean {
    if (gameMode == GameMode.HARD && turnNumber >=
      HARD_MODE_MAX_ATTEMPT
    ) {
      println("🥺Oh no! You loose!")
      isRunning = false
      return true
    }
    return false
  }

  fun isTheGameKeepGoing() {
    println("🚀Do you want to play again? [1]✅Yes [2]❌No")
    val userInput = readIntUserInput(2)
    isRunning = userInput == 1
  }
}