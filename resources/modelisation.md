```mermaid
classDiagram
Game --> "2" Player : contient
Game --> "1" Board : contient
Game: + ArrayList Player
Game: + newPlayer()
Game: + whoBegin()
Game: + wherePutToken()
Game: + hasWinner()

Player: - String name
Player: - char symbol
Player: + equals()
Player: - hasSameName()
Player: - hasSameSymbol()

Board: - char[][] board
Board: - int boardWidth
Board: - int boardHeight
Board: - int columnWidthMax
Board: - char[][] STANDARD_DELIMITERS
Board: - int numberOfSameSymbol
Board: - String msgAnalyse
Board: ~ displayBoard()
Board: ~ hasFourTokenAlignedInBoard()
Board: ~ isBoardFilled()
Board: ~ setPlayerChoice()
Board: - centerCharacter()
Board: - emptyBoard()
Board: - getDelimiterLine()
Board: - hasFourTokenAligned()
Board: - hasFourTokenAlignedInColumn()
Board: - hasFourTokenAlignedInDiagonal()
Board: - hasFourTokenAlignedInLine()
Board: - isColumnIsFilled()
