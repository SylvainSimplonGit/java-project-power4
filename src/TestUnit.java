import java.util.Scanner;

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
        Scanner scInput = new Scanner(System.in);
//        this.testPlayer(scInput);

        scInput.close();
    }

//    private void testPlayer(Scanner scInput) {
//        Players players = new Players();
//
//        for (int nbPlayer = 0; nbPlayer != 2; nbPlayer++) {
//            // Ask name of player
//            System.out.println("Joueur " + (nbPlayer  + 1) + ", veuillez entrer votre nom :");
//            String nameInput = scInput.nextLine();
//            Player player = new Player();
//            player.setName(nameInput);
//            do {
//                // Ask symbol of player
//                System.out.println("Joueur " + (nbPlayer + 1) + ", veuillez entrer votre symbole :");
//                char symbolInput = scInput.next(".").charAt(0);
//                player.setSymbol(symbolInput);
//                scInput.nextLine();
//                // Test if player exist
//                if (players.playerExist(player))
//                    System.out.println("Le symbole " + symbolInput + " est déjà choisi par le joueur précédent !");
//            } while (players.playerExist(player));
//            // If Player doesn't exist add him
//            players.addPlayer(player);
//        }
//    }

    private void testBoard() {
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
    }
}
