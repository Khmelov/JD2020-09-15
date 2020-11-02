package by.it.lapkovskiy.jd02_03;


class Supervisor extends Thread {
    private static int TotalMarket = 0;
    private static volatile int buyersEnterToMarket = 0;
    private static volatile int buyersLeavedMarket = 0;

    private static final int buyerTotal = 100;

    public static synchronized void upTotal(int sum) {
        TotalMarket += sum;
    }

    public static synchronized int GetTotal() {
        return TotalMarket;
    }

    static boolean marketIsOpened() {
        return buyersEnterToMarket != buyerTotal;
    }

    static int inCountBuyersMarket() {
        return buyersEnterToMarket - buyersLeavedMarket;
    }

    static boolean marketIsClosed() {
        return buyersLeavedMarket == buyerTotal;
    }

    static synchronized void addBuyer() {
        buyersEnterToMarket++;
    }

    static void leaveBuyer() {
        synchronized (Supervisor.class) {
            buyersLeavedMarket++;
        }
    }
}
