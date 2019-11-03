class TestUnit {

    // Gagnant sur l'axe ligne 1
    private final static char[][] GAME_1 = {
            {'x', 'x', 'x', 'o', 'o', 'x', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'x', 'o'},
            {'o', 'o', 'o', 'x', 'o', 'o', 'o'},
            {'x', 'x', 'o', 'o', 'x', 'o', 'x'},
            {'x', 'x', 'x', 'x', 'o', 'x', 'o'},
            {'x', 'x', 'o', 'x', 'o', 'x', ' '}
    };

    // Gagnant sur l'axe G->D colonne 4
    private final static char[][] GAME_2 = {
            {'x', 'x', 'x', 'o', 'o', 'x', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'x', 'o'},
            {'o', 'o', 'o', 'x', 'o', 'o', 'o'},
            {'x', 'x', 'o', 'o', 'x', 'o', 'x'},
            {'x', 'x', 'x', 'x', 'o', 'x', 'o'},
            {'x', 'x', 'o', 'o', 'o', 'x', ' '}
    };

    // Gagnant sur l'axe D->G colonne 4
    private final static char[][] GAME_3 = {
            {'x', 'x', 'x', 'o', 'o', 'x', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'x', 'o'},
            {'x', 'o', 'o', 'x', 'o', 'o', 'o'},
            {'o', 'x', 'o', 'o', 'x', 'o', 'x'},
            {'x', 'x', 'x', 'x', 'o', 'x', 'o'},
            {'x', 'x', 'o', 'x', 'o', 'x', ' '}
    };

    // Gagnant sur l'axe D->G colonne 1
    private final static char[][] GAME_4 = {
            {'x', 'x', 'x', 'o', 'o', 'x', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'x', 'o'},
            {'x', 'o', 'o', 'x', 'o', 'o', 'o'},
            {'o', 'x', 'x', 'o', 'x', 'o', 'x'},
            {'x', 'o', 'x', 'o', 'x', 'x', 'o'},
            {'x', 'x', 'o', 'o', 'o', 'x', ' '}
    };

    // Gagnant sur la colonne 1
    private final static char[][] GAME = {
            {'x', 'x', 'x', 'o', 'o', 'x', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'x', 'o'},
            {'x', 'o', 'o', 'x', 'o', 'o', 'o'},
            {'x', 'x', 'x', 'o', 'x', 'o', 'x'},
            {'x', 'o', 'x', 'o', 'x', 'x', 'o'},
            {'x', 'x', 'o', 'o', 'o', 'x', ' '}
    };

    TestUnit() {
        int nbLine = 6;
        int nbCol = 7;
        Board board = new Board(nbLine, nbCol);

        boolean result;

        for (int i = 0; i != GAME.length; i++) {
            for (int j = 0; j != GAME[i].length; j++) {
                result = board.setPlayerChoice(j, GAME[i][j]);
            }
        }

        System.out.println("Le plateau " + ((board.isBoardIsFilled()) ? "est plein !" : "n'est pas plein."));

        board.displayBoard();

        boolean rslt = board.hasFourTokenAlignedInBoard();

//        System.out.println("Le plateau " + ((board.hasFourTokenAligned() > -1) ? "a un gagnant à la ligne " + board.hasFourTokenAligned() + " !" : "n'a pas de gagnant."));
    }
}
