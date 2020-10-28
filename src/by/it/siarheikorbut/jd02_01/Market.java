package by.it.siarheikorbut.jd02_01;

public class Market {
    public static void main(String[] args) {
        System.out.println("Store is open!");
        int number = 0;
        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < Helper.getRandom(0, 2); j++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
        }
        while (Dispatcher.BUYERS_IN_SHOP > 0) {
            Thread.yield();
        }
        System.out.println("Market closed!");
    }
}