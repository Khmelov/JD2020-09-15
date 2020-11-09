package by.it.siarheikorbut.jd02_02;

public class Manager implements Runnable {

    private final String name;

    public Manager(String name) {
        this.name = name;
    }

    private volatile static int countActiveCashiers = 0;

    static synchronized void cashiersTurnOn() {
        countActiveCashiers++;
    }

    static synchronized void cashiersTurnOff() {
        countActiveCashiers--;
    }

    @Override
    public void run() {
        for (; ; ) {

            int sizeQueue = QueueBuyers.getSizeQUEUE_BUYERS()
                    + QueueBuyersPensioneer.getSizeQUEUE_BUYERS_PENSIONEER();
            if (sizeQueue == 0) {
                activateCashier();
            }
            if (sizeQueue > 0 && sizeQueue <= 5 && countActiveCashiers != 1) {
                for (int i = 0; i < 1 - countActiveCashiers; i++) {
                    activateCashier();
                }
            } else if (sizeQueue > 5 && sizeQueue <= 10 & countActiveCashiers != 2) {
                for (int i = 0; i < 2 - countActiveCashiers; i++) {
                    activateCashier();
                }
            } else if (sizeQueue > 10 && sizeQueue <= 15 & countActiveCashiers != 3) {
                for (int i = 0; i < 3 - countActiveCashiers; i++) {
                    activateCashier();
                }
            } else if (sizeQueue > 15 && sizeQueue <= 20 & countActiveCashiers != 4) {
                for (int i = 0; i < 4 - countActiveCashiers; i++) {
                    activateCashier();
                }
            } else if (sizeQueue > 20 & countActiveCashiers != 5) {
                for (int i = 0; i < 5 - countActiveCashiers; i++) {
                    activateCashier();
                }
            }
        }
    }

    private void activateCashier() {
        Cashier cashier = QueueCashier.extract();
        if (cashier != null) {
            synchronized (cashier) {
                cashier.setWait(false);
                cashier.notify();
            }
        } else {
            Helper.mySleep(1);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}