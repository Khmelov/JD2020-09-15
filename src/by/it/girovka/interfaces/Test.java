package by.it.girovka.interfaces;

public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Animal(1);
        Person person1 = new Person("Bob");
        outInfo(animal1);
        outInfo(person1);
    }
    public static void outInfo(Info info){
        info.showInfo();
    }
}
