package footballTeam;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class Manager {
    private final FileRepository fileRepository = new FileRepository();

    List<Player> getPlayers() throws FileNotFoundException {
            return fileRepository.downloadFile();
    }

    void addPlayer(String name, String surname, LocalDate dateOfBirth, int numberOfGoals, String position) throws PlayerException, FileNotFoundException {
        fileRepository.addInfoPlayerToFile(name, surname, dateOfBirth, numberOfGoals, position);
    }

    List<Player> showPlayersOnPosition(String position) throws FileNotFoundException {
        return fileRepository.checkPosition(position);
    }
}
