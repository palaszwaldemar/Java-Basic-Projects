package escaperoom2.practice;

import javax.swing.*;

public class SimpleGuiDemo {
    public static void main(String[] args) {
        System.out.println("Hello");
        JOptionPane.showMessageDialog(null,"Hello");
        String imie = JOptionPane.showInputDialog("Jak się nazywasz?");
        System.out.println(imie);
    }
}
