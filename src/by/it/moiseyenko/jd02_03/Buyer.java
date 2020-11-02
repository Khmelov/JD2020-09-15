package by.it.moiseyenko.jd02_03;

class Buyer  extends Thread implements IBuyer, IUseBasket {
    private boolean waiting;

    Buyer(int number){
        this.setName("Buyer №"+number);
        Supervisor.addBuyer();
        waiting = false;
    }

    public  void setWaiting(boolean waiting){this.waiting=waiting;}

    @Override
    public void run(){
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        goOut();
        Supervisor.leaveBuyer();
    }


    @Override
    public void enterToMarket(){
        System.out.println(this + " enter to Market");
    }

    @Override
    public void takeBasket(){
        System.out.println(this + " take basket()");
    }

    @Override
    public void chooseGoods(){
        System.out.println(this + " started to chose goods");
        int timeout = Helper.getRandom(500,2000);
        Helper.timeout(timeout);
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

        System.out.println(this + " leave queue");

    }


    @Override
    public void goOut(){
        System.out.println(this + " leave the Market");
    }

    @Override
    public String toString() {
        return getName();
    }

}




