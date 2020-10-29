package by.it.girovka.jd2_2;

public class Dispatcher {

    static final int K_SPEED=10;
    static final Object MONITIR = new Object();

    private static final int PLAN = 100;
    private volatile static int inCount = 0;
    private volatile static int outCount = 0;


    static boolean shopOpened(){
        return inCount <PLAN;
    }
    static boolean planComplete(){
        return outCount == PLAN;
    }

    static void buyerAddToShop(){
        synchronized (MONITIR){
        inCount++;
    }}

        static void buyerLeaveShop(){
            synchronized (MONITIR){
                outCount++;
            }

    }
}
