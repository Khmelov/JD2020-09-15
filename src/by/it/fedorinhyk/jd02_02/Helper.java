package by.it.fedorinhyk.jd02_02;

import java.util.Random;

class Helper {
    private static final int SPEED=1000;
    private static Random random=new Random();
    static int getRandom(int min, int max){
        return min+random.nextInt(max-min+1);
    }
    static int getRandom(int max){
        return getRandom(0,max);
    }
    static void timeout (int milisec){
        try {
            Thread.sleep(milisec/SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
