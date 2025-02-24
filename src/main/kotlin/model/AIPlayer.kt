package model

class AIPlayer(var maxRange: Int): Player("Robot") {
  var minRange = 0

  fun pickNumber(): Int {
    return (minRange.. maxRange).random()
  }
}