package by.it.frolova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {

        System.out.println("Market is opened");
        int buyerNumber = 0;

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            fixedThreadPool.execute(cashier);
        }
        fixedThreadPool.shutdown();

        while (Supervisor.marketIsOpen()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
            }
            Helper.timeout(1000);
        }

        while (true) {
            try {
                if (fixedThreadPool.awaitTermination(10, TimeUnit.MILLISECONDS))
                    break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Market is closed");
    }
}
