package by.it.siarheikorbut.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {

    private QueueBuyers() {
    }

    private final static Deque<Buyer> QUEUE_BUYERS =new ArrayDeque<>();

    static void add (Buyer buyer) {
        synchronized (QUEUE_BUYERS) {
            QUEUE_BUYERS.addLast(buyer);
        }
    }
    static Buyer extract () {
        synchronized (QUEUE_BUYERS) {
             return QUEUE_BUYERS.pollFirst();
        }

    }

    public static int getSizeQUEUE_BUYERS() {
        return QUEUE_BUYERS.size();
    }
    
}
