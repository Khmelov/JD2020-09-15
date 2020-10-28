package by.it.frolova.jd02_03;

import java.util.Iterator;
import java.util.concurrent.Semaphore;


class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waiting;
    private boolean pens = false;
    int timeout;
    private Basket basket;
    private static final Semaphore available = new Semaphore(20);

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public Buyer(int number) {
        this.setName("Buyer № " + number);
        Supervisor.buyerEntered();
        if (number % 4 == 0) {
            pens = true;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Supervisor.buyersLeft();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to market");
    }

    @Override
    public void chooseGoods() {
        try {
            available.acquire();

        System.out.println(this + " started to choose");
        waitingTime();
        Helper.timeout(timeout);
        System.out.println(this + " finished to choose");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            available.release();
        }
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");
        synchronized (this) {
            waiting = true;
            QueueToCashier.add(this);
            while (waiting) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(this + " leave queue");
    }

    @Override
    public void goOut() {
        System.out.println(this + " went out of the market");

    }

    @Override
    public void takeBasket() {
        this.basket = new Basket();
        System.out.println(this + " took a basket");
    }

    @Override
    public void putGoodsToBasket() {
        if (this.basket != null) {
            waitingTime();
            int count = Helper.getRandom(1, 4);
            Iterator<Good> goodIterator = Goods.getGoods().iterator();
            for (int i = 0; i < count; i++) {
                Good g = goodIterator.next();
                basket.add(g);
                System.out.println(this + " put " + g + " to the basket");
                Helper.timeout(timeout);
            }
        }
    }

    public Basket getBasket() {
        return basket;
    }

    private void waitingTime() {
        if (pens) {
            timeout = Helper.getRandom(7500, 30000);
        } else {
            timeout = Helper.getRandom(500, 2000);
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
