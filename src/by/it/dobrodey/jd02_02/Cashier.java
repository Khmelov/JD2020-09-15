package by.it.dobrodey.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Cashier implements Runnable {

    private String name;
    private int number;
    private static volatile double totalMArketSum = 0;
    final static Object monCashier1 = new Object();

    public Cashier(int number) {
        this.number = number;
        this.name = "\tCashier №" + number;
    }
    public int getNumber(){return this.number;}


    @Override
    public void run() {
        String numberspace = Helper.spacecashier.repeat(this.number);
        System.out.printf("%s%s opened\n",numberspace, this.name);
        while (!Supervisor.marketIsClosed()) {
            if ((this.number!=1)) {
                synchronized (monCashier1) {
                    if (!Supervisor.queueClosed()) {
                        try {
                            QueueBuyersAndCashir.closeCashier(this);
                            monCashier1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                    }
                }
            }

            Buyer buyer = QueueBuyersAndCashir.extract();
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s %s started service for %s\n",numberspace, this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                Map<Buyer, HashMap<String, Double>> mapChooseBuyer = Choose.goodsBuyerMap;
                final HashMap<String, Double> shoppingList = mapChooseBuyer.get(buyer);
                final Set<String> shopping = shoppingList.keySet();
                double sum = 0;

                System.out.printf("%1$sIn %2$s\n%1$s%3$s bought:\n",numberspace, this, buyer);
                for (String s : shopping) {
                    System.out.printf("%s%-9s = %4.1f\n",numberspace, s, shoppingList.get(s));
                    sum += shoppingList.get(s);
                }
                totalMArketSum+=sum;
                System.out.printf("%sTOTAL     = %4.1f\n",numberspace, sum);
                System.out.println(Helper.spacetoalsupermarket+"TOTAL: "+totalMArketSum);
                System.out.printf("%s%s fifnshed service for %s\n",numberspace, this, buyer);


                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                Thread.yield();
            }
        }
        System.out.printf("%s%s closed\n",numberspace, this);
    }

    @Override
    public String toString() {
        return name;
    }
}
