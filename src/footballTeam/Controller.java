package footballTeam;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public abstract class Controller {
    private final Manager manager = new Manager();
    public final int END_PROGRAM = 6;

    void start() {
        printMessage("\nMANAGER DRUŻYNY PIŁKARSKIEJ\n");
        interactWithMenu();
    }

    private void interactWithMenu() {
        int choose;
        do {
            choose = handleDecision();
        } while (choose != END_PROGRAM);
    }

    private int handleDecision() {
        try {
            int choose = Integer.parseInt(readAnswer(showProgramOptions() + "\nPodaj numer z menu: "));
            chooseProgramOption(choose);
            return choose;
        } catch (FileNotFoundException e) {
            printMessage("Nie znaleziono pliku\n");
        } catch (DateTimeParseException e) {
            printMessage("\nBłędny format daty\n");
        } catch (PlayerException e) {
            printMessage(e.getMessage());
        } catch (InputMismatchException e) {
            printMessage("\nNiepoprawne dane\n");
        } catch (IllegalArgumentException e) {
            printMessage("\nBłędnie wprowadzone dane\n");
        }
        return -1;
    }

    private void chooseProgramOption(int choose) throws FileNotFoundException {
        switch (choose) {
            case 1 -> showPlayers();
            case 2 -> searchPlayer();
            case 3 -> showPlayersOnSpecificPosition();
            case 4 -> addPlayer();
            case 5 -> deletePlayer();
            case 6 -> endProgram();
            default -> printMessage("Nie ma takiej opcji do wyboru\n");
        }
    }

    private String showProgramOptions() {
        return """
                1. Wyświetl wszystkich dostępnych zawodników
                2. Szukaj zawodnika
                3. Wyświetl zawodników z danej pozycji
                4. Dodaj zawodnika do klubu
                5. Usuń zawodnika z klubu
                6. Zakończ program""";
    }

    private void showPlayers() {
        StringBuilder show = new StringBuilder();
        for (Player player : manager.getPlayers()) {
            show.append(player.getName()).append(" ").append(player.getSurname()).append(", data urodzenia: ").
                    append(player.getDateOfBirth()).append(", liczba goli: ").append(player.getNumberOfGoals()).
                    append(", pozycja: ").append(player.getPosition()).append("\n");
        }
        printMessage(show.toString());
            /*printf
            System.out.printf("%s %s, data urodzenia: %s, liczba goli: %d, pozycja: %s\n",
                    player.getName(), player.getSurname(), player.getDateOfBirth(), player.getNumberOfGoals(), player.getPosition());

            //%s - String
            //%d - liczba całkowita
            //%f - liczba dziesiętna*/
    }

    private void searchPlayer() {
        String name = readAnswer("Podaj imię: ");
        String surname = readAnswer("Podaj nazwisko: ");
        showPlayer(name, surname);
    }

    private void showPlayer(String name, String surname) {
        StringBuilder show = new StringBuilder();
        for (Player player : manager.getPlayers()) {
            if (player.getName().equalsIgnoreCase(name) && player.getSurname().equalsIgnoreCase(surname)) {
                show.append(player.getName()).append(" ").append(player.getSurname()).append(", data urodzenia: ").
                        append(player.getDateOfBirth()).append(", liczba goli: ").append(player.getNumberOfGoals()).
                        append(", pozycja: ").append(player.getPosition()).append("\n");
                printMessage(show.toString());
                return;
            }
        }
        printMessage("\nZawodnik nie występuje\n");
    }

    private void showPlayersOnSpecificPosition() {
        showPositionToChoose();
        String position = readAnswer("Podaj pozycję: ").toUpperCase();
        Position positionEnum = Position.valueOf(position);
        StringBuilder show = new StringBuilder();
        for (Player player : manager.findPlayersOnPosition(positionEnum)) {
            show.append(player.getName()).append(" ").append(player.getSurname()).append("\n");
        }
        printMessage(show.toString());
    }

    private void showPositionToChoose() {
        printMessage("""
                Pozycje możliwe do wyboru:
                N - napastnik
                POM - pomocnik
                OBR - obrońca
                BR - bramkarz""");
    }

    private void addPlayer() throws DateTimeParseException, PlayerException, InputMismatchException {
        String name = readAnswer("Podaj imię: ");
        String surname = readAnswer("Podaj nazwisko: ");
        String dateOfBirth = readAnswer("Podaj datę urodzenia [yyyy-mm-dd]: ");
        LocalDate localDate = LocalDate.parse(dateOfBirth);
        int numberOfGoals = Integer.parseInt(readAnswer("Podaj liczbę zdobytych goli w karierze: "));
        String position = readAnswer("Podaj pozycję na boisku: ");
        manager.addPlayer(name, surname, localDate, numberOfGoals, position.toUpperCase());
        printMessage("\nDodano nowego zawodnika\n");
    }

    private void deletePlayer() {
        String name = readAnswer("Podaj imię zawodnika: ");
        String surname = readAnswer("Podaj nazwisko zawodnika: ");
        manager.deletePlayer(name, surname);
        printMessage("\nUsunięto\n");
    }

    private void endProgram() {
        printMessage("\nDO WIDZENIA\n");
    }

    abstract void printMessage(String message);

    abstract String readAnswer(String question);
}
