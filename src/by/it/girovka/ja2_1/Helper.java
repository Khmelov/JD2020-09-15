package by.it.girovka.ja2_1;

import java.util.Random;

public class Helper {

    private static Random generator = new Random();


    private Helper(){


    }

    public static int getRandom(int start, int end) {
    return start+generator.nextInt(end-start+1);

    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted"+Thread.currentThread(),e);
        }

    }
}
