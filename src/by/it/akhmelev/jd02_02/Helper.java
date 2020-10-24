package by.it.akhmelev.jd02_02;

import java.util.Random;

class Helper {

    private static final int K_SPEED = 10000;

    private static Random random=new Random();

    static int getRandom(int min, int max){
        return min+random.nextInt(max-min+1);
    }

    static int getRandom(int max){
        return getRandom(0,max);
    }

    static void timeout(int miliseconds) {
        try {
            Thread.sleep(miliseconds/ K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
