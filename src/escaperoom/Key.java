package escaperoom;

public class Key extends Item {

    public Key(String destination) {
        super("Klucz " + destination);
    }

    @Override
    Dialog use(Mediator mediator) {
        mediator.getPlayer().addItem(this);
        mediator.getRoom().removeItem(this);
        return new Dialog("Podnosisz klucz");
    }
}
