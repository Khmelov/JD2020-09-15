package by.it.dobrodey.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class QueueBuyersAndCashir {

    private static final Object monitor = new Object();
    private static final Object monCashier = new Object();
    private static Deque<Buyer> deque = new LinkedList<>();
    private static Deque<Buyer> dequepensionner = new LinkedList<>();
    private static Deque<Cashier> dequeCashier = new LinkedList<>();

    static int getSizePensionner() {
        return dequepensionner.size();
    }
    static int getSize() {
        return deque.size() + dequepensionner.size();
    }

    static void add(Buyer buyer) {
        synchronized (monitor) {
            if(buyer.toString().contains("pensioneer")){dequepensionner.addLast(buyer);}
            else {deque.addLast(buyer);}
        }
    }

    static Buyer extract() {
        synchronized (monitor) {
            if(getSizePensionner()!=0){
                System.out.println("QueuePensionner:");
                return dequepensionner.pollFirst();}
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
