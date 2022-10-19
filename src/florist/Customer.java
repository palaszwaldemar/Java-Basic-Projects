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

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    void add(Flower flower) {
        shoppingCart.setFlowers(flower);
    }

    void pay() {
        List<Flower> additionalFlowersList = new ArrayList<>();
        shoppingCart.getFlowers().removeIf(flower -> flower.getPrice() == -1);
        for (Flower flower : shoppingCart.getFlowers()) {
            if (cash >= flower.getHowMany() * flower.getPrice()) {
                cash = cash - flower.getHowMany() * flower.getPrice();
            } else {
                additionalFlowersList.add(flower);
            }
        }
        for (Flower flowerToRemove : additionalFlowersList) {
            shoppingCart.removeFlower(flowerToRemove);
        }
    }

    void pack(Box box) {
        for (Flower flower : shoppingCart.getFlowers()) {
            box.pack(flower);
        }
        shoppingCart.removeShoppingCart();
    }
}
