package by.it.yemialyanava.jd02_01;

public class Supervisor {

    private static int buyerInTheMarket = 0;

    static synchronized void addBuyer(){
        buyerInTheMarket++;
    }

    static void leaveBuyer(){
        buyerInTheMarket--;
    }

    static int getBuyerInMarket(){
        return buyerInTheMarket;
    }

}
