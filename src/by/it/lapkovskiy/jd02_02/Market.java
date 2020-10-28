package by.it.lapkovskiy.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static int buyerNumber = 1;

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        for (int second = 0; second < 120 && Supervisor.marketIsOpened(); second++) {
            if(second==0||second==56) addBuyers(10, threads);
             if(second==26 || second ==86) addBuyers(40, threads);
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

    private static void addBuyers(int count, List<Thread> threads) {
        for (int i = 0; i < count; i++) {
            Buyer buyer = new Buyer(++buyerNumber, buyerNumber % 4 == 0);
            buyer.start();
            threads.add(buyer);
        }
        Helper.timeout(20_000);
    }
}
