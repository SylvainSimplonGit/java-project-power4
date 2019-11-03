public class Board {

    private final char[][] board;
    private final int boardWidth;
    private final int boardHeight;
    private final int columnWidthMax = 3;
    private final static char[][] STANDARD_DELIMITERS = {{'┏', '┳', '┓'}, {'┣', '╋', '┫'}, {'┗', '┻', '┛'}};
    private int numberOfSameSymbol;
    private String msgAnalyse = "";


    public Board(int line, int column) {
        this.boardWidth = column;
        this.boardHeight = line;
        this.board = new char[this.boardHeight][this.boardWidth];
        this.emptyBoard();
    }

    void displayBoard() {
        // String array declaration
        String[] linesToPrint = new String[this.boardHeight * 2 + 1];

        // Counter used to get symbol in board
        int symbolLineCounter = 0;

        for (int lineCounter = 0; lineCounter != (this.boardHeight * 2) + 1; lineCounter++) {
            linesToPrint[lineCounter] = "";
            // Counter used to get symbol in board
            int symbolColCounter = 0;

            // if it's delimiter line
            if (lineCounter % 2 == 0) {
                char[] lineDelimiters;
                if (lineCounter == 0) {
                    lineDelimiters = STANDARD_DELIMITERS[0];
                } else if (lineCounter == this.boardHeight * 2) {
                    lineDelimiters = STANDARD_DELIMITERS[2];
                } else {
                    lineDelimiters = STANDARD_DELIMITERS[1];
                }
                linesToPrint[lineCounter] = getDelimiterLine(lineDelimiters, lineCounter);
            } else {
                for (int colCounter = 0; colCounter < this.boardWidth; colCounter++) {
                    char symbolToPrint = this.board[symbolLineCounter][symbolColCounter];
                    linesToPrint[lineCounter] += "|" + this.centerCharacter("" + symbolToPrint) + " ";
                    symbolColCounter++;
                }
                linesToPrint[lineCounter] += "| (" + (lineCounter / 2 + 1)+ ")";
                symbolLineCounter++;
            }
        }

        // Display Header
        StringBuilder lineHeader = new StringBuilder(" ");
        for (int col = 0; col != this.boardWidth; col++) {
            // Center number of column
            lineHeader.append(this.centerCharacter("(" + (col + 1) + ")"));
        }
        System.out.println(lineHeader);

        // Display board
        for (String lineToPrint : linesToPrint) {
            System.out.println(lineToPrint);
        }
    }

    boolean hasFourTokenAlignedInBoard() {
        boolean flagFourTokenAligned = false;
        // Test if there is four token in each line
        flagFourTokenAligned = hasFourTokenAlignedInLine();
        // Test if there is four token in each column
        if (!flagFourTokenAligned) {
            flagFourTokenAligned = hasFourTokenAlignedInColumn();
        }
        // Test if there is four token in each diagonal
        if (!flagFourTokenAligned) {
            flagFourTokenAligned = hasFourTokenAlignedInDiagonal();
        }
        System.out.println(this.msgAnalyse);
        return flagFourTokenAligned;
    }

    boolean isBoardIsFilled() {
        boolean flagFilled = true;
        for (int col = 0; col != this.boardWidth; col++) {
            if (this.board[0][col] == ' ') {
                flagFilled = false;
                break;
            }
        }
        return flagFilled;
    }

    boolean setPlayerChoice(int col, char symbol) {
        boolean flagColIsFilled = true;
        if (isColumnIsFilled(col)) {
            flagColIsFilled = false;
        } else {
            for (int line = this.boardHeight; line != 0; line--) {
                if (this.board[line - 1][col] == ' ') {
                    this.board[line - 1][col] = symbol;
                    flagColIsFilled = true;
                    break;
                }
            }
        }
        return flagColIsFilled;
    }

    private String centerCharacter(String str) {
        String cell = "";
        int pad = ((this.columnWidthMax - str.length()) % 2 == 0) ? (this.columnWidthMax - str.length()) / 2 : (this.columnWidthMax - str.length()) / 2 + 1;
        cell += (" ").repeat(pad);
        cell += str;
        cell += (" ").repeat(this.columnWidthMax - (3 + pad) + 1);
        return cell;
    }

    private void emptyBoard() {
        for (int lin = 0; lin != this.boardHeight; lin++) {
            for (int col = 0; col != this.boardWidth; col++) {
                this.board[lin][col] = ' ';
            }
        }
    }

    private String getDelimiterLine(char[] lineDelimiters, int lineCounter) {
        StringBuilder delimiterLine = new StringBuilder();

        for (int colCounter = 0; colCounter != this.boardWidth + 1; colCounter++) {
            if (colCounter == 0) {
                delimiterLine.append(lineDelimiters[0]);
            } else if (colCounter == this.boardWidth) {
                delimiterLine.append(lineDelimiters[2]);
            } else {
                delimiterLine.append(lineDelimiters[1]);
            }
            for (int colWidthCounter = 0; colCounter < this.boardWidth && colWidthCounter < this.columnWidthMax; colWidthCounter++) {
                if (lineCounter == 0) {
                    delimiterLine.append(" ");
                } else {
                    delimiterLine.append("-");
                }
            }
        }

        return delimiterLine.toString();
    }

    private boolean hasFourTokenAligned(int line1, int col1, int line2, int col2) {
        boolean flagResult = false;
        if (this.board[line1][col1] == this.board[line2][col2]) {
            this.numberOfSameSymbol++;
            if (this.numberOfSameSymbol == 4) {
                flagResult = true;
            }
        } else {
            this.numberOfSameSymbol = 1;
        }
        return flagResult;
    }

    private boolean hasFourTokenAlignedInColumn() {
        boolean flagHasFourTokenAlignedInColumn = false;
        for (int col = 0; col != this.boardWidth; col++) {
            this.numberOfSameSymbol = 1;
            for (int line = 0; line != this.boardHeight - 1; line++) {
                flagHasFourTokenAlignedInColumn = hasFourTokenAligned(line, col, line + 1, col);
                if (flagHasFourTokenAlignedInColumn) {
                    this.msgAnalyse = "Le plateau a un gagnant à la colonne : " + (col + 1);
                    break;
                }
            }
            if (flagHasFourTokenAlignedInColumn) {
                break;
            }
        }
        return flagHasFourTokenAlignedInColumn;
    }

    private boolean hasFourTokenAlignedInDiagonal() {
        boolean flagHasFourTokenAlignedInDiagonal = false;
        int origin;
        int vector;

        // sur l'axe 2,0 parcourir la diagonale (2,0), (3,1), (4,2), (5,3)
        // sur l'axe 1,0 parcourir la diagonale (1,0), (2,1), (3,2), (4,3), (5,4)
        // sur l'axe 0,0 parcourir la diagonale (0,0), (1,1), (2,2), (3,3), (4,4), (5,5)
        for (int axe = 2; axe != -1; axe--) {
            this.numberOfSameSymbol = 1;
            origin = axe;
            vector = 0;
            while (origin != this.boardHeight - 1 && !flagHasFourTokenAlignedInDiagonal) {
                flagHasFourTokenAlignedInDiagonal = hasFourTokenAligned(origin, vector, origin + 1, vector + 1);
                origin++;
                vector++;
            }
            if (flagHasFourTokenAlignedInDiagonal) {
                this.msgAnalyse = "Le plateau a un gagnant sur l'axe D->G colonne : " + (axe + 1);
                break;
            }
        }

        // If 4 tokens are not aligned
        if (!flagHasFourTokenAlignedInDiagonal) {
            // sur l'axe 0,1 parcourir la diagonale (0,1), (1,2), (2,3), (3,4), (4,5), (5,6)
            // sur l'axe 0,2 parcourir la diagonale (0,2), (1,3), (2,4), (3,5), (4,6)
            // sur l'axe 0,3 parcourir la diagonale (0,3), (1,4), (2,5), (3,6)
            for (int axe = 1; axe != 4; axe++) {
                this.numberOfSameSymbol = 1;
                origin = 0;
                vector = axe;
                while (vector != this.boardWidth - 1 && !flagHasFourTokenAlignedInDiagonal) {
                    flagHasFourTokenAlignedInDiagonal = hasFourTokenAligned(origin, vector, origin + 1, vector + 1);
                    origin++;
                    vector++;
                }
                if (flagHasFourTokenAlignedInDiagonal) {
                    this.msgAnalyse = "Le plateau a un gagnant sur l'axe G->D colonne : " + (axe + 1);
                    break;
                }
            }
        }

        // If 4 tokens are not aligned
        if (!flagHasFourTokenAlignedInDiagonal) {
            // sur l'axe 0,3 parcourir la diagonale (0,3), (1,2), (2,1), (3,0)
            // sur l'axe 0,4 parcourir la diagonale (0,4), (1,3), (2,2), (3,1), (4,0)
            // sur l'axe 0,5 parcourir la diagonale (0,5), (1,4), (2,3), (3,2), (4,1), (5,0)
            for (int axe = 3; axe != 6; axe++) {
                numberOfSameSymbol = 1;
                origin = 0;
                vector = axe;
                while (vector != 0 && !flagHasFourTokenAlignedInDiagonal) {
                    flagHasFourTokenAlignedInDiagonal = hasFourTokenAligned(origin, vector, origin + 1, vector - 1);
                    origin++;
                    vector--;
                }
                if (flagHasFourTokenAlignedInDiagonal) {
                    this.msgAnalyse = "Le plateau a un gagnant sur l'axe D->G colonne : " + (axe + 1);
                    break;
                }
            }
        }

        // If 4 tokens are not aligned
        if (!flagHasFourTokenAlignedInDiagonal) {
            // sur l'axe 0,6 parcourir la diagonale (0,6), (1,5), (2,4), (3,3), (4,2), (5,1)
            // sur l'axe 1,6 parcourir la diagonale (1,6), (2,5), (3,4), (4,3), (5,2)
            // sur l'axe 2,6 parcourir la diagonale (2,6), (3,5), (4,4), (5,3)
            for (int axe = 0; axe != 3; axe++) {
                this.numberOfSameSymbol = 1;
                origin = axe;
                vector = 6;
                while (origin != this.boardHeight - 1 && !flagHasFourTokenAlignedInDiagonal) {
                    flagHasFourTokenAlignedInDiagonal = hasFourTokenAligned(origin, vector, origin + 1, vector - 1);
                    origin++;
                    vector--;
                }
                if (flagHasFourTokenAlignedInDiagonal) {
                    this.msgAnalyse = "Le plateau a un gagnant sur l'axe ligne : " + (axe + 1);
                    break;
                }
            }
        }

        return flagHasFourTokenAlignedInDiagonal;
    }

    private boolean hasFourTokenAlignedInLine() {
        boolean flagHasFourTokenAlignedInLine = false;
        for (int line = this.boardHeight - 1; line != -1; line--) {
            this.numberOfSameSymbol = 1;
            for (int col = 0; col != this.boardWidth - 1; col++) {
                flagHasFourTokenAlignedInLine = hasFourTokenAligned(line, col, line, col+1);
                if (flagHasFourTokenAlignedInLine) {
                    this.msgAnalyse = "Le plateau a un gagnant à la ligne : " + (line + 1);
                    break;
                }
            }
            if (flagHasFourTokenAlignedInLine) {
                break;
            }
        }
        return flagHasFourTokenAlignedInLine;
    }

    private boolean isColumnIsFilled(int col) {
        return this.board[0][col] != ' ';
    }

}
