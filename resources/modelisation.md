classDiagram
    Board "1" --> "2" Player

    class Player{
        ~String name
        ~char color
    }
    class Board{
        ~Array board
        ~addToken()
        ~hasWin()
    }