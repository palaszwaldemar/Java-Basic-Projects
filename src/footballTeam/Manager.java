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

    List<Player> findPlayersOnPosition(Position position) {
        return fileRepository.checkPosition(position);
    }

    void deletePlayer(String name, String surname) {
        Player toRemoveIndicator = new Player(name, surname);
        fileRepository.deletePlayerFromFile(toRemoveIndicator);
    }
}
