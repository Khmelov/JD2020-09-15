package by.it.girovka.jd2_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <=5 ; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();

        while (Dispatcher.shopOpened()) {
            int count = Helper.getRandom(0, 2);
            for (int i = 0; !Dispatcher.planComplete() && i <= count; i++) {
                Buyer buyer = new Buyer(++number);
                Dispatcher.buyerAddToShop();
                buyer.start();
            }
            Helper.sleep(1000);
        }

        try {
            while( !threadPool.awaitTermination(1, TimeUnit.SECONDS));{

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Shop closed");

    }
}
