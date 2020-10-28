package by.it.siarheikorbut.jd02_02;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market open");

        ArrayList<Thread> threads = new ArrayList<>();
        IntStream.rangeClosed(1, 2).mapToObj(Cashier::new).map(Thread::new).forEach(thread -> {
            thread.start();
            threads.add(thread);
        });
        int number = 0;
        for (; ; ) {
            for (int j = 0; j < Helper.getRandom(0, 2) && Dispatcher.marketIsOpenedForNewBuyer(); j++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                threads.add(buyer);
            }
            if (!Dispatcher.marketIsOpenedForNewBuyer())
                break;
            Helper.mySleep(1000);
        }

        threads.forEach(th -> {
                    try {
                        th.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        System.out.println("Market close");
    }
}