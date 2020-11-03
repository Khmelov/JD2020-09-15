package by.it.hutnik.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean waitState = false;

    public void setWaitState(boolean waitState){
        this.waitState = waitState;
    }

    public Buyer(int number) {

        super("Покупатель №_" + number);
        Supervisor.addBuyer();

    }
    @Override
    public void run() {
//        Supervisor.BUYERS_IN_SHOP++; //добавился покупатель
        enterToMarket(); //вошел в магазин (мгновенно)
        takeBasket(); //взял корзину
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        putGoodsToBasket(); //положил выбранный товар в корзину
        goToQueue(); // стал в очередь
        goOut(); //отправился на выход(мгновенно)
        Supervisor.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {

        System.out.printf("%s вошёл в магазин. \n", this);
    }

    @Override
    public void chooseGoods() {

        System.out.printf("%s начал выбирать товар.\n", this);
        int vremya = Helper.getRandom(500, 2000);
        Thread.yield();
        Helper.vremyaStop(vremya);
        }

    @Override
    public void goToQueue() {
        synchronized (this){
            QueueBuyers.add(this);
            waitState = true;
            while (waitState)
            try{
                System.out.println(this + " стал в очередь");
                this.wait();
                System.out.println(this + " вышел из очереди");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void goOut() {
        Supervisor.ofBuyer();
        System.out.printf("%s вышел из магазина.\n", this);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s взял корзину.\n", this);
    }

    @Override
    public void putGoodsToBasket() {
        int tovary = Helper.getRandom(1, 4);
        int count = 0;
        Map<String, Double> vybor = new HashMap<>();
        vybor.put("МОЛОКО", 0.98);
        vybor.put("ХЛЕБ", 1.26);
        vybor.put("СЫР", 3.74);
        vybor.put("ТВОРОГ", 2.12);
        for(Map.Entry<String, Double> entry: vybor.entrySet()){
            if(count == tovary)
                break;
            System.out.println(this + " положил " + "в корзину " + entry.getKey() + " " + entry.getValue() + " руб.");
            count++;
        }
        System.out.printf("%s закончил выбирать товар.\n", this);
        Helper.vremyaStop(Helper.getRandom(500, 2000));
    }
}