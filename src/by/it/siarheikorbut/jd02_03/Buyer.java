package by.it.siarheikorbut.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    private boolean isWait;

    private final List<Map.Entry<String, Integer>> goodsInBasket = new ArrayList<>();

    private final Dispatcher dispatcher;
    private final Semaphore countBuyersInShoppingRoom = new Semaphore(20);
    private final Semaphore baskets = new Semaphore(20);

    public List<Map.Entry<String, Integer>> getGoodsInBasket() {
        return goodsInBasket;
    }

    public void setWait(boolean wait) {
        isWait = wait;
    }

    public void setPensioner() {
        pensioner = true;
        System.out.printf("\t%s is pensioner \n", this);
    }

    public Buyer(int number, Dispatcher dispatcher) {
        super("Buyer №" + number);
        this.dispatcher = dispatcher;
        isWait = false;
        dispatcher.buyerEnterToMarket();
    }

    @Override
    public void run() {
        try {
            if (Helper.getRandom(1, 4) == 1) {
                setPensioner();
            }
            countBuyersInShoppingRoom.acquire();
            enterToMarket();
            baskets.acquire();
            takeBasket();
            int numberOfGoods = Helper.getRandom(1, 4);
            for (int i = 1; i <= numberOfGoods; i++) {
                chooseGoods();
                putGoodsToBasket();
            }
            goToQueue();
            goOut();
            dispatcher.buyerLeaveMarket();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            countBuyersInShoppingRoom.release();
            baskets.release();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.printf("%s enter to market\n", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s started to choose\n", this);
        int goodInPrice = MarketHelper.priceGoodSize();
        int numberGood = Helper.getRandom(1, goodInPrice);
        Map.Entry<String, Integer> randomGood = MarketHelper.takeOneRandomGood(numberGood);
        System.out.printf("%s take %s for price %d\n", this, randomGood.getKey(), randomGood.getValue());
        int timeout;
        if (pensioner) {
            timeout = (int) (Helper.getRandom(500, 2000) * 1.5);
        } else {
            timeout = Helper.getRandom(500, 2000);
        }
        Helper.mySleep(timeout);
        System.out.printf("%s finished to choose\n", this);
        goodsInBasket.add(randomGood);
    }

    @Override
    public void goToQueue() {
        System.out.printf("%s go to queue\n", this);
        synchronized (this) {
            if (!pensioner) QueueBuyers.add(this);
            else QueueBuyersPensioner.addPensioner(this);
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
    public void goOut() {
        System.out.printf("%s left market\n", this);
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s take basket\n", this);
        int timeout;
        if (pensioner) {
            timeout = (int) (Helper.getRandom(500, 2000) * 1.5);
        } else {
            timeout = Helper.getRandom(500, 2000);
        }
        Helper.mySleep(timeout);
    }

    @Override
    public void putGoodsToBasket() {
        System.out.printf("%s put good to basket\n", this);
        int timeout;
        if (pensioner) {
            timeout = (int) (Helper.getRandom(500, 2000) * 1.5);
        } else {
            timeout = Helper.getRandom(500, 2000);
        }
        Helper.mySleep(timeout);
    }

    @Override
    public String toString() {
        return (this.getName());
    }
}