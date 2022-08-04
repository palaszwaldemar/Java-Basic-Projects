package library;

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
            choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1 -> showAvailableBooks();
                case 2 -> searchBookFromName();
                case 3 -> addBook();
                case 4 -> System.out.println("Koniec programu");
                default -> System.out.println("Nie ma takiej opcji do wyboru");

            }
        } while (choose != 4);
    }

    void showAvailableOptions() {
        System.out.println("""
                1. Pokaż dostępne książki
                2. Szukaj książki po nazwie
                3. Dodaj książkę do biblioteki\n""");
    }

    void showAvailableBooks() {
        for (int i = 0; i < library.getBooks().size(); i++) {
            System.out.println(i + 1 + ". " + library.getBooks().get(i));
        }
        System.out.println();
    }

    void searchBookFromName() {
        System.out.print("Podaj nazwę książki: ");
        String name = scanner.nextLine();
        for (Book book : library.getBooks()) {
            if (book.getTitle().contains(name)) {
                System.out.println(book + "\n");
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
        library.getFileReposytory().addBook(title, numberOfCopies, isbn);
        Book book = new Book(title,numberOfCopies, isbn);
        library.getBooks().add(book);
    }
}
