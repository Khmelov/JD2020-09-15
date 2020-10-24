package by.it.yemialyanava.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int buyerNumber = 0;
        int actualCount = 0;
        System.out.println("Market opened");
        List<Buyer> buyers = new ArrayList<>();
        for (int minute = 0; minute < 2; minute++) {
            for (int second = 1; second <= 60; second++) {
                if (second == 1) {
                    actualCount = 10;
                } else if ((second > 1 && second <= 30) ) {
                    actualCount = second + 10 - Supervisor.getBuyerInMarket();
                } else if ((second > 30 && second <= 60)) {
                    actualCount = 40 + (30 - second) - Supervisor.getBuyerInMarket();
                }
                for (int i = 0; i < actualCount; i++) {
                    boolean pensionerLiOn = (buyerNumber + 1) % 4 == 0;
                    Buyer buyer = new Buyer(++buyerNumber, pensionerLiOn);
                    buyer.start();
                    buyers.add(buyer);
                }
                System.out.println(second + " - second, buyers : " + Supervisor.getBuyerInMarket() + " buyers correction " + actualCount);
                Helper.timeout(1000);
            }
        }
        //решение до  задания С
        /*for (int second = 0; second < 120; second++) {
            //int count = Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                boolean pensionerLiOn = (buyerNumber+1) % 4 ==0;
                Buyer buyer = new Buyer (++buyerNumber, pensionerLiOn);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.timeout(1000);
        }*/
        for (Buyer buyer:buyers) {
            try{
                buyer.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }
        System.out.println("Market closed");
    }
}
