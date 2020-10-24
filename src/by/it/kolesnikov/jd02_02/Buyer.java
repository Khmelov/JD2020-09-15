package by.it.kolesnikov.jd02_02;



class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waiting;

    public Buyer(int number){
        this.setName("Buyer №"+number);
        Supervisor.addBuyer();
        waiting =false;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        choseGoods();
        putGoodsToBasket();
        goOut();
        Supervisor.marketIsClosed();
    }

    @Override
    public void takeBasket(){

        System.out.println(this+" took basket");
    }

    @Override
    public void putGoodsToBasket(){
        System.out.print(this+" put next goods into the basket: ");
        Basket.basket();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" entered to Market");
    }

    @Override
    public void choseGoods() {
        System.out.println(this+" started to choose goods");
        int timeout= Helper.getRandom(500, 2000);
        Helper.timeOut(timeout);
        System.out.println(this+" finished to choose goods");
    }

    @Override
    public void goToQueue() {
        System.out.println(this+" go to queue");
        synchronized (this) {
            waiting =true;
            QueueBuyers.add(this);
            while(waiting)
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(this+" left queue");
    }

    @Override
    public void goOut() {
        System.out.println(this+" went out of Market");
    }

}
