package hotelService;

import java.util.Scanner;

public class ControllerConsole extends Controller{
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
