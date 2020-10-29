package by.it.lapkovskiy.jd02_03;

import java.util.concurrent.*;

public class Market {
    public static Semaphore baskets;
    public static Semaphore goIn;
    static int buyerNumber = 0;

    public static void main(String[] args) {
        baskets = new Semaphore(50);
        goIn = new Semaphore(20);
        System.out.println("Market opened");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executorService.execute(new Cashier(i));
        }
        ExecutorService executorBuyers = Executors.newFixedThreadPool(100);
        int cof = 0;
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
            addBuyers(cof, executorBuyers);
            Helper.timeout(1000);
        }
        executorBuyers.shutdown();
        executorService.shutdown();
        try {
            executorBuyers.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Market closed");
    }

    private static void addBuyers(int count,  ExecutorService executorBuyers) {
        for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
            executorBuyers.execute(new Buyer(++buyerNumber, buyerNumber % 4 == 0));
        }
    }
}
