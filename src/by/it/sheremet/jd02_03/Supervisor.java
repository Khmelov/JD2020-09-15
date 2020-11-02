package by.it.sheremet.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    private Supervisor() {
    }

    private static final AtomicInteger buyersEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeaveMarket = new AtomicInteger(0);

    private static final int buyerTotal = 100;

    static void addBuyer() {

        buyersEnterToMarket.getAndIncrement();
    }

    static void leaveBuyer() {

        buyersLeaveMarket.getAndIncrement();
    }

    static boolean marketIsOpened() {

        return buyersEnterToMarket.get() != buyerTotal;
    }

    static boolean marketIsClosed() {

        return buyersLeaveMarket.get() == buyerTotal;
    }
}








