package zbijak;

import java.util.NoSuchElementException;
import java.util.Random;

public enum Direction {
    UP("W"),
    LEFT("A"),
    DOWN("S"),
    RIGHT("D");

    private final String key;

    Direction(String key) {
        this.key = key;
    }

    static Direction findDirectionByKey(String key) {
        for (Direction value : Direction.values()) {
            if (value.key.equals(key.toUpperCase())) {
                return value;
            }
        }
        throw new NoSuchElementException("Niedopasowano kierunku");
    }

    static Direction randomDirection() {
        Random random = new Random();
        int indexOfValues = random.nextInt(4);
        return Direction.values()[indexOfValues];
    }
}

