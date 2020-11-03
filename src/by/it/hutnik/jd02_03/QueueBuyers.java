package by.it.hutnik.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {
    public static final BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer){
        try {
            queue.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static Buyer extract(){
        return queue.pollFirst();
    }
}
