package florist;

public class PriceList {
    private static final PriceList priceList = new PriceList();

    static PriceList getInstance() {
        return priceList;
    }

    void put(String name, double price) {
        if (name.equals("róża")) {
            Rose.setPrice(price);
        }
        if (name.equals("piwonia")) {
            Peony.setPrice(price);
        }
        if (name.equals("frezja")) {
            Freesia.setPrice(price);
        }
        if (name.equals("bez")) {
            Lilac.setPrice(price);
        }

    }
}
