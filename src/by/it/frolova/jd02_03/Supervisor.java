package by.it.frolova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    private Supervisor() {
    }

    private static final AtomicInteger buyersEnteredMarket = new AtomicInteger();
    private static final AtomicInteger buyersLeftMarket = new AtomicInteger();

    private static final int total = 100;

    static synchronized void buyerEntered() {
        buyersEnteredMarket.getAndIncrement();
    }

    static synchronized void buyersLeft() {
        buyersLeftMarket.getAndIncrement();
    }

    static boolean marketIsOpen() {
        return buyersEnteredMarket.get() != total;
    }

    static boolean marketIsClosed() {
        return buyersLeftMarket.get() == total;
    }

}
