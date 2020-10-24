package by.it.kolesnikov.jd02_02;

class Supervisor {

    private Supervisor(){
    }

    private static volatile int buyersEnterToMarket=0;
    private static volatile int buyersLeftMarket=0;

    private static final int buyerTotal=100;

    static synchronized void addBuyer(){
        buyersEnterToMarket++;
    }

    static void leaveBuyer(){
        synchronized (Supervisor.class) {
            buyersLeftMarket++;
        }
    }

    static boolean marketIsOpened(){
        return buyersEnterToMarket!=buyerTotal;
    }

    static boolean marketIsClosed(){
        return buyersLeftMarket==buyerTotal;
    }
}
