package banking;

import java.util.Random;

public class MyNumber {
    private static final Random random = new Random();

    public static int getRandom(int bound) {
        return random.nextInt(bound);
    }

    public static String getRandomNumberSequence(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(getRandom(10));
        }
        return sb.toString();
    }
}
