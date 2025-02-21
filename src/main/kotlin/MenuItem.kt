enum class MenuItem(val id: Int) {
  GAME(1),
  LEADERBOARD(2),
  QUIT(3)
}

fun menuItemFromId(id: Int): MenuItem {
  return when (id) {
    1 -> MenuItem.GAME
    2 -> MenuItem.LEADERBOARD
    3 -> MenuItem.QUIT
    else -> MenuItem.QUIT
  }
}