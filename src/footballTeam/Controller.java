package footballTeam;// TODO: 09.08.2022 dodałem obsługę wszystkich wyjątków do klasy Controler. Czy tak może być? 

import java.io.FileNotFoundException;
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
            } catch (InputMismatchException e) {
                choose = 5;
            }
            System.out.println();
            switch (choose) {
                case 1 -> showPlayers();
                case 2 -> addPlayer();
                case 3 -> endProgram();
                default -> System.out.println("Nie ma takiej opcji do wyboru\n");
            }
        } while (choose != 3);
    }

    private void showProgramOptions() {
        System.out.println("""
                1. Wyświetl wszystkich dostępnych zawodników
                2. Dodaj zawodnika do klubu
                3. Zakończ program""");
    }

    private void showPlayers() {
        try {
            for (Player player : manager.getPlayers()) {
                System.out.println(player.getName() + " " + player.getSurname() + ", data urodzenia: " + player.getDateOfBirth() +
                        ", liczba goli: " + player.getNumberOfGoals());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
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
            System.out.println("Dodano nowego zawodnika\n");
        } catch (DateTimeParseException e) {
            System.out.println("\nBłędny format daty\n");
        } catch (PlayerException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (InputMismatchException e) {
            System.out.println("Liczba niepoprawna");
        }
    }

    private void endProgram() {
        System.out.println("\nDO WIDZENIA\n");
    }
}
