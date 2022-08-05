package escaperoom;


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
        System.out.print(question);
        return scanner.nextLine();
    }
}
