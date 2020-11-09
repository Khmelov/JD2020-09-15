package by.it.siarheikorbut.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    private final AtomicInteger countEnterToMarket = new AtomicInteger(0);

    private final AtomicInteger countOutFromMarket = new AtomicInteger(0);

    public final int totalBuyersCount;

    public Dispatcher(int totalBuyersCount) {
        this.totalBuyersCount = totalBuyersCount;
    }

    void buyerEnterToMarket() {
        countEnterToMarket.getAndIncrement();
    }

    void buyerLeaveMarket() {
        countOutFromMarket.getAndIncrement();
    }

    boolean marketIsOpenedForNewBuyer() {
        return countEnterToMarket.get() != totalBuyersCount;
    }

    boolean marketIsClosed() {
        return countOutFromMarket.get() == totalBuyersCount;
    }

    public int getCountEnterToMarket() {
        return countEnterToMarket.get();
    }

    public int getCountOutFromMarket() {
        return countOutFromMarket.get();
    }
}