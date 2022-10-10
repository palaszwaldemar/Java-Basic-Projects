package zbijak;

public class Launcher {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
// - wejscie na pole innego gracza powoduje zbicie
// - gra kończy się jak gracz zbije wszystkich lub sam zostanie zbity
// - NPC nie mogą być na tych samych polach
    }
}
