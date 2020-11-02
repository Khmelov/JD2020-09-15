package by.it.siarheikorbut.jd02_03;

public class Cashier implements Runnable {
    private final String name;
    private final Dispatcher dispatcher;

    Cashier(int number, Dispatcher dispatcher) {
        name = "\tCashier №" + number;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        System.out.printf("%s open\n", this);
        System.out.flush();
        while (!dispatcher.marketIsClosed()) {
            Buyer buyer = QueueBuyers.extract();
            if (buyer != null) {
                System.out.printf("%s start to service %s\n", this, buyer);
                Helper.mySleep(Helper.getRandom(2000, 5000));
                System.out.printf("%s finish to service %s\n", this, buyer);
                if (Dispatcher.countBuyersInQueue > 0) {
                    Dispatcher.decreaseCountBuyersInQueue();
                    System.out.println("\t\tAmount of buyers in queue : " + Dispatcher.countBuyersInQueue);
                }
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            } else {
                Helper.mySleep(1);
            }
        }
        System.out.printf("%s close\n", this);
    }

    @Override
    public String toString() {
        return name;
    }
}

