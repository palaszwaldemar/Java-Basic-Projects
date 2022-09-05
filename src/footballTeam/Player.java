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

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
        dateOfBirth = null;
        numberOfGoals = 0;
        position = null;
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
    public boolean equals(Object o) {//check gdzie jest wykorzystana ta metdoda?
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(surname, player.surname);  //name.equals(player.name)
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }//check co to za metoda i gdzie jest wykorzystana?

    public String toCsv() {
        return String.format("%s,%s,%s,%d,%s", name, surname, dateOfBirth, numberOfGoals, position);
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
