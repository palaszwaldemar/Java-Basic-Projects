package footballTeam;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        Controller controller = new ControllerConsole();
        if (args.length >= 1 && args[0].equals("GUI")) {
            controller = new ControllerGui();
        }
        controller.start();
    }
}
