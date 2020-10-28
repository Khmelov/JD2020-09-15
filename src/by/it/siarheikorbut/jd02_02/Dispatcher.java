package by.it.siarheikorbut.jd02_02;

public class Dispatcher {
    static final int K_SPEED = 10;
    private volatile static int countEnterToMarket = 0;
    private volatile static int countOutFromMarket = 0;
    volatile static int countBuyersInQueue = 0;

    static synchronized void buyerEnterToMarket() {
        countEnterToMarket++;
    }

    static synchronized void buyerLeaveMarket() {
        countOutFromMarket++;
    }

    static synchronized void increaseCountBuyersInQueue() {
        countBuyersInQueue++;
    }

    static synchronized void decreaseCountBuyersInQueue() {
        countBuyersInQueue--;
    }

    static boolean marketIsOpenedForNewBuyer() {
        return countEnterToMarket != PLAN;
    }

    static boolean marketIsClosed() {
        return countOutFromMarket == PLAN;
    }

    static int PLAN = 100;
}
