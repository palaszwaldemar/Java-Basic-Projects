package zbijak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public Game() {
        Random random = new Random();
        int setXOnBoard = random.nextInt(9) + 1;
        int setYOnBoard = random.nextInt(9) + 1;
        HumanPlayer humanPlayer = new HumanPlayer("x");
        NpcPlayer npcPlayer1 = new NpcPlayer("^");
        NpcPlayer npcPlayer2 = new NpcPlayer("^");
        NpcPlayer npcPlayer3 = new NpcPlayer("^");
        humanPlayer.setX(setXOnBoard);
        humanPlayer.setY(setYOnBoard);
        players.add(humanPlayer);
    }

    void printBoard() {
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 0; k < players.size(); k++) {
                    if (players.get(k).getX() == j && players.get(k).getY() == i) {
                        System.out.print(players.get(k).getName() + "  ");
                    } else {
                        System.out.print("*  ");
                    }
                }
            }
            System.out.println();
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
