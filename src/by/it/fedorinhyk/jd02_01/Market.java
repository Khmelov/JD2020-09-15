package by.it.fedorinhyk.jd02_01;

import java.util.ArrayList;

public class Market {
    public static void main(String[] args) {
        int BuyerNumber=0;
        System.out.println("Магазин открыт");
        final ArrayList<Buyer> buyers = new ArrayList<>();
        for (int seconds = 0; seconds <120 ; seconds++) {
            int count=Helper.getRandom(2);
            for (int i = 0; i < count; i++) {
                 Buyer buyer = new Buyer(++BuyerNumber);
                 buyer.start();
                 buyers.add(buyer);
            }
            Helper.timeout(1000);
        }
        for (Buyer buyer:buyers){
            try{ buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}
