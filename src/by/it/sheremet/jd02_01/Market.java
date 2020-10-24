package by.it.sheremet.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int buyerNumber=0;
        System.out.println("Market open");
        List<Buyer>buyers = new ArrayList<>();
        for (int time = 0; time < 120; time++) {
          int count = Helper.getRandom(0,2);
            for (int i = 0; i <= count; i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.timeout(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market close");
    }
}
