package footballTeam;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepository {
    private static final String PATH_PREFIX = "src\\footballTeam\\";
    private final File file = new File(PATH_PREFIX + "Players.csv");


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
            throw new PlayerException("\nData urodzenia nie może być z przyszłości\n\n");
        }
        if (age < 18) {
            throw new PlayerException("\nZawodnik musi być pełnoletni\n\n");
        }
        if (numberOFGoals < 0) {
            throw new PlayerException("\nLiczba goli nie może być mniejsza od 0\n\n");
        }
        if (!(position.equalsIgnoreCase("N") || position.equalsIgnoreCase("POM")
                || position.equalsIgnoreCase("OBR") || position.equalsIgnoreCase("BR"))) {
            throw new IllegalArgumentException();
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

    void deletePlayerFromFile(Player playerToRemove) {
        List<Player> players = downloadFile();
        boolean removed = players.remove(playerToRemove);
        if (!removed) {
            throw new PlayerException("\nNie było takiego zawodnika\n");
        }
        saveAllPlayers(players);
    }

    private void saveAllPlayers(List<Player> players) {
        try {
            PrintWriter out = new PrintWriter(file);
            for (Player player : players) {
                out.println(player.toCsv());
            }
            out.close();
        } catch (FileNotFoundException e) {
            throw new PlayerException("Błąd w zapisie zawodników");
        }
    }
}
