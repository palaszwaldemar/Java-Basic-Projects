package zbijak;

public abstract class Controller {
    private final Game game = new Game();

    private StringBuilder showTable() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < game.getSIZE(); y++) {
            for (int x = 0; x < game.getSIZE(); x++) {
                stringBuilder.append(game.getFieldText(x, y)).append("   ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    private void welcome() {
        printMessage("\nGRA ZBIJAK\nSTEROWANIE: W, A, S, D\n");
    }

    private void endGame() {
        if (game.getHumanTeam().isEmpty()) {
            printMessage("Niestety przegrałeś");
        } else {
            printMessage("Gratulacje. Wygrałeś");
        }
    }

    private void humanTeamMove() {
        int count = 1;
        do {
            try {
                game.moveHumanTeam(readAnswer(showTable() + "Podaj " + count + " kierunek: "));
                count++;
            } catch (IllegalArgumentException e) {
                printMessage(e.getMessage());
            }
        } while (count <= 2);
    }

    private void npcTeamMove() {
        game.moveNpcTeam();
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
        printMessage(showTable().toString());
        endGame();
    }

    abstract void printMessage(String message);

    abstract String readAnswer(String question);
}
