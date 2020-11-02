package by.it.zubovich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {
    public static void main(String[] args) {
        int buyerNum = 0;
        System.out.println("Shop opened!");

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        String[] nameCashier = {
                "Bob :-))",
                "Toby :-[]",
                "Sam >:-))",
                "Jasper 8-))",
                "Frank 8-0"};
        for (int i = 1; i < 6; i++) {
            Cashier cashier = new Cashier(i + " " + nameCashier[i - 1]);
            fixedThreadPool.execute(cashier);
        }
        fixedThreadPool.shutdown();

        while (Manager.marketIsOpened()) {
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Manager.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNum);
                buyer.start();
            }
            Helper.sleep(1000);
        }
        while (true){
            try {
                if (fixedThreadPool.awaitTermination(10, TimeUnit.MICROSECONDS))
                    break;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Shop closed!");
    }
}
