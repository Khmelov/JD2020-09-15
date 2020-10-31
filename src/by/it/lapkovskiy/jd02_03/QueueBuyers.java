package by.it.lapkovskiy.jd02_03;

import java.util.concurrent.LinkedBlockingDeque;


public class QueueBuyers {

    private static final Object monitor = new Object();

    private static final LinkedBlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
            deque.addLast(buyer);
    }
    static void addPensioner(Buyer buyer) {
            deque.addFirst(buyer);
    }

    static Buyer extract() throws InterruptedException {
            return deque.pop();
    }
    static int getBuyerSize(){
        synchronized (monitor){
            return deque.size();
        }
    }
}
