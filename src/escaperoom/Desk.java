package escaperoom;

public class Desk extends Item{
    private final Key keyToOpenDesk;
    private final Key keyToOpenDoor;
    private boolean wasUse;
    private boolean isOpen;

    public Desk(Key keyToOpenDesk, Key keyToOpenDoor) {
        super("Biurko");
        this.keyToOpenDesk = keyToOpenDesk;
        this.keyToOpenDoor = keyToOpenDoor;
    }

    @Override
    String use(Room room, Player player, Game game) {
        if (wasUse) {
            if(!isOpen) {
                isOpen = true;
                return "Otwierasz biurko";
            } else {
                isOpen = false;
                return "Zamykasz biurko";
            }
        }
        if (player.hasItem(keyToOpenDesk)) {
            player.addItem(keyToOpenDoor);
            isOpen = true;
            wasUse = true;
            return "Znajdujesz klucz do drzwi";
        }
        return "Nie masz klucza do biurka";
    }
}
