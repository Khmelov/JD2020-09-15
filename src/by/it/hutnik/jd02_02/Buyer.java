package by.it.hutnik.jd02_02;


class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        this.setName("Buyer №" + number);
    }

    @Override
    public void run() {
        Supervisor.buyersInMarket++;
        enterToMarket();
        chooseGoods();
        goOut();
        Supervisor.buyersInMarket--;

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " started to choose goods");
        int timeout = Helper.getRandom(500, 2000);
        Helper.timeout(timeout);
        System.out.println(this + " finished to choose goods");
    }


    @Override
    public void goOut() {
        System.out.println(this + " enter to Market");
    }

    @Override
    public String toString() {
        return getName();
    }
}