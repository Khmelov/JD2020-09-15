package by.it.lapkovskiy.jd02_01;

class Supervisor extends Thread{
    static int buyersInMarket = 0;

    public static synchronized void upBuyers(){
        buyersInMarket ++;
    }
    public static synchronized void downBuyers(){
        buyersInMarket --;
    }
}
