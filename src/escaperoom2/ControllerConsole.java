package escaperoom2;


import java.util.Scanner;

//tylko tutaj sout i scanner
public class ControllerConsole extends Controller {

    @Override
    void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    String readAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        return scanner.next();
    }
}
