package by.it.girovka.Kurs;

public class ClassesAndObjects {
    public static void main(String[] args) {
        Person x1 = new Person();
    x1.setName("Misha");
    x1.age = 22;
    x1.speak();
    String s1 = "woa";
        System.out.println();
    Person x2 = new Person();
    x2.setName(s1);
    x2.age = 18;
    x2.speak();
    x1.sayHello();
    int years = x1.qwert();
        System.out.println(years);


    }
}

class Person{
    String name;
    int age;


    void setName(String username){
        name = username;




    }

    int qwert(){
        int years = 65-age;
        return years;

    }

    void speak(){
        for(int i = 0; i<3; i++)
        System.out.println("Меня зовут "+name+","+"мне "+age);
    }
    void sayHello(){
        System.out.println("Привет");

    }
}