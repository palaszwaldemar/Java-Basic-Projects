package library;

public class Launcher {
    public static void main(String[] args) {
        Library library = new Library();
        Controller controller = new Controller(library);
        controller.start();
    }
}
