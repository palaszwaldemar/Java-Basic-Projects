package florist;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private double cash;
    private final ShoppingCart shoppingCart;

    public Customer(String name, int cash) {
        shoppingCart = new ShoppingCart(name);
        this.name = name;
        this.cash = cash;
    }

    void add(Flower flower) {
        shoppingCart.add(flower);
    }

    void pay() {
        List<Flower> flowersToRemove = new ArrayList<>();
        List<Flower> flowers = shoppingCart.getFlowers();
        flowers.removeIf(flower -> flower.getPrice() == -1);
        shoppingCart.setFlowers(flowers);
        for (Flower flower : shoppingCart.getFlowers()) {
            if (cash >= flower.getFullPrice()) {
                cash -= flower.getFullPrice();
            } else {
                flowersToRemove.add(flower);
            }
        }
        shoppingCart.removeFlowers(flowersToRemove);
    }

    void pack(Box box) {
        for (Flower flower : shoppingCart.getFlowers()) {
            box.add(flower);
        }
        shoppingCart.remove();
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
}
