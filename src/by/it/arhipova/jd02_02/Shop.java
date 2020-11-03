package by.it.arhipova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();

        }

        while (Supervisor.shopIsOpened()){
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i < count && Supervisor.shopIsOpened(); i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
        }
        Helper.sleep(2000);
        for (Thread buyer : threads) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed");

    }
}