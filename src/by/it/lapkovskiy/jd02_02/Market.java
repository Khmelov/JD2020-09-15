package by.it.lapkovskiy.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    static int buyerNumber = 0;

    public static void main(String[] args) {
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        int cof=0;
        for (int second = 0; second < 120 && Supervisor.marketIsOpened(); second++) {

            if ((second <= 30) || (second >= 60 && second <= 90)) {
                if (Supervisor.inCountBuyersMarket() >= (second % 30) + 10) {
                    cof = 0;
                } else cof = (second % 30) + 10-Supervisor.inCountBuyersMarket();
            } else {
                if (Supervisor.inCountBuyersMarket() <= 40 + (30 - (second % 30))) {
                    cof = 40 + 30 - (second % 30)-Supervisor.inCountBuyersMarket();
                } else cof = 0;
            }
            addBuyers(cof,threads);
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
        for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
            Buyer buyer = new Buyer(++buyerNumber, buyerNumber % 4 == 0);
            buyer.start();
            threads.add(buyer);
        }
    }
}
