package by.it.girovka.jd2_3;

class Buyer extends Thread implements IBuyer {

   private  boolean waitState = false;

    public void setWaitState(boolean waitState) {
        this.waitState = waitState;
    }

    public Buyer (int number) {
        super("Buyer N" +number+" ");
        Dispatcher.buyerAddToShop();
    }



    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();


    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to shop");

    }

    @Override
    public void chooseGoods()  {
        System.out.println(this+"started to choose goods");
        int timeout= Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        System.out.println(this+"finished to choose goods");

    }

    @Override
    public void goToQueue() {
        synchronized (this) {
            QueueBuyers.add(this);
            waitState = true;
            while (waitState)
            try {
                System.out.println(this+" added to queue");
                this.wait();
                System.out.println(this+ " leave the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void goOut() {
        System.out.println(this+" leave to shop");
        Dispatcher.buyerLeaveShop();
    }

    @Override
    public String toString() {
        return getName();
    }
}
