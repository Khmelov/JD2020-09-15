package by.it.lapkovskiy.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int sec30 = 0;
        int sec60 = 0;
        int sec90 = 0;
        int cof = 10;
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        for (int second = 0; second < 120 ; second++) {
            if ((second <= 30) || (second >= 60 && second <= 90)) {
                cof = (second%60) + 10 - Supervisor.buyersInMarket;
            } else {
                cof = 40 + (30 - second) - Supervisor.buyersInMarket;
            }
                for (int i = 0; i < cof; i++) {
                    Buyer buyer = new Buyer(++buyerNumber, buyerNumber % 4 == 0);
                    buyer.start();
                    buyers.add(buyer);
                }
            if (second == 30) sec30 = Supervisor.buyersInMarket;
            if (second == 60) sec60 = Supervisor.buyersInMarket;
            if (second == 90) sec90 = Supervisor.buyersInMarket;
            Helper.timeout(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Market closed");
        System.out.println("30:" + sec30);
        System.out.println("60:" + sec60);
        System.out.println("90:" + sec90);
        System.out.println(Supervisor.buyersInMarket);
    }
}
