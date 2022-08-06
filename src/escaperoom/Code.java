package escaperoom;

public class Code extends Item{
    private final String code;

    public Code(String code) {
        super("Kod");
        this.code = code;
    }

    public String getCode() {//todo dodany getter aby można było wprowadzać kod przez użytkownika
        return code;
    }

    @Override
    String use(Room room, Player player, Game game) {
        player.addItem(this);
        room.removeItem(this);
        setName("Kod: " + code);
        return "Znajdujesz kartkę z kodem: " + code;
    }
}
