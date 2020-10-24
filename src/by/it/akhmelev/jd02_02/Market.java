package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

//    public static void main(String[] args) {
//        Supervisor.buyersInMarket=0;
//        for (int i = 0; i < 1000; i++) {
//            main1(args);
//        }
//    }

    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Supervisor.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                threads.add(buyer);
            }
            Helper.timeout(1000);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
