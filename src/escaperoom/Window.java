package escaperoom;

public class Window extends Item {
    private boolean isClose = true;

    public Window() {
        super("Okno");
    }

    @Override
    Dialog use(Mediator mediator) {
        if (isClose) {
            isClose = false;
            return new Dialog("Otwierasz okno");
        } else {
            isClose = true;
            return new Dialog("Zamykasz okno");
        }
    }
}
