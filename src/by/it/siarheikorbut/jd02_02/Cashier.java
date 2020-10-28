package by.it.siarheikorbut.jd02_02;

public class Cashier implements Runnable {
    private final String name;

    Cashier(int number) {
        name = "\tCashier №" + number;
    }

    private boolean isWait;

    public boolean isWait() {
        return isWait;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while (!Dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s started to service %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finished to service %s\n", this, buyer);
                if (Dispatcher.countBuyersInQueue > 0)
                    Dispatcher.decreaseCountBuyersInQueue();
                synchronized (buyer) {
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            } else {
                Helper.mySleep(1);
            }
        }
        System.out.printf("%s closed\n", this);
    }

    @Override
    public String toString() {
        return name;
    }
}