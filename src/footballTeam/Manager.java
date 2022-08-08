package footballTeam;

import java.time.LocalDate;
import java.util.List;

public class Manager {
    private final FileRepository fileRepository = new FileRepository();

    List<Player> getPlayers() {
        return fileRepository.downloadFile();
    }

    void addPlayer(String name, String surname, LocalDate dateOfBirth, int numberOfGoals) {
        try {
            fileRepository.addInfoPlayerToFile(name, surname, dateOfBirth, numberOfGoals);
        } catch (PlayerException e) {
            System.out.println("Liczba goli nie może być mniejsza od 0");
        } catch (RuntimeException e) {
            System.out.println("Zawodnik musi być pełnoletni");
        }
    }
}
