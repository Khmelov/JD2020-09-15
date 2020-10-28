package by.it.dobrodey.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        System.out.printf("%-21s enter to market\n", this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%-21s take basket\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%-40s started to choose goods\n", this);
        int timer = Helper.getRandom(500, 2000);
        Helper.timeout(timer);
        System.out.printf("%-60s finished to choose goods\n", this);
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
            if (goodsBuyer.containsKey(key)) {
                double newvalue = value * koef++;
                goodsBuyer.put(key, newvalue);
            } else goodsBuyer.put(key, value);
            Helper.timeout(Helper.getRandom(500, 2000));
        }
        //printer on consol all goods
        String basket = goodsBuyer.toString().replace("{", "").
                replace("}", "").replace("=", " cost ");
        System.out.printf(" %-80s ALL goods to basket %s\n ", this, basket.toString());
        Choose.goodsBuyerMap.put(this, goodsBuyer);
    }

    @Override
    public void goToQueue() {
        System.out.printf("%-21s go to queue\n", this);
        synchronized (this) {
            waiting = true;
            QueueBuyersAndCashir.add(this);
            //System.out.println(Helper.spaceQueue+"QUEUE: "+QueueBuyersAndCashir.getSize());
            Supervisor.addQueue();
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(Helper.spaceQueue + "QUEUE: " + QueueBuyersAndCashir.getSize());
        int numberOpenCassir;
        if((Supervisor.queueClosed())){numberOpenCassir = 5;}
        else if ((QueueBuyersAndCashir.getSize() >= 20)) {
            numberOpenCassir = 5;
        } else if (QueueBuyersAndCashir.getSize() >= 15) {
            numberOpenCassir = 4;
        } else if (QueueBuyersAndCashir.getSize() >= 10) {
            numberOpenCassir = 3;
        } else if (QueueBuyersAndCashir.getSize() >= 5) {
            numberOpenCassir = 2;
        } else {
            numberOpenCassir = 1;
        }
        synchronized (Cashier.monCashier1) {
            System.out.printf("%sWorked %d CASHIERS\n", Helper.spaceQueue, numberOpenCassir);
            if (numberOpenCassir == 1) {
                System.out.println("Cashier №1 worked alone");
            } else {
                for (int i = 1; i < numberOpenCassir; i++) {
                    Cashier cashier = QueueBuyersAndCashir.openCashier();
                    if (Objects.nonNull(cashier)) {
                        Cashier.monCashier1.notify();
                        System.out.printf("%s opened\n", cashier.toString());
                    } else Thread.yield();
                }
            }
        }

        System.out.printf("%-21s leave queue\n", this);
    }

    @Override
    public void goOut() {
        System.out.printf("%-21s go out market\n ", this);
    }

    @Override
    public String toString() {
        return getName();
    }
}
