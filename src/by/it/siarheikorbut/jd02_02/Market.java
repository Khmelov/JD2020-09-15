package by.it.siarheikorbut.jd02_02;

import java.util.ArrayList;

public class Market {
    static ThreadGroup cashiers = new ThreadGroup("Группа потоков cashier");

    public static void main(String[] args) {
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        int number = 0;
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread threadCashier = new Thread(cashiers, cashier);
            threadCashier.start();
            threads.add(threadCashier);
        }
        Manager manager = new Manager("Manager");
        Thread threadManager = new Thread(manager);
        threadManager.setDaemon(true);
        threadManager.start();
        int timeSecond = 0;
        ArrayList<Integer> buyerOfEverySecond = new ArrayList<>();
        for (; ; ) {
            int countBuyer = getCountBuyer(timeSecond);
            for (int j = 0; j < countBuyer && Dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            if (!Dispatcher.marketIsOpenedForNewBuyer()) {
                break;
            }
            Helper.mySleep(1000);
            buyerOfEverySecond.add(Dispatcher.getCountEnterToMarket() - Dispatcher.getCountOutFromMarket());
            timeSecond++;
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
        for (int i = 0; i < buyerOfEverySecond.size(); i++) {
            System.out.printf("В секунду %d в магазине было %d\n", i, buyerOfEverySecond.get(i));
        }
    }

    private static int getCountBuyer(int timeSecond) {
        int countBuyer = 0;
        int correct = 0;
        if (timeSecond == 1) {
            countBuyer = 10;
        }
        if (timeSecond > 60) {
            correct = timeSecond / 60 * 60;
        }
        if ((timeSecond <= 30 + correct && timeSecond > 1 + correct) || (timeSecond <= 90 + correct && timeSecond > 60 + correct)) {
            countBuyer = (timeSecond - correct + 10) - (Dispatcher.getCountEnterToMarket() - Dispatcher.getCountOutFromMarket());
        }
        if (timeSecond <= 60 && timeSecond > 30 || timeSecond > 90) {
            if ((Dispatcher.getCountEnterToMarket() - Dispatcher.getCountOutFromMarket()) <= 40 + (30 - timeSecond + correct)) {
                countBuyer = (39 + (30 - timeSecond + correct)) - (Dispatcher.getCountEnterToMarket() - Dispatcher.getCountOutFromMarket());
            }
        }
        return countBuyer;
    }
}