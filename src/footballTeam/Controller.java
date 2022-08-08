package footballTeam;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private final Manager manager = new Manager();

    void start() {
        System.out.println("\nMANAGER DRUŻYNY PIŁKARSKIEJ\n");
        int choose;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                showProgramOptions();
                System.out.print("\nPodaj numer z menu: ");
                choose = scanner.nextInt();
                System.out.println();
                switch (choose) {
                    case 1 -> showPlayers();
                    case 3 -> addPlayer();
                    case 4 -> endProgram();
                    default -> System.out.println("Nie ma takiej opcji do wyboru\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nProszę wprowadzić liczbę\n");
                choose = 5;

            }
        } while (choose != 4);
    }

    private void showProgramOptions() {
        System.out.println("""
                1. Wyświetl wszystkich dostępnych zawodników
                2. Usuń zawodnika z klubu
                3. Dodaj zawodnika do klubu
                4. Zakończ program""");
    }

    private void showPlayers() {
        for (Player player : manager.getPlayers()) {
            System.out.println(player.getName() + " " + player.getSurname() + ", data urodzenia: " + player.getDateOfBirth() +
                    ", liczba goli: " + player.getNumberOfGoals());
        }
        System.out.println();
    }

    private void addPlayer() {
        try {
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
            manager.addPlayer(name, surname, localDate, numberOfGoals);
        } catch (DateTimeParseException e) {
            System.out.println("\nBłędny format daty\n");
        }

    }

    private void endProgram() {
        System.out.println("\nDO WIDZENIA\n");
    }
}
