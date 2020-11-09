package by.it.siarheikorbut.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueCashier {

    private QueueCashier() {
    }

    private final static BlockingDeque<Cashier> QUEUE_CASHIER = new LinkedBlockingDeque<>(5);

    static void add(Cashier cashier) {
        try {
            QUEUE_CASHIER.putLast(cashier);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Cashier extract() {
        return QUEUE_CASHIER.pollFirst();
    }
}