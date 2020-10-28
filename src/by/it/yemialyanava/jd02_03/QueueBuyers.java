package by.it.yemialyanava.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyers {

    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Buyer> dequePensioneer = new LinkedBlockingDeque<>(8);

    static void add(Buyer buyer){
        try{
            if (buyer.pensioneer){
                dequePensioneer.putLast(buyer);
            } else{
                deque.putLast(buyer);
            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    static Buyer extractPensioneer(){
            return dequePensioneer.pollFirst();
    }

    static int countBuyerInQueue(){
            return deque.size();
    }
    static int countBuyerInQueuePensioneer(){
            return dequePensioneer.size();
    }

    static Buyer extract(){
            return deque.pollFirst();
    }
}
