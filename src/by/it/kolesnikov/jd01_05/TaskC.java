package by.it.kolesnikov.jd01_05;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        for (double x=5.33; x<=9; x=x+Math.random()/(x-3)){
           double z =pow((pow(x,2)+4.5), 1/3.0);
        System.out.println("При x="+x+" z="+z);
        }
    }
}
