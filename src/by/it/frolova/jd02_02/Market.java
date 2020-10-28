package by.it.frolova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static List<Cashier> cashiers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Market is opened");
        List<Thread> threads = new ArrayList<>();
        int buyerNumber = 0;

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Supervisor.marketIsOpen()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                threads.add(buyer);
            }
            Helper.timeout(1000);
            handleQueueChange(QueueToCashier.size());
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market is closed");
    }

    private static void handleQueueChange(int size) {
        System.out.println("queue size: " + size);
        int countCashiers = calcCashiers(size);
        for (Cashier cashier : cashiers) {
            if (countCashiers > 0) {
                cashier.open();
                countCashiers--;
            } else {
                cashier.close();
            }
        }
    }

    private static int calcCashiers(int queueSize) {
        if (queueSize == 0) {
            return 0;
        } else if (queueSize <= 5) {
            return 1;
        } else if (queueSize <= 10) {
            return 2;
        } else if (queueSize <= 15) {
            return 3;
        } else if (queueSize <= 20) {
            return 4;
        } else return 5;
    }
}
