package zbijak;

import java.util.NoSuchElementException;
import java.util.Random;

public enum Direction {
    UP("W"),
    LEFT("A"),
    DOWN("S"),
    RIGHT("D");

    private final String key;

    public String getKey() {
        return key;
    }

    Direction(String key) {
        this.key = key;
    }

    static Direction findDirectionByKey(String key) {
        for (Direction value : Direction.values()) {
            if (value.getKey().equals(key)) {// CHECK: 20.10.2022 czy taki może być warunek?
                return value;
            }
        }
        throw new NoSuchElementException("Niedopasowano kierunku");
    }

    static String randomDirection() {// CHECK: 20.10.2022 czy tak może wyglądać metoda losowania kierunku?
        Random random = new Random();
        int indexOfValues = random.nextInt(3);
        return Direction.values()[indexOfValues].getKey();
    }
}

