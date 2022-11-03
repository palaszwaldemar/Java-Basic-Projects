package zbijak;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final static int SIZE = 10;
    private final List<Player> humanTeam = new ArrayList<>();
    private final List<Player> npcTeam = new ArrayList<>();

    public Game() {
        HumanPlayer humanPlayer = new HumanPlayer(SIZE - 1, SIZE - 1);
        NpcPlayer npcPlayer1 = new NpcPlayer(0, 0);
        NpcPlayer npcPlayer2 = new NpcPlayer(0, SIZE - 1);
        NpcPlayer npcPlayer3 = new NpcPlayer(SIZE - 1, 0);

        npcTeam.add(npcPlayer1);
        npcTeam.add(npcPlayer2);
        npcTeam.add(npcPlayer3);
        humanTeam.add(humanPlayer);
    }

    public int getSIZE() {
        return SIZE;
    }

    public List<Player> getHumanTeam() {
        return humanTeam;
    }

    public List<Player> getNpcTeam() {
        return npcTeam;
    }

    String getFieldText(int x, int y) {
        for (Player player : humanTeam) {
            if (x == player.getX() && y == player.getY()) {
                return player.getName();
            }
        }
        for (Player player : npcTeam) {
            if (x == player.getX() && y == player.getY()) {
                return player.getName();
            }
        }
        return "*";
    }

    void moveNpcTeam() {
        for (Player npc : npcTeam) {
            npc.move(Direction.randomDirection());
            deletePlayerIfTheSameLocation(humanTeam, npc.getX(), npc.getY());
        }
    }

    private void deletePlayerIfTheSameLocation(List<Player> playersToRemove, int x, int y) {
        playersToRemove.removeIf(player -> x == player.getX() && y == player.getY());
    }

    void moveHumanTeam(Direction direction) {
        for (Player human : humanTeam) {
            human.move(direction);
            deletePlayerIfTheSameLocation(npcTeam, human.getX(), human.getY());
        }
    }
}
