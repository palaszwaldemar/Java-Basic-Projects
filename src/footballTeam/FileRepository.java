package footballTeam;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepository {
    private final File file = new File("src\\footballTeam\\Players.csv");

    private Scanner createScanner() {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new PlayerException("Plik nie istnieje\n");
        }
    }

    List<Player> downloadFile() {
        List<Player> players = new ArrayList<>();
        Scanner scanner = createScanner();
        while (scanner.hasNextLine()) {
            String playerInfo = scanner.nextLine();
            players.add(mapPlayer(playerInfo));
        }
        scanner.close();
        return players;
    }

    private Player mapPlayer(String playerInfo) {
        String[] infoPlayer = playerInfo.split(",");
        LocalDate localDate = LocalDate.parse(infoPlayer[2]);
        int numberOfGoals = Integer.parseInt(infoPlayer[3]);
        Position position = Position.valueOf(infoPlayer[4]);
        return new Player(infoPlayer[0], infoPlayer[1], localDate, numberOfGoals, position);
    }

    void addInfoPlayerToFile(String name, String surname, LocalDate dateOfBirth, int numberOFGoals, String position) {
        String dateOfBirthString = dateOfBirth.toString();
        long age = dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS);
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new PlayerException("\nData urodzenia nie może być z przyszłości\n");
        }
        if (age < 18) {
            throw new PlayerException("\nZawodnik musi być pełnoletni\n");
        }
        if (numberOFGoals < 0) {
            throw new PlayerException("\nLiczba goli nie może być mniejsza od 0\n");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.println(name + "," + surname + "," + dateOfBirthString + "," + numberOFGoals + "," + position);
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new PlayerException("Problem z zapisem do pliku");
        }
    }

    List<Player> checkPosition(Position position) {
        List<Player> playersOnPosition = new ArrayList<>();
        Scanner scanner = createScanner();
        while (scanner.hasNextLine()) {
            String playerInfo = scanner.nextLine();
            String[] infoPlayer = playerInfo.split(",");
            if (infoPlayer[4].equalsIgnoreCase(position.name())) {
                playersOnPosition.add(mapPlayer(playerInfo));
            }
        }
        if (playersOnPosition.isEmpty()) {
            throw new PlayerException("Nie ma zawodników na danej pozycji\n");
        }
        scanner.close();
        return playersOnPosition;
    }

    boolean checkCorrectnessAddedLines(String descriptionOfPlayer, PrintWriter printWriterOfTemporaryFile, boolean correctnessAddedLines) {
        if (!correctnessAddedLines) {//check dodany warunek sprawdzający w celu poprwanego przechodzenia printwritera do nowej linii
            printWriterOfTemporaryFile.print(descriptionOfPlayer);
        } else {
            printWriterOfTemporaryFile.print("\n" + descriptionOfPlayer);
        }
        return true;
    }

    void copyLinesToTemporaryFile(Scanner mainFileScanner, PrintWriter printWriterOfTemporaryFile, String name, String surname) {
        boolean correctnessAddedLines = false;
        while (mainFileScanner.hasNextLine()) {
            String descriptionOfPlayer = mainFileScanner.nextLine();
            String[] line = descriptionOfPlayer.split(",");
            if (!(line[0].equalsIgnoreCase(name) && line[1].equalsIgnoreCase(surname))) {
                correctnessAddedLines = checkCorrectnessAddedLines(descriptionOfPlayer, printWriterOfTemporaryFile, correctnessAddedLines);
            }
        }
    }

    void deletePlayerFromFile(String name, String surname) {
        File temporaryFile = new File("src\\footballTeam\\Players1.csv");
        try {
            Scanner mainFileScanner = createScanner();
            FileOutputStream fileOutputStreamOfTemporaryFile = new FileOutputStream(temporaryFile, true);
            PrintWriter printWriterOfTemporaryFile = new PrintWriter(fileOutputStreamOfTemporaryFile);
            copyLinesToTemporaryFile(mainFileScanner, printWriterOfTemporaryFile, name, surname);
            mainFileScanner.close();
            if (!file.delete()) {
                throw new PlayerException("Błąd w usuwaniu zawodnika");
            }
            printWriterOfTemporaryFile.close();
            if (!temporaryFile.renameTo(new File("src\\footballTeam\\Players.csv"))) {
                throw new PlayerException("Błąd w usuwaniu zawodnika");
            }
        } catch (FileNotFoundException e) {
            throw new PlayerException("Nie znaleziono pliku");
        }
    }
}
