package by.it.zubovich.jd02_02;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean waiting;

    Buyer(int number) {
        this.setName("Buyer № " + number + ":");
        Manager.addBuyer();
        waiting = false;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        //Manager.buyersInMarket++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Manager.leftBuyer();
        //Manager.buyersInMarket--;
    }

    @Override
    public void enterToMarket() {

        System.out.println(this + " enter to Shop");
    }

    @Override
    public void takeBasket() {

        System.out.println(this + " take basket");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void putGoodsToBasket() {

        System.out.println(this + " put goods to basket");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");
        synchronized (this) {
            waiting = true;
            QueueBuyers.add(this);
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this + " left queue");
    }

    @Override
    public void goOut() {

        System.out.println(this + " left the Shop");
    }

    @Override
    public String toString() {

        return getName();
    }
}




