package footballTeam;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private final Manager manager = new Manager();

    void start() {// TODO: 24.08.2022 Porozbijałem na metody
        System.out.println("\nMANAGER DRUŻYNY PIŁKARSKIEJ\n");
        doWhile();
    }

    private void doWhile() {// TODO: 24.08.2022 Nie wiem jak nazwać tę metodę
        int choose;
        do {
            choose = tryCatch();
        } while (choose != 5);
    }

    private int tryCatch() {// TODO: 24.08.2022 Nie wiem jak nazwać tę metodę
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
            case 3 -> addPlayer();
            case 4 -> deletePlayer();
            case 5 -> endProgram();
            default -> System.out.println("Nie ma takiej opcji do wyboru\n");
        }
    }

    private void showProgramOptions() {
        System.out.println("""
                1. Wyświetl wszystkich dostępnych zawodników
                2. Szukaj zawodnika
                3. Dodaj zawodnika do klubu
                4. Usuń zawodnika z klubu
                5. Zakończ program""");
    }

    private void showPlayers() throws FileNotFoundException {
        for (Player player : manager.getPlayers()) {
            System.out.println(player.getName() + " " + player.getSurname() + ", data urodzenia: " + player.getDateOfBirth() +
                    ", liczba goli: " + player.getNumberOfGoals());
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
                        ", liczba goli: " + player.getNumberOfGoals() + "\n");
                return;
            }
        }
        System.out.println("\nZawodnik nie występuje\n");
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
        manager.addPlayer(name, surname, localDate, numberOfGoals);
        System.out.println("\nDodano nowego zawodnika\n");
    }

    private void deletePlayer() {

    }

    private void endProgram() {
        System.out.println("\nDO WIDZENIA\n");
    }
}
