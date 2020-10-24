package by.it.moiseyenko.jd02_01;

class Buyer  extends Thread implements IBuyer,IUseBasket {
    Buyer(int number){this.setName("Buyer №"+number);}

    @Override
    public void run(){
        Supervisor.buyersInMarket++;
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goOut();
        Supervisor.buyersInMarket--;
    }

    @Override
    public void enterToMarket(){
        System.out.println(this + " enter to Market");
    }

    @Override
    public void takeBasket(){
        System.out.println(this + " take basket()");
    }

    @Override
    public void chooseGoods(){
        System.out.println(this + " started to chose goods");
        int timeout = by.it.moiseyenko.jd02_01.Helper.getRandom(500,2000);
        Helper.timeout(timeout);
        System.out.println(this + " finished to choose goods");
    }
    @Override
    public void putGoodsToBasket() {
        System.out.println(this + " put goods to basket");
    }
    @Override
    public void goOut(){
        System.out.println(this + " leaved Market");
    }

    @Override
    public String toString() {
        return getName();
    }



}




