package by.it.fedorinhyk.jd02_03;

import java.util.Objects;

public class Cashier implements Runnable {

    private String name;

    public Cashier (int number){
        this.name="\tКасса №"+number+":";
    }

    @Override
    public void run() {
        System.out.printf("%s открыта\n", this);

        while (!Supervisor.MarketIsClosed()){
            Buyer buyer= QueueBuyers.extract();
            if (Objects.nonNull(buyer)){
                System.out.printf("%s начало обслуживания %s\n",this,buyer);
                int time= Helper.getRandom(2000,5000);
                Helper.timeout(time);
                System.out.printf("%s конец обслуживания %s\n",this,buyer);
                synchronized (buyer){
                    buyer.setWaiting(false);
                    buyer.notify();
                }
            }
            else {
                Thread.yield();
            }
        }
        System.out.printf("%s закрыто\n",this);
    }

    @Override
    public String toString() {
        return name;
    }
}
