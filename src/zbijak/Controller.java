package zbijak;

import java.util.Scanner;

public class Controller {
    private final Game game = new Game();

    void start() {
        System.out.println("\nGRA ZBIJAK\nSTEROWANIE: W, A, S, D\n");
        showTable();
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Podaj pierwszy kierunek: ");
                String secondDirection = scanner.nextLine().toUpperCase();
                System.out.print("Podaj kolejny kierunek: ");
                String firstDirection = scanner.nextLine().toUpperCase();
                game.move(firstDirection, secondDirection);
                showTable();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true/*todo dodać warunek zakończenia gry*/);
    }

    private void showTable() {
        for (int y = 0; y < game.getSizeOfTable(); y++) {
            for (int x = 0; x < game.getSizeOfTable(); x++) {
                System.out.print(game.getFieldText(x, y) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
