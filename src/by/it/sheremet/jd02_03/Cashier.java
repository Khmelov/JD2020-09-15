package by.it.sheremet.jd02_03;

import java.util.Map;
import java.util.Objects;

class Cashier implements Runnable {

    private final String name;
    private int number = 0;
    private boolean work = false;


    Cashier(int number) {
        this.name = "Cashier № " + number;
        this.number = number;

    }


    @Override
    public void run() {
        while (!Supervisor.marketIsClosed()) {
            Buyer buyer;
            if (QueueBuyers.buyerSize() > (number - 1) * 5) {
                if (!work) {
                    System.out.printf("%s opened\n", this);
                    work = true;
                }
            } else {
                if (work) {
                    System.out.printf("%s closed\n", this);
                    work = false;
                }
                continue;
            }

                    buyer = QueueBuyers.extract();
                    if (Objects.nonNull(buyer)) {
                        System.out.printf("%s start service for %s\n", this, buyer);
                        int t = Helper.getRandom(2000, 5000);
                        Helper.timeout(t);
                        double price = 0;
                        Map<String,Double> buyersBasket = buyer.getBasketGoods();
                        for (Map.Entry<String,Double>products:buyersBasket.entrySet()) {
                            String product = products.getKey();
                            Double cost = products.getValue();
                            price += cost;
                            System.out.println(buyer+" buy "+product+" for "+cost);
                        }
                        System.out.println(buyer+" total price: "+price);
                        System.out.printf("%s finish service for %s\n", this, buyer);
                        synchronized (buyer) {
                            buyer.setWaiting(false);
                            buyer.notify();
                        }
                    } else {
                        Thread.yield();
                    }
                }

            }



    @Override
    public String toString () {
        return name;
    }
}