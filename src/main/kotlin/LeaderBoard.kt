import java.io.File

class LeaderBoard {
  private val leaderBoardFileName = "leaderboard.txt"
  private val file = File(leaderBoardFileName)
  private lateinit var records: List<String>

  fun initLeaderBoard() {
    if (file.exists()) {
      records = file.readLines()
      order()
      display()
    } else {
      file.createNewFile()
    }
  }

  private fun order() {
    records = records.sortedBy { it.last() }
  }

  private fun display() {
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

  fun saveRecord(userName: String, attempts: Int) {
    val record = "$userName|$attempts\n"
    records += record
    file.appendText(record)
  }

}