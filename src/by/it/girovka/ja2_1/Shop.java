package by.it.girovka.ja2_1;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Shop opened");
        int number = 0;

        List<Buyer> buyers = new ArrayList<>();
        for(int time = 0; time< 120; time++){
            int count = Helper.getRandom(0, 2);
            for (int i = 0; i<=count; i++) {
                Buyer buyer = new Buyer(++number);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000);
            for (Buyer buyer : buyers){
                try {
                    buyer.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        Helper.sleep(2000);
        System.out.println("Shop closed");

    }
}
