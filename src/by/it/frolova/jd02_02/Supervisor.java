package by.it.frolova.jd02_02;

class Supervisor {

    private Supervisor() {
    }

    private static volatile int buyersEnteredMarket;
    private static volatile int buyersLeftMarket;

    private static final int total = 100;

    static synchronized void buyerEntered() {
        buyersEnteredMarket++;
    }

    static synchronized void buyersLeft() {
        buyersLeftMarket++;
    }

    static boolean marketIsOpen() {
        return buyersEnteredMarket != total;
    }

    static boolean marketIsClosed() {
        return buyersLeftMarket == total;
    }

}
