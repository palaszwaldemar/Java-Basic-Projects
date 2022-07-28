package escaperoom2;

public class Window extends Item {
    private boolean isClose = true;

    public Window() {
        super("Okno");
    }

    @Override
    String use(Room room, Player player, Game game) {
        if (isClose) {
            isClose = false;
            return "Otwierasz okno";
        } else {
            isClose = true;
            return "Zamykasz okno";
        }
    }
}
