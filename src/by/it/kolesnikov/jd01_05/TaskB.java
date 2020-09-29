package by.it.kolesnikov.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    static void step1() {
        double y = 0.0;
        double a = 0.0;
        while (a <= 2) {
            for (int i = 1; i <= 6; i++) {
                y = y + (pow(7, a) - cos(i));
            }
            a = a + 0.2;
            System.out.println("При a=" + a + " y=" + y);
        }
    }
    static void step2() {
        double b = 0;
        double a=0;
        for (double x = -5.5; x <2; x = x + 0.5) {
            double k = x / 2;
            if (k > -2 && k <= -1) {
                b = sin(pow(x, 2));
                System.out.println("При x/2="+k+" "+"a="+a);
            } else if (k > -1 && k <= 0.2) {
                b = cos(pow(x, 2));
                System.out.println("При x/2="+k+" "+"a="+a);
            }
            else if(k==0.2){
                b=1/tan(pow(x,2));
                System.out.println("При x/2="+k+" "+"a="+a);
            }
            else {
                System.out.println("При x/2="+k+" Вычисления не определены");
            }
            a = log10(abs(b + 2.74));
        }
    }
}
