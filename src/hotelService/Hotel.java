package hotelService;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Room> rooms = new ArrayList<>();

    public Hotel() {
        rooms.add(new Room(1, 5, true));
        rooms.add(new Room(2, 4, true));
        rooms.add(new Room(3, 2, true));
        rooms.add(new Room(4, 2, true));
        rooms.add(new Room(5, 3, true));
        rooms.add(new Room(6, 1, false));
        rooms.add(new Room(7, 5, true));
        rooms.add(new Room(8, 3, true));
        rooms.add(new Room(9, 4, true));
        rooms.add(new Room(10, 1, false));
    }

    Room getRoom(int numberOfRoom) {
        for (Room room : rooms) {
            if (room.getNumberOfRoom() == numberOfRoom) {
                return room;
            }
        }
        throw new HotelException("\nNie ma takiego pokoju\n");
    }


    List<Room> getAllRooms() {
        return rooms;
    }

    List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    List<Room> getUnavailableRooms() {
        List<Room> unavailableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isAvailable()) {
                unavailableRooms.add(room);
            }
        }
        return unavailableRooms;
    }

    List<Room> getDirtyRooms() {
        List<Room> dirtyRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (!room.isClean()) {
                dirtyRooms.add(room);
            }
        }
        return dirtyRooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "rooms=" + rooms +
                '}';
    }
}
