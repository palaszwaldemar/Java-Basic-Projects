package florist;

public abstract class Flower {
    private final int howMany;

    public Flower(int howMany) {
        this.howMany = howMany;
    }

    public int getHowMany() {
        return howMany;
    }

    abstract double getPrice();

    abstract String getName();

    abstract String getColor();

    @Override
    public String toString() {
        return getName() + ", kolor: " + getColor() + ", ilość " + getHowMany() + ", cena " + getPrice();
    }
}
