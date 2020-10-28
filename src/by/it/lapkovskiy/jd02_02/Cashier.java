package by.it.lapkovskiy.jd02_02;

import java.util.Map;
import java.util.Objects;

public class Cashier implements Runnable {

    private final String name;
    private int number = 0;
    private boolean worked = false;

    public Cashier(int number) {
        this.name = "\tCashier №" + number;
        this.number = number;
    }

    @Override
    public void run() {
        while (!Supervisor.marketIsClosed()) {
            if (QueueBuyers.getBuyerSize() > (number - 1) * 5) {
                if (!worked) {
                    System.out.printf("%s opened\n", this);
                    worked = true;
                }
            } else {
                if (worked) {
                    System.out.printf("%s closed\n", this);
                    worked = false;
                }
                continue;
            }
            Buyer penBuyer  = QueueBuyers.extractPensioner();
            Buyer buyer;
            if(Objects.nonNull(penBuyer)) {
                buyer = penBuyer;
            }
            else buyer = QueueBuyers.extract();
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s\n", this, buyer);

                PrintCheck(buyer);

                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            } else {
                Thread.yield();
            }
        }
    }

    private void PrintCheck(Buyer buyer) {
        synchronized (System.out) {
            try {
                System.out.printf("%" + (number) * 30 + "s", this + "----------------");
                System.out.printf("%" + (6 - number) * 30 + "s", "");
                System.out.printf("%10s  %s\n", "Queue:" + QueueBuyers.getBuyerSize(),"TotalMarket:"+Supervisor.GetTotal());

                System.out.printf("%" + (number) * 30 + "s\n", buyer + " bought");
                int total = 0;
                for (Map.Entry<String, Integer> good : buyer.basket.entrySet()) {
                    System.out.printf("%" + (number) * 30 + "s\n", good.toString());
                    total += good.getValue();
                }
                Supervisor.upTotal(total);
                System.out.printf("%" + (number) * 30 + "s\n", "Total:" + total);
                System.out.printf("%" + (number) * 30 + "s\n", "--------------------------");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
