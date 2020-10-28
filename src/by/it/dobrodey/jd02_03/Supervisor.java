package by.it.dobrodey.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    private Supervisor() {
    }
    final static Object monQueue = new Object();
    private static final AtomicInteger buyersEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeavedMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersEnterQueue = new AtomicInteger(0);
    private static final int buyerTotal = 100;//0;


    static  int getBuyer(){
        return buyersEnterToMarket.get()-buyersLeavedMarket.get();
    }
    static  int getBuyerEnter(){
        return buyersEnterToMarket.get();
    }
    static  int getBuyerLeaved(){
        return buyersLeavedMarket.get();
    }

    static void addBuyer() {
        buyersEnterToMarket.getAndIncrement();
    }
    static void leaveBuyer() {buyersLeavedMarket.getAndIncrement();}

    static void addQueue(){buyersEnterQueue.getAndIncrement();}


    static boolean marketIsOpened() {
        return buyersEnterToMarket.get() != buyerTotal;
    }
    static boolean marketIsClosed() {
        return buyersLeavedMarket.get() == buyerTotal;
    }
    static boolean queueClosed() {
        return buyersEnterQueue.get() ==100;
    }

}

