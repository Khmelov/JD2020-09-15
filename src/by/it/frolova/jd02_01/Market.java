package by.it.frolova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {


    public static void main(String[] args) {

        System.out.println("Market open");
        List<Buyer> buyers = new ArrayList<>();
        int buyerNumber = 0;

        for (int second = 0; second < 120; second++) {
            int buyersIn;
            if ((second < 30) || (second > 60 && second < 90)) {
                buyersIn = second + 10 - Supervisor.buyersInMarket;
            } else {
                buyersIn = 40 + (30 - second) - Supervisor.buyersInMarket;
            }

            for (int i = 0; i < buyersIn; i++) {
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
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }
}
