package by.it.frolova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueToCashier {
    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            deque.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer extract() {
        return deque.pollFirst();
    }
}
