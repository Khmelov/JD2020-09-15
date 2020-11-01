package by.it.zubovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        int buyerNum=0;
        System.out.println("Shop opened!");
        List<Buyer>buyers=new ArrayList<>();
        for (int time = 0; time < 120; time++) {
            int count=Helper.getRandom(0, 2);
            for (int i = 0; i <= count; i++) {
                Buyer buyer=new Buyer(++buyerNum);
                buyer.start();
                buyers.add(buyer);
            }
            Helper.sleep(1000);
        }
        for (Buyer buyer: buyers){
            try {
                buyer.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Shop closed!");
    }
}
