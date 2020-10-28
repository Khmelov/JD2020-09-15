package by.it.fedorinhyk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {
    private Supervisor() {

    }
    private static final AtomicInteger buyersInterToMarket=new AtomicInteger(0);
    private static final AtomicInteger buyersLeavedMarket= new AtomicInteger(0);

    private static final int totalbuyers=100;

    static synchronized void addBuyer(){
        buyersInterToMarket.getAndIncrement();
    }
    static void leaveBuyers(){
        buyersLeavedMarket.getAndIncrement();
    }
    static boolean MarketIsOpened(){
        return buyersInterToMarket.get()!=totalbuyers;
    }
    static boolean MarketIsClosed() {
        return buyersLeavedMarket.get() == totalbuyers;
    }
}
