package by.it.siarheikorbut.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyersPensioneer {
    private QueueBuyersPensioneer() {
    }
    private final static Deque<Buyer> QUEUE_BUYERS_PENSIONEER =new ArrayDeque<>();

        static void addPensioneer (Buyer buyer) {
        synchronized (QUEUE_BUYERS_PENSIONEER) {
            QUEUE_BUYERS_PENSIONEER.addLast(buyer);
        }
    }
    static Buyer extractPensioneer () {
        synchronized (QUEUE_BUYERS_PENSIONEER) {
            return QUEUE_BUYERS_PENSIONEER.pollFirst();
        }

    }

    public static int getSizeQUEUE_BUYERS_PENSIONEER() {
        return QUEUE_BUYERS_PENSIONEER.size();
    }
}
