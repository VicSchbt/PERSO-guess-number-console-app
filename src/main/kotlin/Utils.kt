fun readIntUserInput(maxRange: Int?): Int {
  var input: Int? = null
  while (input == null) {
    println("➡ Enter a number")
    input = readln().toIntOrNull()
    if (input == null) {
      println("You enter a wrong format 😬 You should enter a number 🔟")
      continue
    }
    if (maxRange != null && input > maxRange) {
      println("You are out of the options, pick an option between 1 and $maxRange")
      input = null
    }
  }
  return input.toInt()
}