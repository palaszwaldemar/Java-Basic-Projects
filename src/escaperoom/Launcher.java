package escaperoom;

public class Launcher {
    public static void main(String[] args) {
        Window window = new Window();
        Key key = new Key();
        Door door = new Door(key);
        Game game = new Game(window, key, door);
        game.welcome();
        game.startGame();
        game.goodbye();
    }
}
