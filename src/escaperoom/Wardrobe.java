package escaperoom;

public class Wardrobe extends Item{
    private final Code codeToOpenWardrobe;
    private final Key key;
    private boolean wasUse;
    private boolean isOpen;
    private Dialog dialog;

    public Wardrobe(Code code, Key key) {
        super("Szafa");
        this.codeToOpenWardrobe = code;
        this.key = key;
    }

    @Override
    Dialog use(Room room, Player player, Game game) {
        if (wasUse) {
            if(!isOpen) {
                isOpen = true;
                return new Dialog("Otwierasz szafę");
            } else {
                isOpen = false;
                return new Dialog("Zamykasz szafę");
            }
        }
        if (dialog != null) {
            if (dialog.getAnswer().equals(codeToOpenWardrobe.getCode())) {
                player.addItem(key);
                isOpen = true;
                wasUse = true;
                return new Dialog("Znajdujesz klucz do biurka.");
            } else {// TODO: 16.08.2022 dokończone
                dialog = null;
                return new Dialog("Błędny kod");
            }
        }
        dialog = new Dialog("Podaj kod: ", true);
        return dialog;
    }
}