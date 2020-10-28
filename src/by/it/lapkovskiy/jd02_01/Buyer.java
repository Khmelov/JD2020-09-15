package by.it.lapkovskiy.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    Buyer(int number,boolean pensioneer) {
        this.setName("Buyer №" + number);
        this.pensioneer = pensioneer;
    }

    HashMap<String, Integer> basket;
    boolean pensioneer;
    @Override
    public void run() {
        Supervisor.upBuyers();
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        long timeMillis= System.currentTimeMillis();
        System.out.println(this + " started to choose goods");
        int times = Helper.getRandom(1, 4);
        for (int i = 0; i < times; i++) {
            int timeout;
            if(pensioneer) {
                timeout = Helper.getRandom(750, 3000);}
            else{ timeout = Helper.getRandom(500, 2000);}
            Helper.timeout(timeout);
            putGoodsToBasket();
        }
        System.out.println(this + " finished to choose goods->"+(System.currentTimeMillis()-timeMillis));
    }

    @Override
    public void goOut() {
        synchronized(System.out){
        System.out.println(this+" buyed");
        for (Map.Entry<String,Integer> good:basket.entrySet()) {
            System.out.println("  "+good);
        }
        System.out.println(this + " go out Market");
        Supervisor.downBuyers();
        }
    }

    @Override
    public String toString() {
        if(pensioneer) return "Pensioner "+getName();
        return getName();
    }

    @Override
    public void takeBasket() {
        System.out.println(this+" take basket");
        basket = new HashMap<>();
    }

    @Override
    public void putGoodsToBasket() {
        Goods.getGood(basket,this.getName());
    }
}
