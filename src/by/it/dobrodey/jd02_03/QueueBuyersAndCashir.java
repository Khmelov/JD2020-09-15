package by.it.dobrodey.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueBuyersAndCashir {



    private static BlockingDeque<Buyer> deque = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Buyer> dequepensionner = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Cashier> dequeCashier = new LinkedBlockingDeque<>(5);

    static int getSize() {
        return deque.size() + dequepensionner.size();
    }
    static int getSizePensionner() {
        return dequepensionner.size();
    }

    static void add(Buyer buyer) {
        {
            if (buyer.toString().contains("pensioneer")) {
                try {
                    dequepensionner.putLast(buyer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    deque.putLast(buyer);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static Buyer extract() {
        if(getSizePensionner()!=0){
            System.out.println("QueuePensionner:");
            return dequepensionner.pollFirst();
        }
        else {return deque.pollFirst();}
    }



    static void closeCashier(Cashier cashier) {
        dequeCashier.addFirst(cashier);
        System.out.printf("%s closed\n", cashier);
    }

    static Cashier openCashier() {
        return dequeCashier.pollFirst();
    }
}

