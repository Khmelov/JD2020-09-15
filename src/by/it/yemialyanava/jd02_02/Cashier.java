package by.it.yemialyanava.jd02_02;

import java.util.Objects;

public class Cashier implements Runnable {
    private String name;

    public Cashier(int number){
        this.name = "\tCashier № " + number;
        Supervisor.addCashier();
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while (!Supervisor.marketIsClosed() && QueueBuyers.countBuyerInQueue() != 0){
            Buyer buyer = QueueBuyers.extract();
            if(Objects.nonNull(buyer)){
                System.out.printf("%s started service for %s\n", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.timeout(t);
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            }else {
                Thread.yield();
            }
        }
        System.out.printf("%s closed\n", this);
        Supervisor.cashierStopWork();
    }

    @Override
    public String toString() {
        return name;
    }
}
