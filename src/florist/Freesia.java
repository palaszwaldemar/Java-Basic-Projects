package florist;

public class Freesia extends Flower {
    private static double price = -1;

    public Freesia(int number) {
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
        return "frezja";
    }

    @Override
    String getColor() {
        return "żółty";
    }
}
