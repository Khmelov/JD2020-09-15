package by.it.hutnik.jd02_03;

public class Cassir implements Runnable {
    private String name;

    @Override
    public String toString() {
        return name;
    }

    Cassir(int number) {
        this.name = "\tКасса №_" + number + ":";// табуляция Кассир №_
    }

    @Override
    public void run() {
        System.out.printf("%s открыта\n", this);
        while (!Supervisor.completed()){
            Buyer buyer = QueueBuyers.extract();
            if(buyer != null){
                System.out.println(this + " начало обслуживания " + buyer);
                int vremya = Helper.getRandom(200, 5000);
                Helper.vremyaStop(vremya);
                System.out.println(this + " завершено обслуживание " + buyer);
                synchronized (buyer){
                    buyer.notify();
                    System.out.flush();
                }
            }
            else {
                Helper.vremyaStop(1);
            }
        }
        System.out.printf("%s закрыта\n", this);
    }
}
