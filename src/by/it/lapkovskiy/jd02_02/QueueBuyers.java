package by.it.lapkovskiy.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyers {

    private static final Object monitor = new Object();

    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Buyer> dequePensioners = new LinkedList<>();

    static void add(Buyer buyer) {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }
    static void addPensioner(Buyer buyer) {
        synchronized (monitor) {
            dequePensioners.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (monitor) {
            return deque.pollFirst();
        }
    }
    static Buyer extractPensioner() {
        synchronized (monitor) {
            return dequePensioners.pollFirst();
        }
    }
    static int getBuyerSize(){
        synchronized (monitor){
            return deque.size()+dequePensioners.size();
        }
    }
}
