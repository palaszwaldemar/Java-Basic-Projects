package florist;

import java.util.ArrayList;
import java.util.List;

public class ContainerOfFlower {
    private final String name;
    private final String owner;
    private List<Flower> flowers = new ArrayList<>();

    public ContainerOfFlower(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public void add(Flower flower) {
        flowers.add(flower);
    }

    public List<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }

    void removeFlowers(List<Flower> flowers) {
        this.flowers.removeAll(flowers);
    }

    void remove() {
        flowers.clear();
    }

    double priceOfOneTypeFlowers(String color) {
        double price = 0;
        for (Flower flower : flowers) {
            if (flower.getColor().equals(color)) {
                price = price + flower.getPrice() * flower.getHowMany();
            }
        }
        return price;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        StringBuilder cartDisplay = new StringBuilder();
        cartDisplay.append(name)
                .append(" właściciel ")
                .append(owner)
                .append("\n");

        for (Flower flower : flowers) {
            cartDisplay.append(flower)
                    .append("\n");
        }

        return cartDisplay.toString();
    }
}
