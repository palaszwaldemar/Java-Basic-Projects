package escaperoom;

public class Door {
    private boolean isOpen;
    private Key key;

    public Door(Key key) {
        this.key = key;
    }

    void useDoor() {
        if (key.isInHand()) {
            System.out.println("Drzwi zostaly otwarte");
            isOpen = true;
        } else {
            System.out.println("Nie znalazles jeszcze klucza aby otworzyc te drzwi");
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}
