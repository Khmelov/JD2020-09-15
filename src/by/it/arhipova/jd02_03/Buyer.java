package by.it.arhipova.jd02_03;

public class Buyer extends Thread implements IBuyer {

    private boolean waitState;

    public void setWaitState(boolean waitState) {

    }

     Buyer(int number) {
         this.setName("Buyer №" + number);
         Supervisor.addBuyer();
         waitState = false;
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
            QueueBuyers.add(this);
            waitState = true;
            while(waitState)
            try {
                System.out.println(this + " go to queue");
                this.wait();
                System.out.println(this + " leave queue");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
