package by.it.arhipova.jd02_02;

public class Buyer extends Thread implements IBuyer {

    private boolean waiting;

    public Buyer(int number) {

        super("Buyer № " + number + " ");
        Supervisor.addBuyer();

    }
    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
    enterToTheShop();
    chooseGoods();
    goToQueue();
    goOut();
    Supervisor.leaveBuyer();
    }

    @Override
    public void enterToTheShop() {
        System.out.println(this + "enter to the shop");
    }


    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.sleep(timeout);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + "finished to choose goods");

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
    public void goOut() {
        Supervisor.leaveBuyer();
        System.out.println(this + " went out of the shop");

    }

    @Override
    public String toString() {
        return getName();
    }
}
