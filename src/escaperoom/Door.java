package escaperoom;

public class Door {
    private boolean isOpen;
    private Key key;

    public Door(boolean isOpen, Key key) {
        this.isOpen = isOpen;
        this.key = key;
    }

    void useDoor() {
        if (key.isInHand()) {
            System.out.println("Drzwi zostaly otwarte");
            isOpen = true;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}
