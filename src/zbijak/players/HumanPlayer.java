package zbijak.players;

public class HumanPlayer extends Player {
    public HumanPlayer(int x, int y) {
        super(x, y, "@");
    }

    @Override
    public boolean isHuman() {
        return true;
    }
}
