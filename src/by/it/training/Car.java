package by.it.training;

public class Car extends Thread implements CarParking{

static Integer count=0;

    public Car(int name){
        this.setName("Машина №"+name);
    }

    @Override
    public void run(){
        count++;
        comeToParkling();
        stayAtParkling();
        comeOutOfParkling();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void comeToParkling() {
        System.out.println(this+" приехала на парковку");
    }

    @Override
    public void stayAtParkling() {
        System.out.println(this+" запарковалась");
        Helper.timeOut(Helper.getRandom(1000, 4000));
    }

    @Override
    public void comeOutOfParkling() {
        System.out.println(this+" выехала из парковки");
    }
}
