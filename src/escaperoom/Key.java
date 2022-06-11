package escaperoom;

public class Key {
    private boolean inHand = false;

    void takeKey() {
        inHand = true;
    }

    public boolean isInHand() {
        return inHand;
    }
}
