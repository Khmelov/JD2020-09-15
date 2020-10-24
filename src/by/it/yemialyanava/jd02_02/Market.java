package by.it.yemialyanava.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();
        //List<Cashier> cashiers = new ArrayList<>();
            /*for (int i = 1; i <= countCashier; i++) {
                Cashier cashier = new Cashier(i);
                Thread thread = new Thread(cashier);
                threads.add(thread);
                thread.start();
            }*/
        int casherName = 1;
        while (Supervisor.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
                boolean pensionerLiOn = (buyerNumber + 1) % 4 == 0;
                Buyer buyer = new Buyer(++buyerNumber, pensionerLiOn);
                buyer.start();
                threads.add(buyer);
            }
            int countCashier;
            int buyerDemandNewCasher = QueueBuyers.countBuyerInQueue() - (Supervisor.cashierWorkNow() * 5);
            int demandedCasher = buyerDemandNewCasher / 5 + 1;
            if (Supervisor.cashierWorkNow() + demandedCasher <= 5){
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


