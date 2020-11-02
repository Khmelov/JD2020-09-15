package by.it.arhipova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            threadPool.execute(cashier);
        }
        threadPool.shutdown();

        while (Supervisor.shopOpened()){
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.shopOpened(); i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        while (true){
            try {
                if (threadPool.awaitTermination(1, TimeUnit.MICROSECONDS)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Shop closed");
    }
    }
