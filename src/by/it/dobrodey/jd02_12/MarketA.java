package by.it.dobrodey.jd02_12;


import java.util.ArrayList;
import java.util.List;

public class MarketA {


    public static void main(String[] args) {
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            threads.add(thread);
            thread.start();
        }

        while (Supervisor.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                threads.add(buyer);
            }
            Helper.timeout(1000);
        }
//        for (int i = 0; i < 4; i++) {
//            synchronized (Cashier.monCashier1) {
//                Cashier cashier = QueueBuyersAndCashir.openCashier();
//                Cashier.monCashier1.notify();
//                System.out.printf("%s opened\n", cashier);
//            }
//        }

        for (Thread t : threads) {
            System.out.println(t);
       //     if (threads.contains())

            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        FileReadAndWrite.printInFile(FileReadAndWrite.FILENAME, Choose.goodsBuyerMap);
        System.out.printf("In market enter %d people and Leave %d people.\n In market %d people\n",
                Supervisor.getBuyerEnter(), Supervisor.getBuyerLeaved(), Supervisor.getBuyer());
        System.out.println("Market closed");
    }
}