package escaperoom;

import java.util.ArrayList;
import java.util.List;

public class RoomsFactory {
    private Code code;//todo dodane dla możliwości wprowadzania kodu przez użytkownika

    public Code getCodeCreateWithCreateRoom() {
        return code;
    }

    List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(createFirstRoom());
        rooms.add(createSecondRoom());
        return rooms;
    }

    private Room createFirstRoom() {
        List<Item> itemsOfFirstRoom = new ArrayList<>();
        Key key1 = new Key("do drzwi");
        itemsOfFirstRoom.add(key1);
        itemsOfFirstRoom.add(new Door(key1));
        itemsOfFirstRoom.add(new Window());
        return new Room(itemsOfFirstRoom);
    }

    private Room createSecondRoom() {
        List<Item> itemsOfSecondRoom = new ArrayList<>();
        Code code = new Code("2546");
        this.code = code;//todo wprowadzanie kodu przez użytkownika
        Key key2 = new Key("do biurka");
        Key key3 = new Key("do drzwi");
        itemsOfSecondRoom.add(new Desk(key2, key3));
        itemsOfSecondRoom.add(new Door(key3));
        itemsOfSecondRoom.add(new Wardrobe(code, key2));
        itemsOfSecondRoom.add(new Window());
        itemsOfSecondRoom.add(code);
        return new Room(itemsOfSecondRoom);
    }
}
