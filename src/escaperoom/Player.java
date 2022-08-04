package escaperoom;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Player{" +
                "items=" + items +
                '}';
    }

    boolean hasItem(Item item) {
        return items.contains(item);
    }
}
