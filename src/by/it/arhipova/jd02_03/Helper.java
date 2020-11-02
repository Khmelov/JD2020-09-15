package by.it.arhipova.jd02_03;

import java.util.Random;

public class Helper {

    private static final int K_SPEED = 10000;

    private static Random random = new Random();

    public static int getRandom(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void sleep(int miliseconds) {
        try {
            Thread.sleep(miliseconds / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}






