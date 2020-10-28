package by.it.dobrodey.jd02_02;

class Supervisor {

    private Supervisor() {
    }
    final static Object monQueue = new Object();
    private static volatile int buyersEnterToMarket = 0;
    private static volatile int buyersLeavedMarket = 0;
    private static volatile int buyersEnterQueue = 0;

    static synchronized int getBuyer(){
        return buyersEnterToMarket-buyersLeavedMarket;
    }
    static  int getBuyerEnter(){
        return buyersEnterToMarket;
    }
    static  int getBuyerLeaved(){
        return buyersLeavedMarket;
    }

    private static final int buyerTotal = 100;//0;

    static synchronized void addBuyer() {
        buyersEnterToMarket++;
    }
    static void addQueue()
    {synchronized (monQueue ){
        buyersEnterQueue++;
    }}

    static void leaveBuyer() {
        synchronized (Supervisor.class) {
            buyersLeavedMarket++;
        }
    }

    static boolean marketIsOpened() {
        return buyersEnterToMarket != buyerTotal;
    }

    static boolean marketIsClosed() {
        return buyersLeavedMarket == buyerTotal;
    }

    static boolean queueClosed() {
        return buyersEnterQueue ==100;
    }

}

