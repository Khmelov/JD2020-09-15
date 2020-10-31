package by.it.lapkovskiy.jd02_03;


import java.util.HashMap;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waiting;
    public boolean pensioner;

    HashMap<String, Integer> basket;

    Buyer(int number, boolean pensioner) {
        if (pensioner) this.setName("Pensioner Buyer №" + number);
        else this.setName("Buyer №" + number);
        Supervisor.addBuyer();
        waiting = false;
        this.pensioner = pensioner;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        try {
            enterToMarket();
            takeBasket();
            goToQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goOut();
        Supervisor.leaveBuyer();
    }

    @Override
    public void enterToMarket() throws InterruptedException {
        System.out.println(this + " enter to Market");
        Market.goIn.acquire();
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int times = Helper.getRandom(1, 4);
        for (int i = 0; i < times; i++) {
            int timeout;
            if (pensioner) {
                timeout = Helper.getRandom(750, 3000);
            } else {
                timeout = Helper.getRandom(500, 2000);
            }
            Helper.timeout(timeout);
            putGoodsToBasket();
        }
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goToQueue(){
        System.out.println(this + " go to queue");
        synchronized (this) {
            waiting = true;
            while (waiting) {
                try {
                    if (pensioner) QueueBuyers.addPensioner(this);
                    else QueueBuyers.add(this);
                    Market.goIn.release();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }

        System.out.println(this + " leave queue");
    }

    @Override
    public void takeBasket() throws InterruptedException {
        Market.baskets.acquire();
        System.out.println(this + " take basket");
        basket = new HashMap<>();
    }

    public void putGoodsToBasket() {
        Goods.getGood(basket, this.getName());
    }

    @Override
    public void goOut() {
        Market.baskets.release();
        System.out.println(this + " leave the Market");
    }

    @Override
    public String toString() {
        return getName();
    }
}
