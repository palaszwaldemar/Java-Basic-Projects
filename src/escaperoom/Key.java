package escaperoom;

public class Key extends Item {

    public Key(String destination) {
        super("Klucz " + destination);
    }

    @Override
    Dialog use(Room room, Player player, Game game) {
        player.addItem(this);
        room.removeItem(this);
        return new Dialog("Podnosisz klucz");
    }
}
