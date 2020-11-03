package by.it.hutnik.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Market {

    public static void main(String[] args) {
        System.out.println("Магазин открыт");
        int number = 0;
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 2; i++) {
            Cassir cassir = new Cassir(i);
            threadPool.execute(cassir);

        }
        threadPool.shutdown();

        while (Supervisor.marketOpen()) {
            int countBuyer = Helper.getRandom(2);
            for (int i = 0; Supervisor.marketOpen() && i <= countBuyer; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Supervisor.BUYERS_IN_SHOP++;
            }
            Helper.vremyaStop(1000);
        }
        try {
            while (threadPool.awaitTermination(1, TimeUnit.SECONDS)) {


            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Маазин закрыт");
    }
}