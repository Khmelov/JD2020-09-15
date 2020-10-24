package by.it.dobrodey.jd02_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Cashier implements Runnable {

    private String name;
    final static Object monCashier1 = new Object();

    public Cashier(int number) {
        this.name = "\tCashier №" + number;
    }

    @Override
    public void run() {

        System.out.printf("%s opened\n", this);
        while (!Supervisor.marketIsClosed()) {
            if (!this.name.contains("1")) {

            synchronized (monCashier1) {
                if(!Supervisor.queueClosed()){
                try {
                        QueueBuyersAndCashir.closeCashier(this);
                        monCashier1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException();
                    }
                }}
            }
                Buyer buyer = QueueBuyersAndCashir.extract();
                if (Objects.nonNull(buyer)) {
                    System.out.printf("%s started service for %s\n", this, buyer);
                    int t = Helper.getRandom(2000, 5000);
                    Helper.timeout(t);
                    Map<Buyer, HashMap<String, Double>> mapChooseBuyer = Choose.goodsBuyerMap;
                    final HashMap<String, Double> shoppingList = mapChooseBuyer.get(buyer);
                    final Set<String> shopping = shoppingList.keySet();
                    double sum = 0;
                    System.out.printf("In %s %s bought:\n", this, buyer);
                    for (String s : shopping) {
                        System.out.printf("%9s = %4.1f\n", s, shoppingList.get(s));
                        sum += shoppingList.get(s);
                    }
                    System.out.printf("    Total = %4.1f\n", sum);
                    System.out.printf("%s fifnshed service for %s\n", this, buyer);

                    synchronized (buyer) {
                        buyer.setWaiting(false);
                        buyer.notify();
                    }
                } else {
                    Thread.yield();
                }
            }
        System.out.printf("%s closed\n", this);

        }
//            else {System.out.printf("%s closed\n", this);
//            synchronized (monCashier) {
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


    @Override
    public String toString() {
        return name;
    }

}
