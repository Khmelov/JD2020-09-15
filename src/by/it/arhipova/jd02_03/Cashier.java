package by.it.arhipova.jd02_03;

import java.util.Objects;

public class Cashier implements Runnable{
    private String name;

    Cashier(int number) {
        this.name = "\tCashier №" + number;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);

        while (!Supervisor.shopClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer!= null) {
                System.out.printf("%s started service for %s\n", this, buyer);
                int t = Helper.getRandom(2000, 5000);
                Helper.sleep(t);
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer){
                    buyer.setWaitState(false);
                    buyer.notify();
                    System.out.flush();
                }
            } else {
                Helper.sleep(100);
            }
        }

        System.out.printf("%s closed\n", this);
    }

    @Override
    public String toString() {
        return name;
    }
}
