package by.it.zubovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Manager {
    private Manager() {
    }

    static final int K_SPEED = 100;
    private static final AtomicInteger buyersEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeftMarket = new AtomicInteger(0);

    private static final int buyerTotal = 100;

    static void addBuyer() {

        buyersEnterToMarket.getAndIncrement();
    }

    static void leftBuyer() {

        buyersLeftMarket.getAndIncrement();
    }

    static boolean marketIsOpened() {

        return buyersEnterToMarket.get() != buyerTotal;
    }

    static boolean marketIsClosed() {

        return buyersLeftMarket.get() == buyerTotal;
    }
}
