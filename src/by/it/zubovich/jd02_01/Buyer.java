package by.it.zubovich.jd02_01;

/*Напишите программу, моделирующую поток покупателей Buyer в магазине.
        
        Каждую секунду в магазин приходят от 0 до 2 новых покупателей в течение двух минут.
        
        Каждый покупатель реализует интерфейс IBuyer
        •
public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goOut(); //отправился на выход(мгновенно)
}*/
class Buyer  extends Thread implements IBuyer,IUseBasket {
    Buyer(int number){
        this.setName("Buyer № " + number + ":");
    }

    @Override
    public void run(){
        Manager.buyersInMarket++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Manager.buyersInMarket--;
    }
    @Override
    public void enterToMarket(){
        System.out.println(this + " enter to Shop");
    }
    @Override
    public void takeBasket(){
        System.out.println(this + " take basket");
    }

    @Override
    public void chooseGoods(){
        System.out.println(this + " started to choose goods");
        int timeout = Helper.getRandom(500,2000);
        Helper.sleep(timeout);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " finished to choose goods");
    }
    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put goods to basket");
    }
    @Override
    public void goOut(){
        System.out.println(this + " left Shop");
    }

    @Override
    public String toString() {
        return getName();
    }
}




