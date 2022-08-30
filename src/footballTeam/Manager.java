package footballTeam;

import java.time.LocalDate;
import java.util.List;

public class Manager {
    private final FileRepository fileRepository = new FileRepository();

    List<Player> getPlayers() {
            return fileRepository.downloadFile();
    }

    void addPlayer(String name, String surname, LocalDate dateOfBirth, int numberOfGoals, String position) {
        fileRepository.addInfoPlayerToFile(name, surname, dateOfBirth, numberOfGoals, position);
    }

    List<Player> findPlayersOnPosition(Position position){
        return fileRepository.checkPosition(position);
    }

    String deletePlayer(String name, String surname) {
        List<Player> players = fileRepository.downloadFile();
        for (Player player : players) {
            if (name.equalsIgnoreCase(player.getName()) && surname.equalsIgnoreCase(player.getSurname())) {
                fileRepository.replaceFiles(name, surname);
                return "\nZawodnik został usunięty\n";
            }
        }
        return "\nNie ma takiego zawodnika\n";
    }
}
