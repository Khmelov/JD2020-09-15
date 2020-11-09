package by.it.siarheikorbut.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashier {

    private QueueCashier() {
    }

    private final static Deque<Cashier> QUEUE_CASHIER = new ArrayDeque<>();

    static void add(Cashier cashier) {
        synchronized (QUEUE_CASHIER) {
            QUEUE_CASHIER.addLast(cashier);
        }
    }

    static Cashier extract() {
        synchronized (QUEUE_CASHIER) {
            return QUEUE_CASHIER.pollFirst();
        }
    }
}
