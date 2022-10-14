package zbijak;

public abstract class Player {
    private final String name;
    private int x;
    private int y;

    public Player(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void move(Direction direction) {
        switch (direction) {
            case UP -> {
                if (y == 0) {
                    y = Game.SIZE - 1;
                    break;
                }
                y--;
            }
            case DOWN -> {
                if (y == Game.SIZE - 1) {
                    y = 0;
                    break;
                }
                y++;
            }
            case LEFT -> {
                if (x == 0) {
                    x = Game.SIZE - 1;
                    break;
                }
                x--;
            }
            case RIGHT -> {
                if (x == Game.SIZE - 1) {
                    x = 0;
                    break;
                }
                x++;
            }
        }
    }
}
