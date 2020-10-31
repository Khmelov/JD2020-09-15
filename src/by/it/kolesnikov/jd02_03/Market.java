package by.it.kolesnikov.jd02_03;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args){
        int buyerNumber=0;
        System.out.println("Market is opened");
        ExecutorService cashierPool = Executors.newFixedThreadPool(2);
        for (int i = 1; i <=2 ; i++) {
            Cashier cashier=new Cashier(i);
            cashierPool.execute(cashier);
        }
        cashierPool.shutdown();
        ExecutorService buyerPool = Executors.newFixedThreadPool(100);
        while (Supervisor.marketIsOpened()){
            int count = Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++buyerNumber);
                buyerPool.execute(buyer);
            }
            Helper.timeOut(1000);
        }
        buyerPool.shutdown();
        while (true){
            try {
                if (cashierPool.awaitTermination(100, TimeUnit.MICROSECONDS))
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }
}
