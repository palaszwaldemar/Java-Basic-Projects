package escaperoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    private final List<Room> rooms;
    private final Player player = new Player();
    private boolean gameEnd;

    public Game() {
        RoomsFactory roomsFactory = new RoomsFactory();
        rooms = roomsFactory.createRooms();
    }

    public List<Item> getItems() {
        return getActualRoom().getItems();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Player getPlayer() {
        return player;
    }

    Dialog useItem(String choose) {
        Optional<Item> itemOptional = getActualRoom().findItemByName(choose);
        if (itemOptional.isPresent()) {
            return itemOptional.get().use(new Mediator(this, player, getActualRoom()));
        }
        return new Dialog("Nie ma takiego przedmiotu");
    }

    public void removeActualRoom() {
        rooms.remove(0);
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    void checkIfGameHasRooms() {
        if (rooms.isEmpty()) {
            gameEnd = true;
        }
    }

    List<String> getOwnedItemNames() {
        List<String> names = new ArrayList<>();
        for (Item item : player.getItems()) {
            names.add(item.getName());
        }
        return names;
    }

    private Room getActualRoom() {
        return rooms.get(0);
    }
}
