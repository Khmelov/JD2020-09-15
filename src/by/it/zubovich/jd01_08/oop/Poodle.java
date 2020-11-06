package by.it.zubovich.jd01_08.oop;

public class Poodle extends Dog{
    public Poodle() {
        super();
    }

    //поля конструкторы методы
    boolean checkLife(){
        System.out.println("Iam alive! ");
        return true;
    }

    @Override
    public void doBark(int barkCount) { //переопределенный метод
        //super.doBark(barkCount);
        System.out.println("Poodle bark " + barkCount);
    }
    private int am;
    public Poodle(int gav, int am){
        super(gav);
        for (; am > 0; am--) {
            System.out.print("am-am "); // покушать
        }
        System.out.println();
        this.am = am;
    }
}
