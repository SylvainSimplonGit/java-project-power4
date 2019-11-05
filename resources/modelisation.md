```mermaid
classDiagram
Game --> "1" Players : contient
Game --> "1" Board : contient
Players --> "2" Player : contient

Game: - int nbLine
Game: - int nbCol
Game: - Players players
Game: - Board board
Game: - int nbPlayerMax

Game: - changePlayer()
Game: - displayMsgMatchNul()
Game: - displayMsgWinner()
Game: - initializeGame()
Game: - putToken()
Game: - runtimeGame()
Game: - wherePutToken()
Game: - whoBegin()

Players: - ArrayList<> players

Players: ~ addPlayer()
Players: ~ getPlayer()
Players: ~ playerExist()

Player: - String name
Player: - char symbol
Player: - int playerNumber

Player: + equals()
Player: ~ getName()
Player: ~ getPlayerNumber()
Player: ~ getSymbol()
Player: - hasSameSymbol()
Player: ~ setName()
Player: ~ setPlayerNumber()
Player: ~ setSymbol()

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
