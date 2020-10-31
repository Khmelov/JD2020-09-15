package by.it.girovka.interfaces;

public class Animal implements Info {
    public int id;

    public Animal(int id){
        this.id = id;
    }

    public void sleep(){
        System.out.println("i am sleeping");
    }

    public void showInfo() {
        System.out.println("id is "+this.id);

    }
}
