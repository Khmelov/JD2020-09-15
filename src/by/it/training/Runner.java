package by.it.training;

public class Runner {
    public static void main(String[] args) {
        int number=0;
        for (int i = 0; i < 20; i++) {
            Car car = new Car(number++);
            car.start();
        }
        Helper.timeOut(5000);
        int thCount=Thread.activeCount();
        while (Thread.activeCount() > thCount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Car.count);
    }
}
