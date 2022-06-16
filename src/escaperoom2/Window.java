package escaperoom2;

public class Window extends Item{

    public Window() {
        super("Okno");
    }

    @Override
    void use() {
        System.out.println("Uzywam okna");
    }
}
