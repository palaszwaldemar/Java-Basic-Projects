package footballTeam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepository {

    List<Player> downloadFile() throws FileNotFoundException {
        List<Player> players = new ArrayList<>();
        File file = new File("src\\footballTeam\\Players.csv");
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
        return new Player(infoPlayer[0], infoPlayer[1], localDate, numberOfGoals);
    }

    void addInfoPlayerToFile(String name, String surname, LocalDate dateOfBirth, int numberOFGoals) throws FileNotFoundException {
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
            FileOutputStream fileOutputStream = new FileOutputStream("src\\footballTeam\\Players.csv", true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.print("\n" + name + "," + surname + "," + dateOfBirthString + "," + numberOFGoals);
            printWriter.close();

    }
}
