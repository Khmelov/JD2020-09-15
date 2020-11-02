package by.it.moiseyenko.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    private Supervisor(){

    }

    private static final AtomicInteger buyersEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeavedMarket = new AtomicInteger(0);

    private static final int buyerTotal = 100;

    static void addBuyer() {
        buyersEnterToMarket.getAndDecrement();
    }

    static void leaveBuyer() { buyersLeavedMarket.getAndIncrement();
        }

    static boolean marketIsOpened() {
        return buyersEnterToMarket.get() != buyerTotal;
    }

    static boolean marketIsClosed() {
        return buyersLeavedMarket.get() == buyerTotal;
    }

}
