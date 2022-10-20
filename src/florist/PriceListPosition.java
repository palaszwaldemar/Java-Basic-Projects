package florist;

public class PriceListPosition {
    private final String nameOfFlower;
    private final double priceOfFlower;

    public PriceListPosition(String nameOfFlower, double priceOfFlower) {
        this.nameOfFlower = nameOfFlower;
        this.priceOfFlower = priceOfFlower;
    }

    public String getNameOfFlower() {
        return nameOfFlower;
    }

    public double getPriceOfFlower() {
        return priceOfFlower;
    }
}
