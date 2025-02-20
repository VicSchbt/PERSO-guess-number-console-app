class User(val name:String) {
    var userNumber: Int? = null
    var userAttempt = 0
    var isPlaying = true
    var gameMode: GameMode = GameMode.EASY
}