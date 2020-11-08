package by.it.siarheikorbut.jd02_03;

import java.util.List;
import java.util.Map;

public class Cashier implements Runnable {

    private final String name;

    private final Dispatcher dispatcher;

    private final int number;

    private boolean isWait;

    public void setWait(boolean wait) {
        isWait = wait;
    }

    public Cashier(int number, Dispatcher dispatcher) {
        name = "\tCashier №" + number;
        this.number = number;
        this.dispatcher = dispatcher;
        isWait = false;
    }

    @Override
    public void run() {
        System.out.printf("%s opened\n", this);
        while (!dispatcher.marketIsClosed()) {
            Buyer buyer;
            if (QueueBuyersPensioner.getSizeQUEUE_BUYERS_PENSIONEER() != 0) {
                buyer = QueueBuyersPensioner.extractPensioner();
            } else buyer = QueueBuyers.extract();
            Manager.cashiersTurnOn();
            if (buyer != null) {
                System.out.printf("%s started to service %s\n", this, buyer);
                checkBasket(buyer);
                System.out.printf("%s finished to service %s\n", this, buyer);
                //noinspection SynchronizationOnLocalVariableOrMethodParameter
                synchronized (buyer) {
                    buyer.setWait(false);
                    buyer.notify();
                }
                Helper.mySleep(Helper.getRandom(2000, 5000));
            }
            goToQueueCashier();
        }
        System.out.printf("%s closed\n", this);
    }

    private void checkBasket(Buyer buyer) {
        List<Map.Entry<String, Integer>> goodsInBasket = buyer.getGoodsInBasket();
        int sumInCheck = 0;
        StringBuilder check = new StringBuilder();
        check.append("Check for ").append(buyer.getName()).append("\n");
        check.append("Cashier №1      ")
                .append("Cashier №2      ")
                .append("Cashier №3      ")
                .append("Cashier №4      ")
                .append("Cashier №5      ")
                .append("Queue size      ")
                .append("Total           \n");
        for (Map.Entry<String, Integer> good : goodsInBasket) {
            check.append("\t\t\t\t".repeat(Math.max(0, number - 1)));
            sumInCheck += good.getValue();
            check.append(good.getKey()).append(": ").append(good.getValue()).append("\n");
        }
        check.append("\t\t\t\t".repeat(Math.max(0, number - 1)));
        check.append("Sum: ").append(sumInCheck).append("\n");

        MarketHelper.setSumForMarket(sumInCheck);

        check.append("\t\t\t\t".repeat(5));
        check.append(QueueBuyers.getSizeQUEUE_BUYERS());
        if (QueueBuyers.getSizeQUEUE_BUYERS() < 10) check.append("       \t\t");
        if (QueueBuyers.getSizeQUEUE_BUYERS() > 10) check.append("      \t\t");
        check.append(MarketHelper.getSumForMarket()).append("\n");
        System.out.printf("%s", check);
    }

    public void goToQueueCashier() {
        synchronized (this) {
            QueueCashier.add(this);
            isWait = true;
            Manager.cashiersTurnOff();
            while (isWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}