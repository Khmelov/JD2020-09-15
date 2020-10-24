package by.it.kolesnikov.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args){
        int buyerNumber=0;
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        for (int second = 0; second < 100; second++) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.timeOut(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
    }
}
