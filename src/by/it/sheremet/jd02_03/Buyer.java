package by.it.sheremet.jd02_03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements Ibuyer, IUseBasket {
    private static Semaphore semaphore = new Semaphore(20, true);

    private boolean waiting;
    private Map<String,Double> basketGoods = null;

    public Buyer(Integer number) {
        this.setName("Buyer №" + number);
        Supervisor.addBuyer();
        waiting = false;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }
    public Map<String,Double> getBasketGoods(){
        return basketGoods;
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            semaphore.acquire();
            //System.out.println(this + " ======start to semaphore======");
            takeBasket();
            chooseGoods();
           // System.out.println(this+ " +++++++++++finish to semaphore++++++++++++");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
        goToQueue();
       // putGoodsToBasket();
        goOut();
        Supervisor.leaveBuyer();



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
        basketGoods = new HashMap<>();
        Map<String,Double> goods = Good.getGoods();
        int putInBasket = Helper.getRandom(1,4);
        Object [] keys = goods.keySet().toArray();

        for (int i = 0; i < putInBasket; i++) {
            int randomGood = Helper.getRandom(0, keys.length - 1);
            String key =(String) keys[randomGood];
            Double value =goods.get(key);
            basketGoods.put(key, goods.get(key));
            System.out.println(this+" put "+key+" to basket, cost "+value);

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
    public void goToQueue() {
        System.out.println(this+ " go to queue ");
        synchronized (this){
            waiting = true;
            QueueBuyers.add(this);
                while (waiting)
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
        }
        System.out.println(this+ " leave to queue");

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
