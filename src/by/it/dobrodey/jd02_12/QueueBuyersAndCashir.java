package by.it.dobrodey.jd02_12;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyersAndCashir {

    private static final Object monitor = new Object();
    private static final Object monCashier = new Object();
    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Cashier> dequeCashier = new LinkedList<>();

    static int getSizeCashier(){
        synchronized (monCashier){
            return dequeCashier.size();
        }
    }

    static int getSize(){
        synchronized (monitor){
            return deque.size();
        }
    }

    static void add(Buyer buyer) {
        synchronized (monitor) {
            deque.addLast(buyer);
        }
    }

    static Buyer extract() {
        synchronized (monitor) {
            return deque.pollFirst();
        }
    }
    static void closeCashier(Cashier cashier) {
        synchronized (monCashier) {
            dequeCashier.addLast(cashier);
            System.out.printf("%s closed\n", cashier);
        }
    }

    static Cashier openCashier() {
        synchronized (monCashier) {
            return dequeCashier.pollFirst();
        }
    }
}
