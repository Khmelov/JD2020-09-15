package by.it.yemialyanava.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {
    private static final Object monitor = new Object();
    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Buyer> dequePensioneer = new LinkedList<>();

    static void add(Buyer buyer){
        synchronized (monitor){
            if(buyer.pensioneer){
                dequePensioneer.addLast(buyer);
            }else{
                deque.addLast(buyer);
            }
        }
    }

    static Buyer extractPensioneer(){
        synchronized (monitor){
            return dequePensioneer.pollFirst();
        }
    }

    static int countBuyerInQueue(){
        synchronized (monitor){
            return deque.size();
        }
    }
    static int countBuyerInQueuePensioneer(){
        synchronized (monitor){
            return dequePensioneer.size();
        }
    }

    static Buyer extract(){
        synchronized (monitor){
            return deque.pollFirst();
        }
    }
}
