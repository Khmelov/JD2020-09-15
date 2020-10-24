package by.it.sheremet.jd02_01;

import java.util.Map;

public class Buyer extends Thread implements Ibuyer, IUseBasket  {





    public Buyer(Integer number) {
        this.setName("Buyer №" + number);

    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
       // putGoodsToBasket();
        goOut();



    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");



    }

    @Override
    public void takeBasket() {
        System.out.println(this + " take basket");

    }

    @Override
    public void putGoodsToBasket() {
        Map<String,Double> goods = Good.getGoods();
        int putInBasket = Helper.getRandom(1,4);
        Object [] keys= goods.keySet().toArray();
        for (int i = 0; i < putInBasket; i++) {
            int randomGood = Helper.getRandom(0, keys.length - 1);
            String key =(String) keys[randomGood];
            Double value =goods.get(key);
            System.out.println(this+ " put " + key + " to basket, cost " +value);
        }

    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout =  Helper.getRandom(500,2000);
        putGoodsToBasket();
        Helper.timeout(timeout);

        System.out.println(this + " finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " out to Market");
    }

    @Override
    public String toString() {
        return getName();
    }


}
