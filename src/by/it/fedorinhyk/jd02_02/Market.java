package by.it.fedorinhyk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        int BuyerNumber=0;
        System.out.println("Магазин открыт");
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <=2; i++) {
            Cashier cashier=new Cashier(i);
            Thread thread=new Thread(cashier);
            threads.add(thread);
            thread.start();
        }
        while (Supervisor.MarketIsOpened()){
            int count=Helper.getRandom(2);
            for (int i = 0; i < count && Supervisor.MarketIsOpened(); i++) {
                Buyer buyer=new Buyer(++BuyerNumber);
                buyer.start();
                threads.add(buyer);
            }
            Helper.timeout(1000);
        }

        for (Thread t:threads){
            try{
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Магазин закрыт");
    }
}
