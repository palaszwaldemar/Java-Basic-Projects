package florist;

public class Lilac extends Flower {
    private static double price = -1;

    public Lilac(int number) {
        super(number);
    }

    @Override
    double getPrice() {
        return price;
    }

    public static void setPrice(double newPrice) {
        price = newPrice;
    }

    @Override
    String getName() {
        return "bez";
    }

    @Override
    String getColor() {
        return "biały";
    }
}
