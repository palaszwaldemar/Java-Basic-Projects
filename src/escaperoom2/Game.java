package escaperoom2;

import java.util.ArrayList;

public class Game {
    private Room room = new Room();

    public ArrayList<Item> getItems() {
        return room.getItems();
    }

    void useItem(String choose) {
        for (Item item : room.getItems()) {
            if(item.getName().equalsIgnoreCase(choose)) {
               item.use();
            }
        }
    }
}
