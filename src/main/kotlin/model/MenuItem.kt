package model

enum class MenuItem {
  GAME,
  LEADERBOARD,
  QUIT
}

fun menuItemFromId(id: Int): MenuItem {
  return when (id) {
    1 -> MenuItem.GAME
    2 -> MenuItem.LEADERBOARD
    3 -> MenuItem.QUIT
    else -> MenuItem.QUIT
  }
}