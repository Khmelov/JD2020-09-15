package by.it.kolesnikov.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object monitor = new Object();

   static  Deque<Buyer> deque = new LinkedList<>();
   static volatile int countBuyers=0;

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
}
