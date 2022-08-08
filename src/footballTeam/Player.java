package footballTeam;

import java.time.LocalDate;

public class Player {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final int numberOfGoals;

    public Player(String name, String surname, LocalDate dateOfBirth, int numberOfGoals) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.numberOfGoals = numberOfGoals;
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
