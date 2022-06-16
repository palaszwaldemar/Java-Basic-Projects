package escaperoom2;

import java.util.ArrayList;

public class Room {
    private ArrayList<Item> items = new ArrayList<>();

    public Room() {
        items.add(new Key());
        items.add(new Door());
        items.add(new Window());
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
