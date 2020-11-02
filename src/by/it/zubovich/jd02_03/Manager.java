package by.it.zubovich.jd02_03;

class Manager {
    private Manager() {

    }

    static final int K_SPEED = 100;
    private static volatile int buyersEnterToMarket = 0;
    private static volatile int buyersLeftMarket = 0;
    private static final int buyerTotal = 100;

    static synchronized void addBuyer() {

        buyersEnterToMarket++;
    }

    static void leftBuyer() {
        synchronized (Manager.class) {
            buyersLeftMarket++;
        }
    }

    static boolean marketIsOpened() {

        return buyersEnterToMarket != buyerTotal;
    }

    static boolean marketIsClosed() {

        return buyersLeftMarket == buyerTotal;
    }
}
