package florist;

public class Box extends ContainerOfFlower {

    public Box(Customer customer) {
        super("Pudełko", customer.getName());
    }
}
