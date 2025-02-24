import model.*
import utils.MOTIVATION_MESSAGES
import utils.readIntUserInput
import kotlin.system.exitProcess

fun main() {
  println("🎲 Welcome to the Guess Number model.Game 🎲")
  println("🎯 The goal is to guess the number")

  val leaderBoard = LeaderBoard()
  leaderBoard.initLeaderBoard()

  while (true) {
    println("What do you want to do? [1] 🎲Play! [2] 🏆Leaderboard [3] 👋Quit")
    val menuItem = menuItemFromId(readIntUserInput(3))

    when (menuItem) {
      MenuItem.GAME -> playGame(leaderBoard)
      MenuItem.LEADERBOARD -> leaderBoard.display()
      MenuItem.QUIT -> exitProcess(0)
    }
  }
}

fun playGame(leaderBoard: LeaderBoard) {
  val game = Game()
  while (game.isRunning) {
    game.players.forEach { player ->
      if (game.isRunning && playTurn(player, game)) {
        playerWins(player, game, leaderBoard)
      }
    }
    if (game.isRunning && game.isGameEnds()) game.isTheGameKeepGoing()
    game.turnNumber++
  }
}

fun playTurn(player: Player, game: Game): Boolean {
  var playerWins = false
  println("\n${player.name} is your turn")
  if (player is AIPlayer) {
    player.chosenNumber = player.pickNumber()
    println(player.chosenNumber)
  } else {
    player.chosenNumber = readIntUserInput(null)
  }
  when  {
    player.chosenNumber!! > game.numberToGuess -> {
      println("Too high, ${getRandomMessage()}\n")
      if (player is AIPlayer) {
        player.maxRange = player.chosenNumber!! - 1
      } else if (game.isRobotPlaying) {
        (game.players[1] as AIPlayer).maxRange = player.chosenNumber!! - 1
      }
    }
    player.chosenNumber!! < game.numberToGuess -> {
      println("Too low, , ${getRandomMessage()}\n")
      if (player is AIPlayer) {
        player.minRange = player.chosenNumber!! + 1
      } else if (game.isRobotPlaying) {
        (game.players[1] as AIPlayer).minRange = player.chosenNumber!! + 1
      }
    }
    else -> playerWins = true
  }
  player.attempt++
  return playerWins
}

fun playerWins(player: Player, game: Game, leaderBoard: LeaderBoard) {
  println("🎉 Bravo! The answer was ${game.numberToGuess}, and you try " +
      "${player.attempt} time(s)."
  )
  if (player !is AIPlayer) leaderBoard.saveRecord(player.name, player.attempt)
  game.isRunning = false
}

fun getRandomMessage(): String =
  MOTIVATION_MESSAGES[MOTIVATION_MESSAGES.indices.random()]



