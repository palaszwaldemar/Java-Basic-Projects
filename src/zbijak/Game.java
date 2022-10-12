package zbijak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final int SIZE = 10;
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

    private void move(String direction, Player player) {// CHECK: 10.10.2022 czy powinienem rozbić tą metodę na mniejsze metody?
        int x = player.getX();
        int y = player.getY();
        switch (direction.toUpperCase()) {
            case "W" -> {
                if (y == 0) {
                    player.setY(SIZE - 1);
                    break;
                }
                player.setY(player.getY() - 1);
            }
            case "A" -> {
                if (x == 0) {
                    player.setX(SIZE - 1);
                    break;
                }
                player.setX(player.getX() - 1);
            }
            case "S" -> {
                if (y == SIZE - 1) {
                    player.setY(0);
                    break;
                }
                player.setY(player.getY() + 1);
            }
            case "D" -> {
                if (x == SIZE - 1) {
                    player.setX(0);
                    break;
                }
                player.setX(player.getX() + 1);
            }
            default -> throw new IllegalArgumentException("Niepoprawny kierunek kierunek");
        }
    }

    void deletePlayerIfTheSameLocation(List<Player> playersToRemove, int x, int y) {
        playersToRemove.removeIf(player -> x == player.getX() && y == player.getY());
    }

    void moveNpcTeam() {
        String[] directionsOfMovement = new String[]{"w", "a", "s", "d"};
        for (Player npc : npcTeam) {
            Random random = new Random();
            int directionIndex = random.nextInt(directionsOfMovement.length);
            String direction = directionsOfMovement[directionIndex];
            move(direction, npc);
            deletePlayerIfTheSameLocation(humanTeam, npc.getX(), npc.getY());
        }
    }

    void moveHumanTeam(String direction) throws IllegalArgumentException {
        for (Player human : humanTeam) {
            move(direction, human);
            deletePlayerIfTheSameLocation(npcTeam, human.getX(), human.getY());
        }
    }
}
