package by.it.zubovich.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Poodle();
        Poodle dog3 = new Poodle();
        Dog dog4 = new Dog(9); // обращение к конструктору Dog
        Dog dog5 = new Poodle(5,3); // обращение к конструктору Poodle
        dog5.doBark(10);
        // Poodle dog00 = new Dog(); //ошибка компиляции
        Poodle dog6 = new Poodle();
        dog6.checkLife();
        dog1.doBark(5); //метод класса Dog
        dog2.doBark(2); //полиморфный метод класса Poodle
        if (dog3.checkLife()){ //неполиморфный метод
            dog3.doBark(4); //полиморфный метод
            //dog2.checkLife(); // ошибка компиляции - неполиморфный метод
        }
        ((Poodle) dog2).checkLife(); //ok
        //((Poodle) dog1).checkLife(); //ошибка времени выполнения
    }
}
