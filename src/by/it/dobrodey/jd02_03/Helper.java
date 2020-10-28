package by.it.dobrodey.jd02_03;

import java.util.Random;

public class Helper {
    private static final int K_SPEED = 100;
    private static Random random = new Random();
    static final String space = " ";
    static final String spacecashier = space.repeat(20);
    static final String spaceQueue = space.repeat(120);
    static final String spacetoalsupermarket = space.repeat(140);
    static int getRandom (int min,int max){return min + random.nextInt(max-min+1);}
    static int getRandom (int max){return getRandom(0,max);}



    public static void timeout(int milisecond) {
        try {

            Thread.sleep(milisecond / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
