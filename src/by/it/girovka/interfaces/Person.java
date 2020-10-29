package by.it.girovka.interfaces;

public class Person implements Info {
    public String name;

    public Person(String name){
        this.name = name;
    }


    public void sayHello(){
        System.out.println("Hello");
    }


    @Override
    public void showInfo() {
        System.out.println("id is "+this.name);
    }
}
