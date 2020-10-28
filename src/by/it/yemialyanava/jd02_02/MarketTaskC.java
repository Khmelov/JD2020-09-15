package by.it.yemialyanava.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class MarketTaskC {
    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();
        int casherName = 1;
        while (Supervisor.marketIsOpened()) {
            int actualNewBuyersCount = 0;
            for (int minute = 0; minute < 2; minute++) {
                for (int second = 1; second <= 60; second++) {
                    if (second == 1) {
                        actualNewBuyersCount = 10;
                    } else if ((second > 1 && second <= 30)) {
                        actualNewBuyersCount = second + 10 - Supervisor.countActualNumberOfBuyer();
                    } else if ((second > 30 && second <= 60)) {
                        actualNewBuyersCount = 40 + (30 - second) - Supervisor.countActualNumberOfBuyer();
                    }
                    for (int i = 0; i < actualNewBuyersCount; i++) {
                        if (Supervisor.marketIsOpened()) {
                            boolean pensionerLiOn = (buyerNumber + 1) % 4 == 0;
                            Buyer buyer = new Buyer(++buyerNumber, pensionerLiOn);
                            buyer.start();
                            threads.add(buyer);
                        }
                    }
                    //System.out.println(second + " - second, buyers : " + Supervisor.countActualNumberOfBuyer()
                      //      + " buyers correction " + actualNewBuyersCount);
                    Helper.timeout(1000);
                }
            }
            int countCashier;
            int commonBuyersInTwoQueue = QueueBuyers.countBuyerInQueue() + QueueBuyers.countBuyerInQueuePensioneer();
            int buyerDemandNewCasher = commonBuyersInTwoQueue - (Supervisor.cashierWorkNow() * 5);
            int demandedCasher = buyerDemandNewCasher / 5 + 1;
            if (Supervisor.cashierWorkNow() + demandedCasher <= 5) {
                countCashier = demandedCasher;
            } else {
                countCashier = 5 - Supervisor.cashierWorkNow();
            }
            for (int i = 1; i <= countCashier; i++) {
                Cashier cashier = new Cashier(casherName++);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }
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
}














