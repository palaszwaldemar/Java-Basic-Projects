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
    Dialog use(Mediator mediator) {
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
                mediator.getPlayer().addItem(key);
                isOpen = true;
                wasUse = true;
                return new Dialog("Znajdujesz klucz do biurka.");
            } else {
                dialog = null;
                return new Dialog("Błędny kod");
            }
        }
        dialog = new Dialog("Podaj kod: ", true);
        return dialog;
    }
}