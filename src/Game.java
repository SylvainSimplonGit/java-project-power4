import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int nbLine = 6;
    private final int nbCol = 7;
    private final Players players = new Players();
    private final Board board = new Board(nbLine, nbCol);
    private final int nbPlayerMax = 2;

    public Game() {
        Scanner scInput = new Scanner(System.in);
        this.initializeGame(scInput);

        int indexPlayer = this.whoBegin();

        int playerWinner = this.runtimeGame(scInput, indexPlayer);

        if (playerWinner == -1) {
            this.displayMsgMatchNul();
        } else {
            this.displayMsgWinner(playerWinner);
        }

        scInput.close();
    }

    private int changePlayer(int indexPlayer) {
        indexPlayer++;
        if (indexPlayer == nbPlayerMax)
            indexPlayer = 0;
        return indexPlayer;
    }

    private void displayMsgMatchNul() {
        board.displayBoard();
        System.out.println();
        System.out.println("Le plateau est plein ! Pas de gagnant pour cette partie !");
    }

    private void displayMsgWinner(int currentPlayer) {
        board.displayBoard();
        System.out.println();
        System.out.println("Le joueur " + players.getPlayer(currentPlayer).getPlayerNumber() + " " + players.getPlayer(currentPlayer).getName() + " a gagné !");
        System.out.println("Bravo " + players.getPlayer(currentPlayer).getName() + " !!");
    }

    private void initializeGame(Scanner scInput) {
        for (int nbPlayer = 0; nbPlayer != 2; nbPlayer++) {
            Player player = new Player();
            player.setPlayerNumber(nbPlayer + 1);
            // Ask name of player
            System.out.println("Joueur " + player.getPlayerNumber() + ", veuillez entrer votre nom :");
            String nameInput = scInput.nextLine();
            player.setName(nameInput);
            do {
                // Ask symbol of player
                System.out.println("Joueur " + player.getPlayerNumber() + ", veuillez entrer votre symbole :");
                char symbolInput = scInput.next(".").charAt(0);
                player.setSymbol(symbolInput);
                scInput.nextLine();
                // Test if player exist
                if (this.players.playerExist(player))
                    System.out.println("Le symbole " + symbolInput + " est déjà choisi par le joueur précédent !");
            } while (this.players.playerExist(player));
            // If Player doesn't exist add him
            this.players.addPlayer(player);
        }
    }

    private void putToken(Scanner scInput, Player player) {
        board.displayBoard();
        int col;
        boolean flagChoiceIsPossible = true;
        do {
            // Ask the player in which column he wants to put his token
            col = wherePutToken(scInput, player);
            flagChoiceIsPossible = board.setPlayerChoice(col - 1, player.getSymbol());
            if (!flagChoiceIsPossible)
                System.out.println("La colonne " + col + " choisie est remplie, choisissez en une autre.");
        } while (!flagChoiceIsPossible);
    }

    private int runtimeGame(Scanner scInput, int indexPlayer) {
        int currentPlayer;
        do {
            currentPlayer = indexPlayer;
            putToken(scInput, players.getPlayer(indexPlayer));
            indexPlayer = changePlayer(indexPlayer);
        } while(!board.hasFourTokenAlignedInBoard() && !board.isBoardIsFilled());

        if (board.isBoardIsFilled())
            currentPlayer = -1;

        return currentPlayer;
    }

    private int wherePutToken(Scanner scInput, Player player) {
        // Clean up Scanner input
        // scInput.nextLine();
        // Ask column chosen
        int colInput;
        do {
            System.out.println("Joueur " + player.getPlayerNumber() + " ("+ player.getSymbol() + ") : " + player.getName() + " veuillez entrer la colonne choisie :");
            colInput = scInput.nextInt();
            scInput.nextLine();
        } while (colInput < 0 || colInput > nbCol + 1);
        return colInput;
    }

    private int whoBegin() {
        Random r = new Random();
        return r.nextInt(this.nbPlayerMax);
    }

}
