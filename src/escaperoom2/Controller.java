package escaperoom2;

import java.util.Scanner;

//tylko tutaj sout i scanner
public class Controller {
    private Game game = new Game();

    void start() {
        System.out.println("WITAJ W GRZE ESCAPEROOM");
        displayItems();
        String choose = chooseItem();
        useItem(choose);
    }

    void displayItems() {
        for (int i = 0; i < game.getItems().size(); i++) {
            System.out.println((i + 1) + ". " + game.getItems().get(i));
        }
    }

    String chooseItem() {
        System.out.print("Podaj nazwe przedmiotu, ktorego chcesz uzyc: ");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        return choose;
    }

    void useItem(String choose) {
        game.useItem(choose);
    }

}
