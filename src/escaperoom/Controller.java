package escaperoom;


public abstract class Controller {
    private final Game game = new Game();

    void start() {
        printMessage("WITAJ W GRZE ESCAPEROOM");
        do {
            displayPlayerItems();
            String choose = chooseItem();
            useItem(choose);
            game.checkIfGameHasRooms();
        } while (!game.isGameEnd());
        printMessage("Brawo wygrałeś!");
    }

    private void displayPlayerItems() {
        StringBuilder show = new StringBuilder();
        for(String name : game.getOwnedItemNames()){
            show.append(name).append("\n");
        }
        printMessage("\nPrzedmioty w plecaku:\n" + show + "\n");
    }

    private String chooseItem() {
        return readAnswer(prepareItemsDisplay()
                + "Podaj nazwe przedmiotu, ktorego chcesz uzyc: ");
    }

    private String prepareItemsDisplay() {
        StringBuilder show = new StringBuilder("Przedmioty w pokoju:\n");
        for (int i = 0; i < game.getItems().size(); i++) {
            show.append(i + 1).append(". ").append(game.getItems().get(i)).append("\n");
        }
        return show.toString();
    }

    private void useItem(String choose) {
        if (choose.equalsIgnoreCase("Szafa")) {//todo wprowadzanie kodu przez użytkownika
            String newCode = readAnswer("Podaj kod: ");
            if (!newCode.contains(game.getRoomsFactory().getCodeCreateWithCreateRoom().getCode())) {
                printMessage("Nieprawidłowy kod");
                return;
            }
        }
        printMessage(game.useItem(choose));
    }

    abstract void printMessage(String message);

    abstract String readAnswer(String question);
}
