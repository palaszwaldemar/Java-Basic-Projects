package hotelService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public abstract class Controller {
    private final HotelService hotelService = new HotelService();
    private static final int CLOSE_PROGRAM = 8;

    void start() {
        printMessage("\nWITAMY W NASZYM HOTELU\n");
        interactWithMenu();
    }

    private void interactWithMenu() {
        int choose;
        do {
            choose = handleDecision();
        } while (choose != CLOSE_PROGRAM);
    }

    private int handleDecision() {
        try {
            int choose = Integer.parseInt(readAnswer(showAvailableOptions() + "Twój wybór: "));
            chooseOption(choose);
            return choose;
        } catch (InputMismatchException e) {
            printMessage("\nPodano litery zamiast liczby\n");
        } catch (HotelException e) {
            printMessage(e.getMessage());
        } catch (DateTimeParseException e) {
            printMessage("\nBłędny format daty\n");
        } catch (NumberFormatException e) {
            printMessage("\nProszę podać liczbę\n");
        }
        return -1;
    }

    private void chooseOption(int choose) {
        switch (choose) {
            case 1 -> showAllRooms();
            case 2 -> showAvailableRooms();
            case 3 -> showUnavailableRooms();
            case 4 -> showDirtyRooms();
            case 5 -> cleanRoom();
            case 6 -> checkIn();
            case 7 -> checkOut();
            case 8 -> endProgram();
            default -> printMessage("\nNie ma takiej opcji do wyboru");
        }
    }

    private String showAvailableOptions() {
        return ("""
                1. Wyświetl listę pokoi
                2. Wyświetl listę dostępnych pokoi
                3. Wyświetl listę zajętych pokoi
                4. Wyświetl listę pokoi do posprzątania
                5. Posprzątaj pokój
                6. Zarezerwuj pokój
                7. Zwolnij pokój
                8. Zakończ program""");
    }

    private void showAllRooms() {
        String status;
        StringBuilder show = new StringBuilder();
        for (Room room : hotelService.allRooms()) {
            if (room.isAvailable()) {
                status = "wolny";
            } else {
                status = "zajęty";
            }
            show.append("Pokój nr: ").append(room.getNumberOfRoom()).append(" \tstatus: ").append(status).
                    append(" \t   ilość miejsc: ").append(room.getHowManyPersonCanCheckIn()).append("\n");
        }
        printMessage(show.toString());
    }

    private void showAvailableRooms() {
        StringBuilder show = new StringBuilder();
        for (Room room : hotelService.availableRooms()) {
            show.append("Pokój nr: ").append(room.getNumberOfRoom()).append("\n");
        }
        printMessage(show.toString());
    }

    private void showUnavailableRooms() {
        StringBuilder show  = new StringBuilder();
        for (Room room : hotelService.unavailableRooms()) {
            show.append("Pokój nr: ").append(room.getNumberOfRoom()).append("\t data wymeldowania: ").
                    append(room.getCheckOutDate()).append("\n");
        }
        printMessage(show.toString());
    }

    private void showDirtyRooms() {
        StringBuilder show = new StringBuilder();
        for (Room room : hotelService.dirtyRooms()) {
            show.append("\nPokój nr: ").append(room.getNumberOfRoom()).append("\n");
        }
        printMessage(show.toString());
    }

    private void cleanRoom() {
        int numberOfRoomToClean = Integer.parseInt(readAnswer("Podaj numer pokoju do posprzątania: "));
        printMessage(hotelService.cleanRoom(numberOfRoomToClean));
    }

    private List<Guest> createListOfGuests(int numberOfGuests) {
        List<Guest> guests = new ArrayList<>();
        for (int i = 0; i < numberOfGuests; i++) {
            String name = readAnswer("Podaj imię " + (i + 1) + " osoby: ");
            String surname = readAnswer("Podaj nazwisko " + (i + 1) + " osoby: ");
            String dateOfBirth = readAnswer("Podaj datę urodzenia " + (i + 1) + " osoby [rrrr-mm-dd]: ");
            LocalDate localDate = LocalDate.parse(dateOfBirth);
            guests.add(new Guest(name, surname, localDate));
        }
        return guests;
    }

    private void checkIn() {
        int numberOfRoomToCheckIn = Integer.parseInt(readAnswer("Podaj numer pokoju do rezerwacji: "));
        int numberOfGuests = Integer.parseInt(readAnswer("Podaj ile osób będzie meldowanych: "));
        if (!hotelService.enoughPlaces(numberOfGuests, numberOfRoomToCheckIn)) {
            throw new HotelException("\nPokój zbyt mały dla takiej liczby osób\n");
        }
        String checkOutDate = readAnswer("Podaj datę wymeldowania [rrrr-mm-dd]: ");
        LocalDate localDate = LocalDate.parse(checkOutDate);
        if (localDate.isBefore(LocalDate.now())) {
            throw new HotelException("\nData musi być póżniejsza niż " + LocalDate.now() + "\n");
        }
        List<Guest> guests = createListOfGuests(numberOfGuests);
        printMessage(hotelService.bookRoom(numberOfRoomToCheckIn, guests, localDate));
    }

    private void checkOut() {
        int numberOfRoomToCheckOut = Integer.parseInt(readAnswer("Podaj numer pokoju do wymeldowania: "));
        printMessage(hotelService.unBookRoom(numberOfRoomToCheckOut));
    }

    private void endProgram() {
        printMessage("\nDO WIDZENIA");
    }

    abstract void printMessage(String message);

    abstract String readAnswer(String question);
}
