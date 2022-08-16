package escaperoom;

public class Door extends Item {
    private final Key key;

    public Door(Key key) {
        super("Drzwi");
        this.key = key;
    }


    @Override
    Dialog use(Room room, Player player, Game game) {
        if (player.hasItem(key)){
            game.getRooms().remove(0);
            game.removeAllPlayerItems();
            if (game.getRooms().isEmpty()) {
                return new Dialog("Otwierasz drzwi!");
            } else {
                return new Dialog("Otwierasz drzwi. Jesteś w kolejnym pokoju.");
            }
        }
        return new Dialog("Nie masz klucza");
    }
}
