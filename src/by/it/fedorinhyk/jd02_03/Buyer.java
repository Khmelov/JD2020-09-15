package by.it.fedorinhyk.jd02_03;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean waiting;
    private static Semaphore semaphore=new Semaphore(20);

    Buyer (int number){
        this.setName("Покупатель №"+ number);
        Supervisor.addBuyer();
        waiting=false;
    }

    public void setWaiting(boolean waiting){
        this.waiting=waiting;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            enterToMarket();
            takeBasket();
            chooseGoods();
            goToQueue();
            goOut();
            Supervisor.leaveBuyers();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" в магазин");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" начал выбирать товар");
        int timeout= Helper.getRandom(500,2000);
        Helper.timeout(timeout);
        System.out.println(this+" закончил выбирать товар");

    }

    @Override
    public void goToQueue() {
        System.out.println(this+" идет к кассе");
        putGoodsToBasket();
        synchronized (this){
            waiting=true;
            QueueBuyers.add(this);
            while (waiting)
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
        System.out.println(this+" ушел с кассы");

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
        double sum=0;
        Set<Map.Entry<String, Double>> GoodsSet = Goods.getMap().entrySet();
        HashMap <String,Double> goodsBuyer = new HashMap<>();
        int goods = Helper.getRandom(1,4);
        Iterator<Map.Entry<String, Double>> iterator = GoodsSet.iterator();
        for (int i = 0; i < goods; i++) {
            Map.Entry<String, Double> entrygoods = iterator.next();
            goodsBuyer.put(entrygoods.getKey(),entrygoods.getValue());
            System.out.println(this+" выложил на кассу товар:"+"'"+
                    entrygoods.getKey()+"'"+"по цене:"+entrygoods.getValue());
            int timeout= Helper.getRandom(500,2000);
            Helper.timeout(timeout);
            sum+=entrygoods.getValue();
        }
        System.out.println(this+" ОБЩАЯ СУММА ЧЕКА:"+sum);
    }
    @Override
    public String toString() {
        return getName();
    }

}