package florist;

public class Peony extends Flower {
    private static double price = -1;

    public Peony(int number) {
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
        return "piwonia";
    }

    @Override
    String getColor() {
        return "czerwony";
    }
}
