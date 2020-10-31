package by.it.girovka.Kurs;

import by.it._examples_.jd01_08._03_SupAndThis.SuperAndThis;

public class lesson20 {
    public static void main(String[] args) {
        Human1 h1 = new Human1("Bob", 29);
        Human1 h2 = new Human1("Bob", 22);
        Human1.description = "Nice";
       h1.getAllField();
       h2.getAllField();
       Human1.description = "bad";
       h1.getAllField();
       h2.getAllField();



    }
}
class Human1 {

    private String name;
    private int age;
    public static String description;
    public Human1(String name,int age){
        this.name = name;
        this.age=age;
    }

    public void setName(String name){ this.name = name;}
    public void setAge(int age) { this.age = age;}
   public void getAllField(){
       System.out.println(name+","+age+""+description);
    }
    public  void printAllFields(){
        System.out.println(name);
    }

}
