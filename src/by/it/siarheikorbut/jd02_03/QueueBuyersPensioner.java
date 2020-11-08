package by.it.siarheikorbut.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyersPensioner {

    private QueueBuyersPensioner() {
    }

    private final static BlockingDeque<Buyer> QUEUE_BUYERS_PENSIONER = new LinkedBlockingDeque<>(30);

    static void addPensioner(Buyer buyer) {
        try {
            QUEUE_BUYERS_PENSIONER.putLast(buyer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static Buyer extractPensioner() {
        return QUEUE_BUYERS_PENSIONER.pollFirst();
    }

    public static int getSizeQUEUE_BUYERS_PENSIONEER() {
        return QUEUE_BUYERS_PENSIONER.size();
    }
}