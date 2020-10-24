package by.it.lapkovskiy.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int cof;
        int buyerNumber = 0;
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        for (int second = 0; second < 120; second++) {
            if (second == 30) a = Supervisor.GetBuyers();
            if (second == 60) b = Supervisor.GetBuyers();
            if (second == 90) c = Supervisor.GetBuyers();

            if (((second < 30 || (second < 90 && second > 60)))) {
                if (Supervisor.GetBuyers() <= 30) cof = 40;
                else cof = 20;
            } else {
                if (Supervisor.GetBuyers() <= 15) cof = 5;
                else cof = 0;
            }
            for (int i = 0; i < cof; i++) {
                Buyer buyer = new Buyer(++buyerNumber, i % 4 == 0);
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
        System.out.println("Market closed");
        System.out.println("30:" + a);
        System.out.println("60:" + b);
        System.out.println("90:" + c);
        System.out.println("120:" + Supervisor.buyersInMarket);
    }
}
