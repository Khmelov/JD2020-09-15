package by.it.girovka.jd2_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueBuyers {
    private static ArrayDeque<Buyer> queue = new ArrayDeque<>();


    static synchronized void add(Buyer buyer) {
        queue.addLast(buyer);
    }

    static synchronized Buyer extract() {
        return queue.pollFirst();


    }
}