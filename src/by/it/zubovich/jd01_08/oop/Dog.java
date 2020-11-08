package by.it.zubovich.jd01_08.oop;

public class Dog {
    private int gavCount;

    public Dog() {

    }

    void doBark (int barkCount){
        //реализация
        for (; barkCount > 0; barkCount--) {
            System.out.print("bark "); // подать голос
        }
        System.out.println();
    }
    public Dog (int gavCount){
        //реализация
        this.gavCount = gavCount;
        for (; gavCount > 0; gavCount--) {
            System.out.print("gav "); // подать голос
        }
        System.out.println();
    }
}
