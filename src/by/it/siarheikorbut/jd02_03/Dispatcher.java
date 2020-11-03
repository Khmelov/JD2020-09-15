package by.it.siarheikorbut.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    private final int totalBuyersCount;

    public Dispatcher(int totalBuyersCount) {
        this.totalBuyersCount = totalBuyersCount;
    }

    static final int K_SPEED = 10;
    private final AtomicInteger countEnterToMarket = new AtomicInteger(0);
    private final AtomicInteger countOutFromMarket = new AtomicInteger(0);
    volatile static int countBuyersInQueue = 0;

    void buyerEnterToMarket() {
        countEnterToMarket.getAndIncrement();
    }

    void buyerLeaveMarket() {
        countOutFromMarket.getAndIncrement();
    }

    static synchronized void increaseCountBuyersInQueue() {
        countBuyersInQueue++;
    }

    static synchronized void decreaseCountBuyersInQueue() {
        countBuyersInQueue--;
    }

    boolean marketIsOpenedForNewBuyer() {
        return countEnterToMarket.get() != totalBuyersCount;
    }

    boolean marketIsClosed() {
        return countOutFromMarket.get() == totalBuyersCount;
    }
}
