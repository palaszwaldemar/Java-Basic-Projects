package hotelService;

import javax.swing.*;

public class ControllerGui extends Controller {
    @Override
    void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    String readAnswer(String question) {
        return JOptionPane.showInputDialog(question);
    }
}
