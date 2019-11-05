import java.util.ArrayList;

public class Players {
    private final ArrayList<Player> players = new ArrayList<>();

    Players() {

    }

    Player getPlayer(int index) {
        return players.get(index);
    }

    void addPlayer(Player p) {
        players.add(p);
    }

    boolean playerExist(Player p) {
        boolean flag = false;
        if (players.size() > 0) {
            for (int i = 0; i != players.size(); i++) {
                flag = players.get(i).equals(p);
            }
        }
        return flag;
    }


}
