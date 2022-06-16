package escaperoom2;

public class Door extends Item{

    public Door() {
        super("Drzwi");
    }


    @Override
    void use() {
        System.out.println("Uzywam drzwi");
    }
}
