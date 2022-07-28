package escaperoom2;

public class Wardrobe extends Item{
    private final Code code;
    private final Key key;
    private boolean wasUse;
    private boolean isOpen;

    public Wardrobe(Code code, Key key) {
        super("Szafa");
        this.code = code;
        this.key = key;
    }

    @Override
    String use(Room room, Player player, Game game) {
        if (wasUse) {
            if(!isOpen) {
                isOpen = true;
                return "Otwierasz szafę";
            } else {
                isOpen = false;
                return "Zamykasz szafę";
            }
        }
        if (player.hasItem(code)) {
            player.addItem(key);
            isOpen = true;
            wasUse = true;
            return "Znajdujesz klucz do biurka.";
        }
        return "Nie masz kodu do szafy";
    }
}
