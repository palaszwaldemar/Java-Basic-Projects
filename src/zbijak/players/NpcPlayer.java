package zbijak.players;

public class NpcPlayer extends Player{
    public NpcPlayer(int x, int y) {
        super(x, y, "#");
    }

    @Override
    public boolean isHuman() {
        return false;
    }
}
