package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRepository {


    public List<Book> downloadFile() {
        List<Book> books = new ArrayList<>();
        try {
            File file = new File("src\\library\\Ksiazki.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                books.add(mapBook(text));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (NumberFormatException e) {
            System.out.println("Błędne dane książki");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Brakujące dane");
        } catch (BookException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    private Book mapBook(String text) {
        String[] text1 = text.split(",");
        int numberOfCopies = Integer.parseInt(text1[1]);
        if (numberOfCopies < 0 || numberOfCopies > 1000) {
            throw new BookException("Niepoprawna liczba książek");
        }
        if (text1[2].length() != 17) {
            throw new BookException("Niepoprawny numer ISBN");
        }
        return new Book(text1[0], numberOfCopies, text1[2]);
    }

    void addBook(String title, int numberOfCopies, String isbn) {
        if (isbn.length() != 17) {
            throw new BookException("Niepoprawny numer ISBN");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\library\\Ksiazki.csv", true);
            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            printWriter.print("\n");//todo czy może tak być. Dodałem przejście do nowej linii, ponieważ przy dodawaniu książki dodawało ją w ostatniej używanej linii
            printWriter.print(title + "," + numberOfCopies + "," + isbn);
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
    }
}
