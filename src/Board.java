public class Board {

    private final char[][] board;
    private final int boardWidth;
    private final int boardHeight;
    private final int columnWidthMax = 5;
    private final static char[][] STANDARD_DELIMITERS = {{'┏', '┳', '┓'}, {'┣', '╋', '┫'}, {'┗', '┻', '┛'}};


    public Board(int line, int column) {
        this.boardWidth = column;
        this.boardHeight = line;
        this.board = new char[this.boardHeight][this.boardWidth];
        this.emptyBoard();
        this.board[5][3] = 'o';
        this.board[5][2] = 'x';
        this.board[4][2] = 'x';
    }

    private void emptyBoard() {
        for (int lin = 0; lin != this.boardHeight; lin++) {
            for (int col = 0; col != this.boardWidth; col++) {
                this.board[lin][col] = ' ';
            }
        }
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
                linesToPrint[lineCounter] += "|";
                symbolLineCounter++;
            }
        }

        // Display Header
        String lineHeader = " ";
        for (int col = 0; col != this.boardWidth; col++) {
            // Center number of column
            lineHeader += this.centerCharacter("(" + (col + 1) + ")");
        }
        System.out.println(lineHeader);

        // Display board
        for (String lineToPrint : linesToPrint) {
            System.out.println(lineToPrint);
        }
    }

    private String centerCharacter(String str) {
        String cell = "";
        int pad = ((this.columnWidthMax - str.length()) % 2 == 0) ? (this.columnWidthMax - str.length()) / 2 : (this.columnWidthMax - str.length()) / 2 + 1;
        cell += (" ").repeat(pad);
        cell += str;
        cell += (" ").repeat(this.columnWidthMax - (3 + pad) + 1);

        return cell;
    }

    private String getDelimiterLine(char[] lineDelimiters, int lineCounter) {
        String delimiterLine = "";

        for (int colCounter = 0; colCounter != this.boardWidth + 1; colCounter++) {
            if (colCounter == 0) {
                delimiterLine += lineDelimiters[0];
            } else if (colCounter == this.boardWidth) {
                delimiterLine += lineDelimiters[2];
            } else {
                delimiterLine += lineDelimiters[1];
            }
            for (int colWidthCounter = 0; colCounter < this.boardWidth && colWidthCounter < this.columnWidthMax; colWidthCounter++) {
                if (lineCounter == 0) {
                    delimiterLine += " ";
                } else {
                    delimiterLine += "-";
                }
            }
        }

        return delimiterLine;
    }

}
