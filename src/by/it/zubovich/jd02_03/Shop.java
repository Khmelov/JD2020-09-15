package by.it.zubovich.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        int buyerNum = 0;
        System.out.println("Shop opened!");

        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            String[] nameCashier = {
                    "Bob :-))",
                    "Toby :-[]"};
            String nameTemp;
            if (i == 1) {
                nameTemp = nameCashier[0];
            } else {
                nameTemp = nameCashier[1];
            }
            Cashier cashier = new Cashier(i + " " + nameTemp);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Manager.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Manager.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNum);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed!");
    }
}
