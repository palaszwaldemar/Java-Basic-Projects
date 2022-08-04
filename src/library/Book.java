package library;

public class Book {
    private final String title;
    private final int numberOfCopies;
    private final String isbn;

    public Book(String title, int numberOfCopies, String isbn) {
        this.title = title;
        this.numberOfCopies = numberOfCopies;
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfCopies=" + numberOfCopies +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
