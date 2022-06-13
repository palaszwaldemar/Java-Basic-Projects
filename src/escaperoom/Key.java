package escaperoom;

public class Key {
    private boolean inHand;

    void takeKey() {
            inHand = true;
            System.out.println("Podnosisz klucz");
    }

    public boolean isInHand() {
        return inHand;
    }
}
