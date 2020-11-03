package by.it.hutnik.jd02_02;

import java.util.Objects;

class Supervisor extends Thread{

    static int BUYERS_IN_SHOP = 0;
    static final int K_SPEED = 100;
    static final Object MONITOR = new Object();

    private static final int KOLEJKA = 100;
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;

    static boolean marketOpen(){
        return inCount < KOLEJKA;
    }
    static boolean completed(){
        return outCount == KOLEJKA;
    }
    static void addBuyer(){
        synchronized (MONITOR){
            inCount++;
        }
    }
    static void ofBuyer(){
        synchronized (MONITOR){
            outCount++;
        }
    }
}