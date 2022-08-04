package practise;

import escaperoom.Item;
import escaperoom.Window;

import java.util.ArrayList;
import java.util.List;

public class Practise1 {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        System.out.println(items);
        Window window = new Window();
        items.add(window);
        System.out.println(items);
       /* Key key = new Key();*/
      /*  items.add(key);*/
        System.out.println(items);
        items.remove(window);
        System.out.println(items);
    }
}
