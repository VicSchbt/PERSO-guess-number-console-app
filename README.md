# Guess the Number - Project

A simple console-based game where the user attempts to guess a randomly generated number. The game provides feedback on whether the guess is too high or too low and tracks the number of attempts. Additional features enhance the gameplay experience, from input validation to advanced statistics.

## 🎯 Goal of the project

As I am going back to Android Development, I start with the update of my coding skills in Kotlin. Through this project I want to cover the different topics:
- (re-)discover the kotlin syntax
- IO tools for a simple console app
- a brief experiment with OPP


## 🐈 Features List

### 1️⃣ Level 1: Basic Features
1. Generate a random number between 1 and 100.✅
2. Prompt the user to guess the number.✅
3. Compare the user's input with the target number and provide feedback ("Too high", "Too low", "Congratulations!").✅
4. Implement a loop allowing the user to retry until they find the correct number.✅
5. Display the number of attempts after the user wins.✅

### 2️⃣ Level 2: UX and Robustness Improvements
1. Allow the user to choose the range of numbers (e.g., between 1 and N).✅
2. Handle input errors (e.g., prevent non-numeric inputs).✅
3. Add an attempt counter with motivational messages ("Almost there!", "You're close!").✅
4. Provide an option to replay without restarting the application.✅
5. Add an "Easy" mode (unlimited attempts) and a "Hard" mode (limited attempts).✅

### 3️⃣ Level 3: Advanced Features
1. Save the best performance (fewest attempts) in a local file.✅
2. Add a multiplayer mode where each player takes turns guessing.✅
3. Implement an AI opponent that tries to guess the user's number.✅
4. ~~Add a "Hint" mode where the user can request hints in exchange for penalty attempts.~~
5. Display statistics at the end of the game (average attempts, number of games played, etc.).

### Other ideas
- [x] Improve the leader board for including the maxRange parameter and the number of attempts, for instance, someone 
trying 5 times on a range of 20 or 100 is not the same final score
- [ ] Add some test files in order to practice testing in Kotlin

## 🔗 Useful Links
