package escaperoom;

public class Mediator {
    private Game game;
    private Player player;
    private Room room;

    public Mediator(Game game, Player player, Room room) {
        this.game = game;
        this.player = player;
        this.room = room;
    }

    public Game getGame() {
        return game;
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
}
