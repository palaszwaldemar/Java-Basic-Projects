package escaperoom;

public abstract class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    abstract String use(Room room, Player player, Game game); // TODO: 10.08.2022 uproscic zeby nie trzeba bylo tyle parametrow dodawac

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
