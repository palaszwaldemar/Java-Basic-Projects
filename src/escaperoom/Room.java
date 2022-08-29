package escaperoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Room {
    private final List<Item> items;

    public Room(List<Item> items) {
        this.items = items;
    }

    //znajdz przedmiot po nazwie
    Optional<Item> findItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    void removeItem(Item item) {
        items.remove(item);
    }
}
