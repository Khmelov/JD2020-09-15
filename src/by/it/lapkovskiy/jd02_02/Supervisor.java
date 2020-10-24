package by.it.lapkovskiy.jd02_02;

class Supervisor extends Thread{
    static int buyersInMarket = 0;

    public static synchronized void upBuyers(){
        buyersInMarket ++;
    }
    public static synchronized void downBuyers(){
        buyersInMarket --;
    }
    public static synchronized int GetBuyers(){
        return buyersInMarket;
    }
}
