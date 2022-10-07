package library;

public class BookException extends RuntimeException {//klasa RuntimeExcepion wyłącza obowiązek obsługi wyjątku

    public BookException(String message) {
        super(message);
    }
}
