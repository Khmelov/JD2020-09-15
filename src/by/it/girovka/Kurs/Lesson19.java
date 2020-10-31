package by.it.girovka.Kurs;

public class Lesson19 {
    public static void main(String[] args) {

        Human human1 = new Human();
        human1.setAge(18);
        human1.setName("Вова ");
        human1.getNfo();
    }
}
class Human {
    String name;
    int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return name;
    }
    private int getAge(){
        return  age;
    }
    public void getNfo(){
        System.out.println(name+""+age);
    }
}