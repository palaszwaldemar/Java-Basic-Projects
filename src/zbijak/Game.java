package zbijak;

import zbijak.players.HumanPlayer;
import zbijak.players.NpcPlayer;
import zbijak.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public Game() {
        NpcPlayer npcPlayer1 = new NpcPlayer(0, 0);
        NpcPlayer npcPlayer2 = new NpcPlayer(0, 9);
        NpcPlayer npcPlayer3 = new NpcPlayer(9, 0);
        HumanPlayer humanPlayer = new HumanPlayer(9, 9);

        players.add(npcPlayer1);
        players.add(npcPlayer2);
        players.add(npcPlayer3);
        players.add(humanPlayer);
    }

    void showTable() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                System.out.print(getFieldText(x, y) + " ");
            }
            System.out.println();
        }
    }

    private String getFieldText(int x, int y) {
        for (Player player : players) {
            if (x == player.getX() && y == player.getY()) {
                return player.getName();
            }
        }
        return "*";
    }

    void move(){
        for (Player player : players) {
            if(player.isHuman()) {
                Scanner scanner = new Scanner(System.in);
                String direction = scanner.nextLine();
                player.move(direction);
            }else{
                player.move("");
            }
        }
    }
}
