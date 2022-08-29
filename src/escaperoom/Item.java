package escaperoom;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    abstract Dialog use(Mediator mediator);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
