package model

import java.io.File

class LeaderBoard {
  private val leaderBoardFileName = "leaderboard.txt"
  private val file = File(leaderBoardFileName)
  private lateinit var records: List<String>

  init {
    if (!file.exists()) file.createNewFile()
    records = file.readLines()
    if (records.isNotEmpty()) {
      order()
      display()
    }
  }

  private fun order() {
    records = records.sortedBy { it.split('|')[1] }
  }

  fun display() {
    println()
    println("🏆 Leader Board 🏆")
    var i = 1
    records.forEach{
      val userName = it.split('|')[0]
      val score = it.split('|')[1]
      when (i++) {
        1 -> println("🥇$userName -> $score")
        2 -> println("🥈$userName -> $score")
        3 -> println("🥉$userName -> $score")
        4, 5 -> println("🏅$userName -> $score")
      }
    }
    println()
  }

  fun saveRecord(userName: String, attempts: Int, maxRange: Int) {
    val record = "$userName|${computeScore(attempts, maxRange)}\n"
    records += record
    file.appendText(record)
  }

  private fun computeScore(attempts: Int, maxRange: Int): Double {
    return Math.round(maxRange.toDouble() / attempts.toDouble() * 10.0) / 10.0
  }

}