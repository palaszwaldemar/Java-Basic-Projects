package escaperoom2;

public class Key extends Item{

    public Key() {
        super("Klucz");
    }

    @Override
    void use() {
        System.out.println("Uzywam klucza");
    }
}
