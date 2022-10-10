package zbijak;

public class NpcPlayer extends Player {

    public NpcPlayer(int x, int y) {
        super(x, y, "N");
    }

    @Override
    boolean isHuman() {
        return false;
    }
}
