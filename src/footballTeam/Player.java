package footballTeam;

import java.time.LocalDate;
import java.util.Objects;

public class Player {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final int numberOfGoals;
    private final Position position;

    public Player(String name, String surname, LocalDate dateOfBirth, int numberOfGoals, Position position) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberOfGoals = numberOfGoals;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfGoals=" + numberOfGoals +
                '}';
    }
}
