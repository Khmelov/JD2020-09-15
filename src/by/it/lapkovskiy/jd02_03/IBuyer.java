package by.it.lapkovskiy.jd02_03;

interface IBuyer {

    void enterToMarket() throws InterruptedException;

    void chooseGoods();

    void goOut();

    void goToQueue() throws InterruptedException;
}
