package by.it.yemialyanava.jd02_02;

class Supervisor {

    private Supervisor(){
    }

    private static volatile int buyerEnterToMarket = 0;
    private static volatile int buyerLeaveMarket = 0;
    private static volatile int cashierWorking = 0;

    private static final int buyerTotal = 100;

    static synchronized void addBuyer(){
        buyerEnterToMarket++;
    }

    static void leaveBuyer(){
        synchronized (Supervisor.class){
            buyerLeaveMarket++;
        }
    }

    static synchronized void addCashier(){
        cashierWorking++;
    }
    static synchronized void cashierStopWork(){
        cashierWorking--;
    }
    static synchronized int cashierWorkNow(){
        return cashierWorking;
    }

    static boolean marketIsOpened(){
        return buyerEnterToMarket != buyerTotal;
    }
    static boolean marketIsClosed(){
        return buyerLeaveMarket == buyerTotal;
    }
}
