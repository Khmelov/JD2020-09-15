package by.it.moiseyenko.jd02_02;

import java.util.HashMap;
import java.util.Random;

class Helper {
    private static final int K_SPEED = 10000;

    private static Random random = new Random();

    static int getRandom(int min,int max){return min+random.nextInt(max-min+1);}

    static int getRandom(int max){return getRandom(0,max);}

    static void timeout(int miliseconds){
        try {
            Thread.sleep(miliseconds/K_SPEED);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    static void basket() {
        HashMap<String, Integer> good = new HashMap();
        good.put("milk", 1);
        good.put("bread", 2);
        good.put("fish", 3);
        good.put("water", 4);
    }
}
