# Readme for GameSaveTest

**First, you need the csv file in the folder of java files or change the path.**

These folder consist of 2 java files and one csv file. The class CSV contains simple read and write methods for handling csv files. The other class 'SaveGame' extends CSV and handles reading and writing to 'saveGame.csv' file, this class will grow more as more columns are added, or it could completely change if another formatting is more better for saving game data.

###### Things Done
- CSV.java
  - Ability to add rows to csv file
  - Ability to get row or column
  - Ability to write new row
  - Ability to edit rows and columns
- SaveGame.java
  - Ability to add sorted rows in saveGame
  - Ability to get all scores, names, level (will change according to the game)
  - Ability to edit score(still needs work), names, and level
  - Ability to get average of all scores



###### Things To Be Added Later
- CSV.java
  - Ability to add more columns
  - Ability to delete rows (might be overdoing it if the game is simple, seems easy though)

- SaveGame.java
  - Edi Scores and sort it after ***
  - Ability to clear all data (again not necessary)(this can be done in csv but it does not leave the top row)
  - Stats?
  - Ability Edit names?
