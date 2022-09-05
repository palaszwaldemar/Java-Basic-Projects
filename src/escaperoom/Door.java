package escaperoom;

public class Door extends Item {
    private final Key key;

    public Door(Key key) {
        super("Drzwi");
        this.key = key;
    }

    @Override
    Dialog use(Mediator mediator) {
        if (mediator.getPlayer().hasItem(key)){
            mediator.goToNextRoom();
            mediator.removeAllPlayersItems();
            if (mediator.isTheLasRoom()) {
                return new Dialog("Otwierasz drzwi!");
            } else {
                return new Dialog("Otwierasz drzwi. Jesteś w kolejnym pokoju.");
            }
        }
        return new Dialog("Nie masz klucza");
    }
}
