package escaperoom;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private final List<Item> items;

    public Room(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items) ;
    }

    void removeItem(Item item) {
        items.remove(item);
    }
}
