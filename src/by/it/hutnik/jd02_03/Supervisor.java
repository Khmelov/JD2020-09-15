package by.it.hutnik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor extends Thread{

    static int BUYERS_IN_SHOP = 0;
    static final int K_SPEED = 100;

    private static final int KOLEJKA = 2;
    private volatile static AtomicInteger inCount = new AtomicInteger(0);
    private volatile static AtomicInteger outCount = new AtomicInteger(0);

    static boolean marketOpen(){
        return inCount.get() < KOLEJKA;
    }
    static boolean completed(){
        return outCount.get() == KOLEJKA;
    }
    static void addBuyer(){
        inCount.getAndIncrement();
        }
    static void ofBuyer(){
        outCount.getAndIncrement();
        }
}