package escaperoom2;
import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        //aplikacja przygotowana do dodawania dużej ilości przedmiotów
        //aplikacja będzie miała różne pokoje z różnymi przedmiotami
        //aplikacja łatwa do przeniesienia na interfejs okienkowy
        System.out.println(Arrays.toString(args));
        Controller controller = new ControllerConsole();
        if (args.length >= 1 && args[0].equals("GUI")) {
            controller = new ControllerGui();
        }
        controller.start();
    }
}
