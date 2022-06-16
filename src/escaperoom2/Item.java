package escaperoom2;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    abstract void use();

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
