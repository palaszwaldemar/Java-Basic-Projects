package escaperoom;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Room> rooms;
    private final Player player = new Player();
    private boolean gameEnd;
    private final RoomsFactory roomsFactory = new RoomsFactory();//todo obiekt wyciągniety z konstruktora dla możliwości wprowadzania kodu przez użytkownika

    public Game() {
        rooms = roomsFactory.createRooms();
    }

    public RoomsFactory getRoomsFactory() {
        return roomsFactory;
    }

    public List<Item> getItems() {
        return rooms.get(0).getItems();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Player getPlayer() {
        return player;
    }

    String useItem(String choose) {
        for (Item item : rooms.get(0).getItems()) {
            if(item.getName().equalsIgnoreCase(choose)) {
               return item.use(rooms.get(0), player, this);
            }
        }
        return "Nie ma takiego przedmiotu";
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
        for (Item item: player.getItems()) {
            names.add(item.getName());
        }
        return names;
    }
}
