package zbijak;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    final static int SIZE = 10;// CHECK: 14.10.2022 czy to pole może zostać z domyślnym dostępem?
    private final static String[] directionsOfMovement = new String[] {"W","A","S","D"};// CHECK: 14.10.2022 czy da się tą tablicę jakoś zbudować z Klasy Direction?
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

    private void move(String direction, Player player) {
        switch (direction.toUpperCase()) {// CHECK: 14.10.2022 poruszanie się npc-ów przeniesione do klasy Player
            case "W" -> player.move(Direction.UP);// CHECK: 14.10.2022 jak zrobić aby można było przeszukiwać pole directionsOfMovement?
            case "A" -> player.move(Direction.LEFT);
            case "S" -> player.move(Direction.DOWN);
            case "D" -> player.move(Direction.RIGHT);
            default -> throw new IllegalArgumentException("Niepoprawny kierunek");
        }
    }

    void moveNpcTeam() {
        for (Player npc : npcTeam) {
            Random random = new Random();
            int directionIndex = random.nextInt(directionsOfMovement.length);
            String direction = directionsOfMovement[directionIndex];
            move(direction, npc);
            deletePlayerIfTheSameLocation(humanTeam, npc.getX(), npc.getY());
        }
    }

    private void deletePlayerIfTheSameLocation(List<Player> playersToRemove, int x, int y) {
        playersToRemove.removeIf(player -> x == player.getX() && y == player.getY());
    }

    void moveHumanTeam(String direction) throws IllegalArgumentException {
        for (Player human : humanTeam) {
            move(direction, human);
            deletePlayerIfTheSameLocation(npcTeam, human.getX(), human.getY());
        }
    }
}
