package by.it.fedorinhyk.jd02_01;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Buyer extends Thread implements IBuyer,IUseBasket {
    Buyer (int number){
        this.setName("Покупатель №"+ number);
    }

    @Override
    public void run() {
        Supervisor.buyerInMarket++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
        Supervisor.buyerInMarket--;
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать товар");
        int timeout=Helper.getRandom(500,2000);
        Helper.timeout(timeout);
        putGoodsToBasket();
        System.out.println(this+" закончил выбирать товар");

    }

    @Override
    public void goOut() {
        System.out.println(this+" вышел из магазина");
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Set<Map.Entry<String, Double>> GoodsSet = Goods.getMap().entrySet();
        HashMap <String,Double> goodsBuyer = new HashMap<>();
        int goods = Helper.getRandom(1,4);
        Iterator<Map.Entry<String, Double>> iterator = GoodsSet.iterator();
        for (int i = 0; i < goods; i++) {
            Map.Entry<String, Double> entrygoods = iterator.next();
            goodsBuyer.put(entrygoods.getKey(),entrygoods.getValue());
            System.out.println(this+" положил в корзину товар:"+"'"+entrygoods.getKey()+"'"+"по цене:"+entrygoods.getValue());
            int timeout=Helper.getRandom(500,2000);
            Helper.timeout(timeout);
        }
    }
    @Override
    public String toString() {
        return getName();
    }

}