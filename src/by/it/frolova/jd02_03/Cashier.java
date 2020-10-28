package by.it.frolova.jd02_03;

import java.util.List;
import java.util.Objects;

public class Cashier implements Runnable {
    private boolean opened = false;
    private String name;

    public Cashier(int num) {
        this.name = "Cashier № " + num;
    }

    @Override
    public void run() {

        while (!Supervisor.marketIsClosed()) {
            Buyer buyer = QueueToCashier.extract();
            if (Objects.nonNull(buyer)) {
                System.out.printf("%s started service for %s\n", this, buyer);
                int timeout = Helper.getRandom(2000, 5000);
                Helper.timeout(timeout);
                printReceipt(buyer);
                System.out.printf("%s finished service for %s\n", this, buyer);
                synchronized (buyer) {
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            }
        }
    }

    private void printReceipt(Buyer buyer) {
        double total = 0;
        List<Good> goodsInBasket = buyer.getBasket().getGoods();
        for (Good g : goodsInBasket) {
            System.out.printf("%s: %s on price %f\n", buyer, g, Goods.getPrice(g));
            total += Goods.getPrice(g);
        }
        System.out.printf("\t# Receipt:\n\t%s\n\t%s\n\ttotal amount: %f\n", this, buyer, total);
    }

    @Override
    public String toString() {
        return name;
    }
}
