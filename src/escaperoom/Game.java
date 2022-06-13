package escaperoom;

import java.util.Scanner;

public class Game {
    private final Window window;
    private final Key key;
    private final Door door;

    public Game(Window window, Key key, Door door) {
        this.window = window;
        this.key = key;
        this.door = door;
    }

    void welcome() {
        System.out.println("\nGRA ESCAPEROOM\nWybierz przedmiot który chcesz uzyc");
    }

    void goodbye() {
        System.out.println("\nGRATULUJE UKONCZENIA GRY");
    }

    void showAvailableOptionsWithoutFoundKey() {
        System.out.println("""
                1. Okno
                2. Drzwi
                3. Klucz""");
    }

    void showAvailableOptionsWithFoundKey() {
        System.out.println("""
                1. Okno
                2. Drzwi""");
    }

    void chooseOptionWithoutFoundKey(String choose) {
        switch (choose) {
            case "Okno" -> window.useWindow();
            case "Drzwi" -> door.useDoor();
            case "Klucz" -> key.takeKey();
            default -> System.out.println("Nie ma takiego przedmiotu");
        }
    }

    void chooseOptionWithFoundKey(String choose) {
        switch (choose) {
            case "Okno" -> window.useWindow();
            case "Drzwi" -> door.useDoor();
            default -> System.out.println("Nie ma takiego przedmiotu");
        }
    }

    void gameWithoutFoundKey() {
        showAvailableOptionsWithoutFoundKey();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Twoj wybor: ");
        String choose = scanner.next();
        chooseOptionWithoutFoundKey(choose);
    }

    void gameWithFoundKey() {
        showAvailableOptionsWithFoundKey();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Twoj wybor: ");
        String choose = scanner.next();
        chooseOptionWithFoundKey(choose);
    }
    void startGame() {
        do {
            if(!key.isInHand()) {
                gameWithoutFoundKey();
            } else {
                gameWithFoundKey();
            }
        } while (!door.isOpen());
    }
}
