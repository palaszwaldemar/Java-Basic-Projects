package florist;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final List<Flower> flowers = new ArrayList<>();
    private final Customer customer;

    public Box(Customer customer) {
        this.customer = customer;
    }

    void pack(Flower flower) {
        flowers.add(flower);
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

    @Override
    public String toString() {
        String name = "Pudełko";
        String toString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(" właściciel ").append(customer.getName()).append("\n");
        for (Flower flower : flowers) {
            stringBuilder.append(flower).append("\n");
        }
        toString = String.valueOf(stringBuilder);
        return toString;
    }
}
