package escaperoom;

public class Code extends Item{
    private final String code;

    public Code(String code) {
        super("Kod");
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    Dialog use(Room room, Player player, Game game) {
        player.addItem(this);
        room.removeItem(this);
        setName("Kod: " + code);
        return new Dialog("Znajdujesz kartkę z kodem: " + code);
    }
}
