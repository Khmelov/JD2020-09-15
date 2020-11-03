package by.it.hutnik.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Покупатель №_" + number);
    }
    @Override
    public void run() {
//      Supervisor.BUYERS_IN_SHOP++; //добавился покупатель
        enterToMarket(); //вошел в магазин (мгновенно)
        takeBasket(); //взял корзину
        chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        putGoodsToBasket(); //положил выбранный товар в корзину
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
    public void goOut() {
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
        Map<String, String> vybor = new HashMap<>();
        vybor.put("МОЛОКО", "= 98 коп.");
        vybor.put("ХЛЕБ", "= 1 руб. 26 коп.");
        vybor.put("СЫР", "= 3 руб. 74 коп.");
        vybor.put("ТВОРОГ", "= 2 руб. 12 коп.");
        for(Map.Entry<String, String> entry: vybor.entrySet()){
            if(count == tovary)
                break;
                System.out.println(this + " положил " + "в корзину " + entry.getKey() + " " + entry.getValue());
                count++;
        }
        System.out.printf("%s закончил выбирать товар.\n", this);
        Helper.vremyaStop(Helper.getRandom(500, 2000));
    }
}