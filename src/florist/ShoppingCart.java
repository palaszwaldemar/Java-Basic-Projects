package florist;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final String owner;
    private final List<Flower> flowers = new ArrayList<>();

    public ShoppingCart(String owner) {
        this.owner = owner;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(Flower flower) {
        flowers.add(flower);
    }

    void removeFlower(Flower flower) {
        flowers.remove(flower);
    }

    void removeShoppingCart() {
        flowers.clear();
    }

    @Override
    public String toString() {
        String name = "Wózek";
        String toString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" właściciel ").append(owner).append("\n");
        for (Flower flower : flowers) {
            stringBuilder.append(flower).append("\n");
        }
        toString = String.valueOf(stringBuilder);
        return toString;
    }
}
