package by.it.siarheikorbut.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    private QueueBuyers() {
    }

    private final static BlockingDeque<Buyer> QUEUE = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            QUEUE.putLast(buyer);
            System.out.println(QUEUE.size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer extract() {
        return QUEUE.pollFirst();
    }
}
