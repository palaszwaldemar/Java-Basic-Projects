package footballTeam;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private final Manager manager = new Manager();
    public final int END_PROGRAM = 6;

    void start() {// TODO: 24.08.2022 Porozbijałem na metody
        System.out.println("\nMANAGER DRUŻYNY PIŁKARSKIEJ\n");
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
            Scanner scanner = new Scanner(System.in);
            showProgramOptions();
            System.out.print("\nPodaj numer z menu: ");
            int choose = scanner.nextInt();
            System.out.println();
            chooseProgramOption(choose);
            return choose;
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (DateTimeParseException e) {
            System.out.println("\nBłędny format daty\n");
        } catch (PlayerException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("\nNiepoprawne dane\n");
        }
        return -1;
    }

    private void chooseProgramOption(int choose) throws FileNotFoundException {
        switch (choose) {
            case 1 -> showPlayers();
            case 2 -> searchPlayer();
            case 3 -> showPlayersOnSpecificPosition();// TODO: 24.08.2022 Dodałem metodę szukania po pozycji zawodnika
            case 4 -> addPlayer();
            case 5 -> deletePlayer();
            case 6 -> endProgram();
            default -> System.out.println("Nie ma takiej opcji do wyboru\n");
        }
    }

    private void showProgramOptions() {
        System.out.println("""
                1. Wyświetl wszystkich dostępnych zawodników
                2. Szukaj zawodnika
                3. Wyświetl zawodników z danej pozycji
                4. Dodaj zawodnika do klubu
                5. Usuń zawodnika z klubu
                6. Zakończ program""");
    }

    private void showPlayers() throws FileNotFoundException {
        for (Player player : manager.getPlayers()) {
            System.out.println(player.getName() + " " + player.getSurname() + ", data urodzenia: " + player.getDateOfBirth() +
                    ", liczba goli: " + player.getNumberOfGoals() + ", pozycja: " + player.getPosition());
        }
        System.out.println();
    }

    private void searchPlayer() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        showPlayer(name, surname);
    }

    private void showPlayer(String name, String surname) throws FileNotFoundException {
        for (Player player : manager.getPlayers()) {
            if (player.getName().equalsIgnoreCase(name) && player.getSurname().equalsIgnoreCase(surname)) {
                System.out.println("\n" + player.getName() + " " + player.getSurname() + ", data urodzenia: " + player.getDateOfBirth() +
                        ", liczba goli: " + player.getNumberOfGoals() + ", pozycja: " + player.getPosition() + "\n");
                return;
            }
        }
        System.out.println("\nZawodnik nie występuje\n");
    }

    private void showPlayersOnSpecificPosition() throws FileNotFoundException {
        showPositionToChoose();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pozycję: ");
        String position = scanner.nextLine();
        if(isCorrectEnteredPosition(position)) {
            System.out.println();
            for (Player player : manager.showPlayersOnPosition(position)) {
                System.out.println(player.getName() + " " + player.getSurname());
            }
            System.out.println();
        } else {
            System.out.println("\nNie ma takie pozycji\n");
        }
    }

    private void showPositionToChoose() {
        System.out.println("""
                Pozycje możliwe do wyboru:
                N - napastnik
                POM - pomocnik
                OBR - obrońca
                BR - bramkarz""");
    }

    private boolean isCorrectEnteredPosition(String position) {
        String[] positions = {"BR", "OBR", "POM", "N"};
        for (String pos : positions) {
            if(position.equalsIgnoreCase(pos)) {
                return true;
            }
        }
        return false;
    }

    private void addPlayer() throws DateTimeParseException, PlayerException, FileNotFoundException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.print("Podaj datę urodzenia [yyyy-mm-dd]: ");
        String dateOfBirth = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(dateOfBirth);
        System.out.print("Podaj liczbę zdobytych goli w karierze: ");
        int numberOfGoals = scanner.nextInt();
        System.out.print("Podaj pozycję na boisku: ");
        scanner.nextLine();
        String position = scanner.nextLine().toUpperCase();
        manager.addPlayer(name, surname, localDate, numberOfGoals, position);
        System.out.println("\nDodano nowego zawodnika\n");
    }

    private void deletePlayer() {
// TODO: 24.08.2022 dokończyć
    }

    private void endProgram() {
        System.out.println("\nDO WIDZENIA\n");
    }
}
