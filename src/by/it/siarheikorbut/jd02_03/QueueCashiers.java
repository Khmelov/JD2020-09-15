package by.it.siarheikorbut.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueCashiers {
    private QueueCashiers() {
    }

    private final static Deque<Cashier> QUEUE = new ArrayDeque<>();

    static void add(Cashier cashier) {
        synchronized (QUEUE) {
            QUEUE.addLast(cashier);
        }
    }

    static Cashier extract() {
        synchronized (QUEUE) {
            return QUEUE.pollFirst();
        }
    }
}