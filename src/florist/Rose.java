package florist;

public class Rose extends Flower {
    private static double price = -1;

    public Rose(int number) {
        super(number);
    }

    @Override
    double getPrice() {
        return price;
    }

    public static void setPrice(double newPrice) {// CHECK: 19.10.2022 dlaczego nie mogę nazwać zmiennej newPrice tak jak pole price?
        price = newPrice;
    }

    @Override
    String getName() {
        return "róża";
    }

    @Override
    String getColor() {
        return "czerwony";
    }
}
