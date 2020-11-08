package by.it.siarheikorbut.jd02_03;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(100);
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        int number = 0;
        ExecutorService executorServiceCashier = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i, dispatcher);
            executorServiceCashier.execute(cashier);
        }
        executorServiceCashier.shutdown();
        Manager manager = new Manager("Manager");
        Thread threadManager = new Thread(manager);
        threadManager.setDaemon(true);
        threadManager.start();
        int timeSecond = 0;
        ArrayList<Integer> buyerOfEverySecond = new ArrayList<>();
        ExecutorService executorServiceBuyer = Executors.newFixedThreadPool(dispatcher.totalBuyersCount);
        for (; ; ) {
            int countBuyer = getCountBuyer(timeSecond, dispatcher);
            for (int j = 0; j < countBuyer && dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer = new Buyer(++number, dispatcher);
                executorServiceBuyer.execute(buyer);
            }
            if (!dispatcher.marketIsOpenedForNewBuyer()) {
                break;
            }
            Helper.mySleep(1000);
            buyerOfEverySecond.add(dispatcher.getCountEnterToMarket() - dispatcher.getCountOutFromMarket());
            timeSecond++;
        }
        executorServiceBuyer.shutdown();
        try {
            while (!executorServiceCashier.awaitTermination(1, TimeUnit.DAYS)) {
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Market closed");
        for (int i = 0; i < buyerOfEverySecond.size(); i++) {
            System.out.printf("В секунду %d в магазине было %d\n", i, buyerOfEverySecond.get(i));
        }
    }

    private static int getCountBuyer(int timeSecond, Dispatcher dispatcher) {
        int countBuyer = 0;
        int correct = 0;
        if (timeSecond == 1) {
            countBuyer = 10;
        }
        if (timeSecond > 60) {
            correct = timeSecond / 60 * 60;
        }
        if ((timeSecond <= 30 + correct && timeSecond > 1 + correct) || (timeSecond <= 90 + correct && timeSecond > 60 + correct)) {
            countBuyer = (timeSecond - correct + 10) - (dispatcher.getCountEnterToMarket() - dispatcher.getCountOutFromMarket());
        }
        if (timeSecond <= 60 && timeSecond > 30 || timeSecond > 90) {
            if ((dispatcher.getCountEnterToMarket() - dispatcher.getCountOutFromMarket()) <= 40 + (30 - timeSecond + correct)) {
                countBuyer = (39 + (30 - timeSecond + correct)) - (dispatcher.getCountEnterToMarket() - dispatcher.getCountOutFromMarket());
            }
        }
        return countBuyer;
    }
}