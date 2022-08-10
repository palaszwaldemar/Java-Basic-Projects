package escaperoom;

public class Door extends Item {
    private final Key key;

    public Door(Key key) {
        super("Drzwi");
        this.key = key;
    }


    @Override
    String use(Room room, Player player, Game game) {
        if (player.hasItem(key)){
            game.getRooms().remove(0);
            game.getPlayer().getItems().clear();// TODO: 10.08.2022 dodałem czyszczenie "plecaka" po przejsciu do innego pokoju
            if (game.getRooms().isEmpty()) {
                return "Otwierasz drzwi!";
            } else {
                return "Otwierasz drzwi. Jesteś w kolejnym pokoju.";
            }
        }
        return "Nie masz klucza";
    }
}
