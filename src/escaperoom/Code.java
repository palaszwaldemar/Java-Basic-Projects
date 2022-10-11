package escaperoom;

public class Code extends Item {
    private final String code;

    public Code(String code) {
        super("Kod");
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    Dialog use(Mediator mediator) {
        mediator.getPlayer().addItem(this);
        mediator.getRoom().removeItem(this);
        setName("Kod: " + code);
        return new Dialog("Znajdujesz kartkę z kodem: " + code);
    }
}
