package zbijak;

import java.util.Scanner;

public class Controller {
    private final Game game = new Game();

    private void showTable() {
        for (int y = 0; y < game.getSIZE(); y++) {
            for (int x = 0; x < game.getSIZE(); x++) {
                System.out.print(game.getFieldText(x, y) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void welcome() {
        System.out.println("\nGRA ZBIJAK\nSTEROWANIE: W, A, S, D\n");
        showTable();
    }

    private void endGame() {
        if(game.getHumanTeam().isEmpty()) {
            System.out.println("Niestety przegrałeś");
        } else {
            System.out.println("Gratulacje. Wygrałeś");
        }
    }

    private void humanTeamMove() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        do {
            try {
                System.out.print("Podaj " + count + " kierunek: ");
                game.moveHumanTeam(scanner.nextLine());
                showTable();
                count ++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (count <= 2);
    }

    private void npcTeamMove() {
        game.moveNpcTeam();
        showTable();
    }

    void start() {
        welcome();
        do {
            humanTeamMove();
            npcTeamMove();
        } while (game.getHumanTeam().isEmpty() || game.getNpcTeam().isEmpty());
        endGame();
    }
}
