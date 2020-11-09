package by.it.siarheikorbut.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    public void setPensioner() {
        pensioner = true;
        System.out.printf("%s is pensioner \n", this);
    }

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        if (Helper.getRandom(1, 4) == 1) {
            setPensioner();
        }
        enterToMarket();
        takeBasket();
        int numberOfGoods = Helper.getRandom(1, 4);
        for (int i = 1; i <= numberOfGoods; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goOut();
        Dispatcher.BUYERS_IN_SHOP--;
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
            timeout = Helper.getRandom(500, 2000)
            ;
        }
        Helper.mySleep(timeout);
    }

    @Override
    public String toString() {
        return (this.getName());
    }
}