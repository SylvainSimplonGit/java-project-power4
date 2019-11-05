public class Player {

    private String name;
    private char symbol;
    private int playerNumber;

    public Player() {

    }

    @Override
    public boolean equals(Object o) {
        // If o ref is null or is not the same class, we should return false directly.
        if (o == null || getClass() != o.getClass())
            return false;

        // Otherwise, if the name or the symbol is equals then return true
        Player player = (Player) o;
        return this.hasSameSymbol(player.symbol);
    }

    String getName() {
        return name;
    }

    int getPlayerNumber() {
        return this.playerNumber;
    }

    char getSymbol() {
        return this.symbol;
    }

    private boolean hasSameSymbol(char symbolTest) {
        return symbolTest == this.symbol;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPlayerNumber(int number) {
        this.playerNumber = number;
    }

    void setSymbol(char symbol) {
        this.symbol = symbol;
    }


}
