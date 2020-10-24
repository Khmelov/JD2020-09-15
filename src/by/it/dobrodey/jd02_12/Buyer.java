package by.it.dobrodey.jd02_12;


import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waiting;

    Buyer(int number) {
        if (number % 4 == 0) {
            this.setName("Buyer pensioneer № " + number);
        } else {
            this.setName("Buyer № " + number);
        }
        Supervisor.addBuyer();
        waiting = false;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Supervisor.leaveBuyer();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market ");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "          " + "take basket");
    }

    @Override
    public void chooseGoods() {

        System.out.println(this + "                started to choose goods");
        int timer = Helper.getRandom(500, 2000);
        Helper.timeout(timer);
        System.out.println(this + "                  finished to choose goods");
    }

    @Override
    public void putGoodsToBasket() {
        HashMap<String, Double> goodsBuyer = new HashMap<>();
        int numberOfGoods = Helper.getRandom(1, 4);
        Map<String, Double> goods = Choose.getMap();
        Object[] setKey = goods.keySet().toArray();
        int koef = 2;
        for (int i = 0; i < numberOfGoods; i++) {
            int randomGoods = Helper.getRandom(goods.keySet().size() - 1);
            String key = (String) setKey[randomGoods];
            Double value = goods.get(key);
//            System.out.println(this + "                                put goods to basket "
//                    + key
//                    + " cost "
//                    + value);

            if (goodsBuyer.containsKey(key)) {
                double newvalue = value * koef++;
                goodsBuyer.put(key, newvalue);
            } else goodsBuyer.put(key, value);
            Helper.timeout(Helper.getRandom(500, 2000));
        }

        //printer on consol all goods
        String basket = goodsBuyer.toString().replace("{", "").
                replace("}", "").replace("=", " cost ");
        System.out.println(this + "                                   ALL goods to basket " + basket);
        Choose.goodsBuyerMap.put(this, goodsBuyer);
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");

        synchronized (this) {
            waiting = true;
            QueueBuyersAndCashir.add(this);
            Supervisor.addQueue();
            while (waiting)
                try {

                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println("!!!!!!!!!"+QueueBuyersAndCashir.getSize());
        if(Supervisor.queueClosed()){synchronized (Cashier.monCashier1) {
            for (int i = 1; i <= 4; i++) {
                Cashier cashier = QueueBuyersAndCashir.openCashier();}
            Cashier.monCashier1.notifyAll();
            System.out.printf("All CASHIERS opened\n");
        }}
        else if ((QueueBuyersAndCashir.getSize() > 20)) {
            synchronized (Cashier.monCashier1) {
                for (int i = 1; i <= 4; i++) {
                    Cashier cashier = QueueBuyersAndCashir.openCashier();}
                Cashier.monCashier1.notifyAll();
                System.out.printf("All CASHIERS opened\n");
            }
        } else
            if (QueueBuyersAndCashir.getSize() > 15) {
            synchronized (Cashier.monCashier1) {
                for (int i = 1; i <= 3; i++) {
                    Cashier cashier = QueueBuyersAndCashir.openCashier();
                    Cashier.monCashier1.notify();
                    System.out.printf("%s opened\n", cashier);
                }
            }
        } else if (QueueBuyersAndCashir.getSize() > 10) {
            synchronized (Cashier.monCashier1) {
                for (int i = 1; i <= 2; i++) {
                    Cashier cashier = QueueBuyersAndCashir.openCashier();
                    Cashier.monCashier1.notify();
                    System.out.printf("%s opened\n", cashier);
                }
            }
        } else {
            synchronized (Cashier.monCashier1) {
                Cashier cashier = QueueBuyersAndCashir.openCashier();
                Cashier.monCashier1.notify();
                System.out.printf("%s opened\n", cashier);
            }
        }

        System.out.println(this + " leave queue");
    }


    @Override
    public void goOut() {
        System.out.println(this + " go out market ");
    }

    @Override
    public String toString() {
        return getName();
    }
}
