package zbijak;

public abstract class Controller {
    private final Game game = new Game();

    private void showTable() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < game.getSIZE(); y++) {
            for (int x = 0; x < game.getSIZE(); x++) {
                stringBuilder.append(game.getFieldText(x, y)).append("  ");
            }
            stringBuilder.append("\n");
        }
        printMessage(stringBuilder.toString());
    }

    private void welcome() {
        printMessage("\nGRA ZBIJAK\nSTEROWANIE: W, A, S, D\n");
        showTable();
    }

    private void endGame() {
        if (game.getHumanTeam().isEmpty()) {
            printMessage("Niestety przegrałeś");
        } else {
            printMessage("Gratulacje. Wygrałeś");
        }
    }

    private void humanTeamMove() {// CHECK: 11.10.2022 czy da się to jakoś czytelniej napisać?
        int count = 0;
        do {
            try {
                game.moveHumanTeam(readAnswer("Podaj " + (count + 1) + " kierunek: "));
                if (count < 1) {
                    showTable();
                }
                count++;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        } while (count <= 1);
    }

    private void npcTeamMove() {
        game.moveNpcTeam();
        showTable();
    }

    void start() {
        welcome();
        boolean humanMove = true;
        do {
            if (humanMove) {
                humanTeamMove();
                humanMove = false;
            } else {
                npcTeamMove();
                humanMove = true;
            }
        } while (!game.getHumanTeam().isEmpty() && !game.getNpcTeam().isEmpty());
        if (!game.getHumanTeam().isEmpty()) {
            showTable();
        }
        endGame();
    }

    abstract void printMessage(String message);

    abstract String readAnswer(String question);
}
