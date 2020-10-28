package by.it.frolova.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueToCashier {
    private static final Object monitor = new Object();
    private static Deque<Buyer> deque = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (monitor) {
            return deque.pollFirst();
        }
    }


    static int size() {
        synchronized (monitor) {
            return deque.size();
        }
    }

}
