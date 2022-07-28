package escaperoom2;

public class Desk extends Item{
    private final Key keyToOpenDesk;
    private final Key keyToOpenDoor;

    public Desk(Key keyToOpenDesk, Key keyToOpenDoor) {
        super("Biurko");
        this.keyToOpenDesk = keyToOpenDesk;
        this.keyToOpenDoor = keyToOpenDoor;
    }

    @Override
    String use(Room room, Player player, Game game) {
        if (player.hasItem(keyToOpenDesk)) {
            player.addItem(keyToOpenDoor);
            return "Znajdujesz klucz do drzwi";
        }
        return "Nie masz klucza do biurka";
    }
}
