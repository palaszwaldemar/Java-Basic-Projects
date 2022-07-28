package hotelService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Guest {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;

    public Guest(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isAdult() {
        return dateOfBirth.until(LocalDate.now(), ChronoUnit.YEARS) >= 18;
    }
}
