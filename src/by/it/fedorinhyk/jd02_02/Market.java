package by.it.fedorinhyk.jd02_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Market {
    public static void main(String[] args) {
        int BuyerNumber=0;
        System.out.println("Магазин открыт");
        ExecutorService updateThreat = Executors.newFixedThreadPool(2);

        for (int i = 1; i <=2; i++) {
            Cashier cashier=new Cashier(i);
            updateThreat.execute(cashier);
        }
        updateThreat.shutdown();
        while (Supervisor.MarketIsOpened()){
            int count=Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.MarketIsOpened(); i++) {
                Buyer buyer=new Buyer(++BuyerNumber);
                buyer.start();
            }
            Helper.timeout(1000);
        }
        while (true){
            try { if (updateThreat.awaitTermination(1000, TimeUnit.SECONDS)) break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}
