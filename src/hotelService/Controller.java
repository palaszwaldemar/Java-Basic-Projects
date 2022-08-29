package hotelService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final HotelService hotelService = new HotelService();
    private static final int CLOSE_PROGRAM = 8;

    void start() {
        System.out.println("\nWITAMY W NASZYM HOTELU\n");
        System.out.println("Proszę wybrać numer opcji:");
        interactWithMenu();
    }

    private void interactWithMenu() {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            showAvailableOptions();
            System.out.print("Twój wybór: ");
            choose = handleDecision(scanner);
        } while (choose != CLOSE_PROGRAM);
    }

    private int handleDecision(Scanner scanner) {
        try {
            int choose = scanner.nextInt();
            chooseOption(choose);
            System.out.println();
            return choose;
        } catch (InputMismatchException e) {
            System.out.println("\nPodano litery zamiast liczby\n");
            scanner.nextLine();
        } catch (HotelException e) {
            System.out.println(e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("\nBłędny format daty\n");
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
            default -> System.out.println("\nNie ma takiej opcji do wyboru");
        }
    }

    private void showAvailableOptions() {
        System.out.println("""
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
        System.out.println();
        for (Room room : hotelService.allRooms()) {
            if (room.isAvailable()) {
                status = "wolny";
            } else {
                status = "zajęty";
            }
            System.out.println("Pokój nr: " + room.getNumberOfRoom() + " \tstatus: "
                    + status + " \t   ilość miejsc: "
                    + room.getHowManyPersonCanCheckIn());
        }
    }

    private void showAvailableRooms() {
        System.out.println();
        for (Room room : hotelService.availableRooms()) {
            System.out.println("Pokój nr: " + room.getNumberOfRoom());
        }
    }

    private void showUnavailableRooms() {
        System.out.println();
        for (Room room : hotelService.unavailableRooms()) {
            System.out.println("Pokój nr: " + room.getNumberOfRoom()
                    + "\tdata wymeldowania: " + room.getCheckOutDate());
        }
    }

    private void showDirtyRooms() {
        for (Room room : hotelService.dirtyRooms()) {
            System.out.println("\nPokój nr: " + room.getNumberOfRoom());
        }
    }

    private void cleanRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj numer pokoju do posprzątania: ");
        int numberOfRoomToClean = scanner.nextInt();
        System.out.println(hotelService.cleanRoom(numberOfRoomToClean));
    }

    private List<Guest> createListOfGuests(int numberOfGuests) {
        List<Guest> guests = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfGuests; i++) {
            System.out.print("Podaj imię " + (i + 1) + " osoby: ");
            String name = scanner.next();
            System.out.print("Podaj nazwisko " + (i + 1) + " osoby: ");
            String surname = scanner.next();
            System.out.print("Podaj datę urodzenia " + (i + 1) + " osoby [rrrr-mm-dd]: ");
            String dateOfBirth = scanner.next();
            LocalDate localDate = LocalDate.parse(dateOfBirth);
            guests.add(new Guest(name, surname, localDate));
            System.out.println();
        }
        return guests;
    }

    private void checkIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj numer pokoju do rezerwacji: ");
        int numberOfRoomToCheckIn = scanner.nextInt();
        System.out.print("Podaj ile osób będzie meldowanych: ");
        int numberOfGuests = scanner.nextInt();
        if (!hotelService.enoughPlaces(numberOfGuests, numberOfRoomToCheckIn)) {
            throw new HotelException("\nPokój zbyt mały dla takiej liczby osób\n");
        }
        System.out.print("Podaj datę wymeldowania [rrrr-mm-dd]: ");
        String checkOutDate = scanner.next();
        LocalDate localDate = LocalDate.parse(checkOutDate);
        if (localDate.isBefore(LocalDate.now())) {
            throw new HotelException("\nData musi być póżniejsza niż " + LocalDate.now() + "\n");
        }
        List<Guest> guests = createListOfGuests(numberOfGuests);
        System.out.println(hotelService.bookRoom(numberOfRoomToCheckIn, guests, localDate));
    }


    private void checkOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj numer pokoju do wymeldowania: ");
        int numberOfRoomToCheckOut = scanner.nextInt();
        System.out.println(hotelService.unBookRoom(numberOfRoomToCheckOut));
    }

    private void endProgram() {
        System.out.println("\nDO WIDZENIA");
    }
}
