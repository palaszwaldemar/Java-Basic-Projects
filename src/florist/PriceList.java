package florist;

import java.util.ArrayList;
import java.util.List;

public class PriceList {
    private static final PriceList priceList = new PriceList();
    private final List<PriceListPosition> priceListPosition = new ArrayList<>();

    private PriceList() {
    }

    static PriceList getInstance() {
        return priceList;
    }

    void put(String name, double price) {
        priceListPosition.add(new PriceListPosition(name, price));
    }

    double getPrice(String name) {
        for (PriceListPosition listPosition : priceListPosition) {
            if (listPosition.getNameOfFlower().equals(name)) {
                return listPosition.getPriceOfFlower();
            }
        }
        return -1;
    }
}
