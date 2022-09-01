package escaperoom;

public class Mediator {
    private final Game game;
    private final Player player;
    private final Room room;

    public Mediator(Game game, Player player, Room room) {
        this.game = game;
        this.player = player;
        this.room = room;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getRoom() {
        return room;
    }

    public void goToNextRoom() {
        game.removeActualRoom();
    }

    void removeAllPlayersItems() {
        player.clearAll();
    }

    boolean areMoreRooms() {
        return game.getRooms().isEmpty();
    }
}
