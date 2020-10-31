package by.it.hutnik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {

        super("Покупатель №" + number);
    }

    @Override
    public void run() {
        enterToMarket(); //вошел в магазин (мгновенно)
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        goOut(); //отправился на выход(мгновенно)
        takeBasket(); //взял корзину
        putGoodsToBasket(); //положил выбранный товар в корзину
        Supervisor.BUYERS_IN_SHOP--;
    }

    @Override
    public void enterToMarket() {

        System.out.printf("%s вошёл в магазин", this);
    }

    @Override
    public void chooseGoods() {
        System.out.printf("%s начал выбирать товар\n", this);
        int srok = Helper.getRandom(500, 2000);
        Thread.yield();
        Helper.mySleep(srok);
        System.out.printf("%s закончил выбирать товар\n", this);
    }

    @Override
    public void goOut() {
        System.out.printf("%s вышел из магазина\n", this);

    }

    @Override
    public String toString() {

        return this.getName();
    }

    @Override
    public void takeBasket() {
        System.out.printf("%s взял корзину\n", this);
    }

    @Override
    public void putGoodsToBasket() {
        int tovary = Helper.getRandom(0, 4);
        int count = 0;
        Map<String, Integer> perechen = new HashMap<>();
        perechen.put("хлеб", 3);
        perechen.put("молоко", 2);
        perechen.put("сыр", 7);
        perechen.put("творог", 5);
        for(Map.Entry<String, Integer>entry: perechen.entrySet()){
            if(count == tovary)
                break;
            System.out.printf("%s положил в корзину\n", this, entry.getKey());
            count++;
        }
        Helper.mySleep(Helper.getRandom(500, 2000));
    }


}