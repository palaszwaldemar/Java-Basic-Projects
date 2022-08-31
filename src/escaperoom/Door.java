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
            mediator.goToNextRoom();// TODO: 25.08.2022 poprawic
            mediator.getGame().removeAllPlayerItems();
            if (mediator.getGame().getRooms().isEmpty()) {
                return new Dialog("Otwierasz drzwi!");
            } else {
                return new Dialog("Otwierasz drzwi. Jesteś w kolejnym pokoju.");
            }
        }
        return new Dialog("Nie masz klucza");// TODO: 31.08.2022 test
        // CHECK:  test
    }
}
