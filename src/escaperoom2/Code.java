package escaperoom2;

public class Code extends Item{

    public Code() {
        super("Kod");
    }

    @Override
    String use(Room room, Player player, Game game) {
        player.addItem(this);
        room.removeItem(this);
        setName("Kod: 2546");
        return "Znajdujesz kartkę z kodem: 2546";
    }
}
