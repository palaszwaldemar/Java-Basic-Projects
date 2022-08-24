package footballTeam;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepository {
    private final File file = new File("src\\footballTeam\\Players.csv");

    List<Player> downloadFile() throws FileNotFoundException {
        List<Player> players = new ArrayList<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String playerInfo = scanner.nextLine();
                players.add(mapPlayer(playerInfo));
            }
        return players;
    }

    private Player mapPlayer(String playerInfo) {
        String[] infoPlayer = playerInfo.split(",");
        LocalDate localDate = LocalDate.parse(infoPlayer[2]);
        int numberOfGoals = Integer.parseInt(infoPlayer[3]);
        return new Player(infoPlayer[0], infoPlayer[1], localDate, numberOfGoals, infoPlayer[4]);
    }

    void addInfoPlayerToFile(String name, String surname, LocalDate dateOfBirth, int numberOFGoals, String position) throws FileNotFoundException {
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
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.print("\n" + name + "," + surname + "," + dateOfBirthString + "," + numberOFGoals + "," + position);
        printWriter.close();
    }

    List<Player> checkPosition(String position) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<Player> playersOnPosition = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String playerInfo = scanner.nextLine();
            String[] infoPlayer = playerInfo.split(",");
            if (infoPlayer[4].equalsIgnoreCase(position)) {
                playersOnPosition.add(mapPlayer(playerInfo));
            }
        }
        if (playersOnPosition.isEmpty()) {
            throw new PlayerException("Nie ma zawodników na danej pozycji\n");
        }
        return playersOnPosition;
    }
}
