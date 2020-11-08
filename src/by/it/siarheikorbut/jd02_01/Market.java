package by.it.siarheikorbut.jd02_01;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) {
        MarketHelper marketHelper = new MarketHelper();
        marketHelper.getGoodToPrice();
        System.out.println("Market opened");
        int number = 0;
        ArrayList<Integer> buyerOfEverySecond = new ArrayList<>();
        int timeSecond;
        for (timeSecond = 1; timeSecond <= 120; timeSecond++) {
            int countBuyer = getCountBuyer(timeSecond);
            for (int j = 0; j < countBuyer; j++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                Dispatcher.BUYERS_IN_SHOP++;
            }
            Helper.mySleep(1000);
            buyerOfEverySecond.add(Dispatcher.BUYERS_IN_SHOP);
        }
        while (Dispatcher.BUYERS_IN_SHOP > 0) {
            Thread.yield();
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
            correct = 60;
        }
        if ((timeSecond <= 30 && timeSecond > 1) || (timeSecond <= 90 && timeSecond > 60)) {
            countBuyer = (timeSecond - correct + 11) - Dispatcher.BUYERS_IN_SHOP;
        }
        if (timeSecond <= 60 && timeSecond > 30 || timeSecond > 90) {
            if (Dispatcher.BUYERS_IN_SHOP <= 40 + (30 - timeSecond + correct)) {
                countBuyer = (41 + (30 - timeSecond + correct)) - Dispatcher.BUYERS_IN_SHOP;
            }
        }
        return countBuyer;
    }
}