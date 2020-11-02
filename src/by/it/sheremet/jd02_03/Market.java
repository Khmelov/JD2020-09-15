package by.it.sheremet.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market open");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);



        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            fixedThreadPool.execute(cashier);

        }
        fixedThreadPool.shutdown();

        while (Supervisor.marketIsOpened()) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
            }
                Helper.timeout(1000);
            }
        while (true){
            try {
                if (fixedThreadPool.awaitTermination(10, TimeUnit.MICROSECONDS)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Market close");
        }

    }


