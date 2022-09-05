package florist;

public class PriceList {
    private static final PriceList priceList = new PriceList();

    private PriceList() {
        System.out.println("Tworzę priceList");
    }

    static PriceList getInstance() {
        System.out.println("Zwracam PriceList");
        return priceList;
    }
}
