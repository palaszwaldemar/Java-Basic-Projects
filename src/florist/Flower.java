package florist;

public abstract class Flower {
    private final int howMany;
    private final String name;
    private final String color;

    public Flower(int howMany, String name, String color) {
        this.howMany = howMany;
        this.name = name;
        this.color = color;
    }

    public int getHowMany() {
        return howMany;
    }

    double getPrice() {
        return PriceList.getInstance().getPrice(name);
    }

    public String getColor() {
        return color;
    }

    double getFullPrice() {
        return getHowMany() * getPrice();
    }

    @Override
    public String toString() {
        return name + ", kolor: " + getColor() + ", ilość " + getHowMany() + ", cena " + getPrice();
    }
}
