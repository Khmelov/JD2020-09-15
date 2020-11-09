package by.it.siarheikorbut.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private QueueBuyers() {
    }

    private final static BlockingDeque<Buyer> QUEUE_BUYERS = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            QUEUE_BUYERS.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer extract() {
        return QUEUE_BUYERS.pollFirst();
    }

    public static int getSizeQUEUE_BUYERS() {
        return QUEUE_BUYERS.size();
    }
}