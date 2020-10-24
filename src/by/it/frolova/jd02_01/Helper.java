package by.it.frolova.jd02_01;

import java.util.Random;

class Helper {

    public static final int K_SPEED = 100;
    private static Random random = new Random();

    static int getRandom(int min, int max) {
        return min + random.nextInt(max - min + 1);

    }static int getRandom(int max) {
        return getRandom(0,max);
    }

    static void timeout(int miliseconds) {
        try {
            Thread.sleep(miliseconds / K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
