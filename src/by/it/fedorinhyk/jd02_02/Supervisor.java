package by.it.fedorinhyk.jd02_02;

class Supervisor {
    private Supervisor() {

    }
    private static volatile int buyersInterToMarket=0;
    private static volatile int buyersLeavedMarket=0;

    private static final int totalbuyers=100;

    static synchronized void addBuyer(){
        buyersInterToMarket++;
    }
    static void leaveBuyers(){
        synchronized (Supervisor.class){
            buyersLeavedMarket++;
        }
    }
    static boolean MarketIsOpened(){
        return buyersInterToMarket!=totalbuyers;
    }
    static boolean MarketIsClosed() {
        return buyersLeavedMarket == totalbuyers;
    }
}
