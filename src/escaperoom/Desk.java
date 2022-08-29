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
    Dialog use(Mediator mediator) {
        if (wasUse) {
            if(!isOpen) {
                isOpen = true;
                return new Dialog("Otwierasz biurko");
            } else {
                isOpen = false;
                return new Dialog("Zamykasz biurko");
            }
        }
        if (mediator.getPlayer().hasItem(keyToOpenDesk)) {
            mediator.getPlayer().addItem(keyToOpenDoor);
            isOpen = true;
            wasUse = true;
            return new Dialog("Znajdujesz klucz do drzwi");
        }
        return new Dialog("Nie masz klucza do biurka");
    }
}
