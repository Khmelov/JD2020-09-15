package by.it.zubovich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {
    private static final Object monitor = new Object();
    private static final Deque<Buyer> deque = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }

    protected static Buyer extract() {
        synchronized (monitor) {
            return deque.pollFirst();
        }
    }
}
