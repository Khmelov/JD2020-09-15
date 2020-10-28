package by.it.yemialyanava.jd02_03;

import java.util.Map;
import java.util.Objects;

public class Cashier implements Runnable {
    private String name;
    public static Object pause = new Object();

    public Cashier(int number) {
        this.name = "Cashier № " + number;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while(!Supervisor.marketIsClosed()) {
            Buyer buyer;
            if(QueueBuyers.countBuyerInQueuePensioneer() !=0){
                buyer = QueueBuyers.extractPensioneer();
            } else {
                buyer = QueueBuyers.extract();
            }
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s\n", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                Map<String, Double> buyersGoods = buyer.getMyGoods();
                double totalSumma = 0;
                StringBuilder bill = new StringBuilder();
                for (Map.Entry<String, Double> element : buyersGoods.entrySet()) {
                    String goodName = element.getKey();
                    Double goodPrice = element.getValue();
                    totalSumma += goodPrice;
                    bill.append("\t").append(goodName).append(" ").append(goodPrice).append("\n");
                }
                bill.append("total summa: ").append(totalSumma).append("\n");
                System.out.println(this + "  serviced " +  buyer + "\n " + bill.toString());
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                synchronized (pause){
                    Supervisor.cashierStopWork();
                    try {
                        Cashier.pause.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Supervisor.cashierWorkNow();
            }
        }
        System.out.printf("%s closed\n", this);
    }

    @Override
    public String toString() {
        return name;
    }
}
