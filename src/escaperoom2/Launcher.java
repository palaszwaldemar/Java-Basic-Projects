package escaperoom2;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        //aplikacja przygotowana do dodawania dużej ilości przedmiotów
        //aplikacja będzie miała różne pokoje z różnymi przedmiotami
        //aplikacja łatwa do przeniesienia na interfejs okienkowy
        Controller controller = new Controller();
        controller.start();
    }
}
