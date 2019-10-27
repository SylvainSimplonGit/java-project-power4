classDiagram
Game --> "2" Player : contient
Game --> "1" Board : contient
Game: + ArrayList Player
Game: + newPlayer()
Game: + whoBegin()
Game: + wherePutToken()
Game: + hasWinner()
Player: + String name
Player: + char symbol
Player: + equalsPlayer()
Player: - hasSameName()
Player: - hasSameSymbol()
Board: + Arraylist board
Board: + isColumnIsFilled()
Board: + setPlayerChoice()
Board: + displayBoard()
Board: + hasFourTokenAligned()
Board: + isBoardFilled()
