package by.it.dobrodey.jd02_01;


import java.util.*;

public class Basket extends Thread implements IUseBasket {

    Basket(String number) {
        this.setName(number);
    }


    @Override
    public void takeBasket() {
        System.out.println(this + "          " + "take basket");
    }

    @Override
    public void putGoodsToBasket() throws InterruptedException {
        HashMap<String, Double> goodsBuyer = new HashMap<>();
        int numberOfGoods = Helper.getRandom(1, 4);
        Map<String, Double> goods = Choose.getMap();
        Object[] setKey = goods.keySet().toArray();
        int koef = 2;
        for (int i = 0; i < numberOfGoods; i++) {
            int randomGoods = Helper.getRandom(goods.keySet().size() - 1);
            String key = (String) setKey[randomGoods];
            Double value = goods.get(key);
            System.out.println(this + "                                put goods to basket "
                    + key
                    + " cost "
                    + value);

            if (goodsBuyer.containsKey(key)) {
                double newvalue = value * koef++;
                goodsBuyer.put(key, newvalue);
            } else goodsBuyer.put(key, value);
            Helper.timeout(Helper.getRandom(500, 2000));
        }

        //printer on consol all goods
        String basket = goodsBuyer.toString().replace("{", "").
                replace("}", "").replace("=", " cost ");
        System.out.println(this + "                                   ALL goods to basket " + basket);
        Choose.goodsBuyerMap.put(this, goodsBuyer);
    }

    @Override
    public String toString() {
        return getName();
    }
}