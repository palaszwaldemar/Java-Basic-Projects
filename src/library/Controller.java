package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private final Library library;
    private final Scanner scanner = new Scanner(System.in);

    public Controller(Library library) {
        this.library = library;
    }

    void start() {
        int choose;
        System.out.println("\nWITAMY W BIBLIOTECE\n");
        do {
            showAvailableOptions();
            System.out.print("Wybierz opcję: ");
            try {//todo czy tak może być?
                choose = scanner.nextInt();
            } catch (InputMismatchException e) {
                choose = 5;//todo taki miałem pomysł na wypadek wprowadzenia liter przy wyborze opcji. Pozwala to na przejscie w switch do default.
            }
            scanner.nextLine();

            switch (choose) {
                case 1 -> showAvailableBooks();
                case 2 -> searchBookFromName();
                case 3 -> addBook();
                case 4 -> System.out.println("\nDO ZOBACZENIA");
                default -> System.out.println("\nNie ma takiej opcji do wyboru\n");

            }
        } while (choose != 4);
    }

    void showAvailableOptions() {
        System.out.println("""
                1. Pokaż dostępne książki
                2. Szukaj książki po nazwie
                3. Dodaj książkę do biblioteki
                4. Koniec programu""");
        System.out.println();
    }

    void showAvailableBooks() {
        for (int i = 0; i < library.getBooks().size(); i++) {
            Book book = library.getBooks().get(i);
            System.out.println(i + 1 + ". \tTytuł: " + book.getTitle() +
                    "\n\tliczba kopii: " + book.getNumberOfCopies() +
                    "\n\tISBN: " + book.getIsbn());
        }
        System.out.println();
    }

    void searchBookFromName() {
        System.out.print("Podaj nazwę książki: ");
        String name = scanner.nextLine();
        for (Book book : library.getBooks()) {
            if (book.getTitle().contains(name)) {
                System.out.println("Tytuł: " + book.getTitle() +
                "\nliczba kopii: " + book.getNumberOfCopies() +
                        "\nISBN: " + book.getIsbn() + "\n");
            }
        }
    }

    void addBook() {
        System.out.println("\nDodanie nowej książki");
        System.out.print("Podaj tytuł książki: ");
        String title = scanner.nextLine();
        System.out.print("Podaj liczbę kopii: ");
        int numberOfCopies = scanner.nextInt();
        System.out.print("Podaj numer ISBN: ");
        String isbn = scanner.next();
        try {//todo nie wiem czy tutaj mogę obsłużyć wyjątek
            library.getFileReposytory().addBook(title, numberOfCopies, isbn);
        } catch (BookException e) {
            System.out.println("Niepoprawny numer ISBN");
        }
        Book book = new Book(title,numberOfCopies, isbn);
        library.getBooks().add(book);
    }
}
