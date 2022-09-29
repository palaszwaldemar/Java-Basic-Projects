package zbijak.players;

import java.util.Random;

public abstract class Player {
    private final String name;
    int x;
    int y;

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

    public void move(String direction) {
        if (direction.isEmpty()) {
            randomMove();
        } else {
            executeMove(direction);
        }
    }

    private void randomMove() {
        Random random = new Random();
        String[] directions = new String[]{"W", "A", "S", "D"};
        int dircetionInex = random.nextInt(directions.length);
        String direcion = directions[dircetionInex];
        executeMove(direcion);
    }

    private void executeMove(String direction) {
        switch (direction) {
            case "W" -> y--;
            case "A" -> x--;
            case "S" -> y++;
            case "D" -> x++;
            default -> throw new IllegalArgumentException("Nierozpoznany kierunek");
        }
    }

    public abstract boolean isHuman();
}
