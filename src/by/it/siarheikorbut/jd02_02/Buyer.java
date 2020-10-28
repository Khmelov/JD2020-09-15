package by.it.siarheikorbut.jd02_02;

import java.util.Map;

public class Buyer extends Thread implements IUseBasket, IBuyer {
    public Buyer(int number) {
        super("Buyer " + number);
        Dispatcher.buyerEnterToMarket();
        isWait = false;
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
        enterStore();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToQueue();
        leaveStore();
        Dispatcher.buyerLeaveMarket();
    }

    @Override
    public void enterStore() {
        System.out.printf("%s enter the market\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose the goods\n", this);
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s finished choosing the goods\n", this);
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s go to queue\n", this);
        Dispatcher.increaseCountBuyersInQueue();
        System.out.printf("Amount of buyers in the queue : %d\n", Dispatcher.countBuyersInQueue);
        synchronized (this) {
            QueueBuyers.add(this);
            isWait = true;
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
    public void leaveStore() {
        System.out.printf("%s leave the market\n", this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s take basket\n", this);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s started to put goods to the basket\n", this);
        int count = 0;
        int amountOfGoods = Helper.getRandom(1, 4);
        for (Map.Entry<String, String> entry : goods.entrySet()) {
            if (count == amountOfGoods) {
                break;
            }
            System.out.printf("%s put %s with price %s to his basket\n", this, entry.getValue(), entry.getKey());
            count++;
        }
        Helper.mySleep(Helper.getRandom(500, 2000));
        System.out.printf("%s finished putting goods to the basket\n", this);
    }
}