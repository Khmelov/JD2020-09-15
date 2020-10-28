package by.it.yemialyanava.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Supervisor {

    private Supervisor(){
    }

    private static final AtomicInteger buyerEnterToMarket = new AtomicInteger(0);
    private static final AtomicInteger buyerLeaveMarket = new AtomicInteger(0);
    private static final AtomicInteger cashierWorking = new AtomicInteger(0);

    private static final int buyerTotal = 100;



    static void addBuyer(){
        buyerEnterToMarket.getAndIncrement();
    }

    static void leaveBuyer(){
        buyerLeaveMarket.getAndIncrement();
    }

    static int countActualNumberOfBuyer(){
        return buyerEnterToMarket.get() - buyerLeaveMarket.get();
    }

    static void addCashier(){
        cashierWorking.getAndIncrement();
    }
    static void cashierStopWork(){
        cashierWorking.getAndDecrement();
    }
    static int cashierWorkNow(){
        return cashierWorking.get();
    }

    static boolean marketIsOpened(){
        return buyerEnterToMarket.get() != buyerTotal;
    }
    static boolean marketIsClosed(){
        return buyerLeaveMarket.get() == buyerTotal;
    }
}
