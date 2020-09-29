package by.it.hutnik.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
     private static void step1() {
        double y=0;
        double res=0;
         for (double a = 0; a <=2; a=a+0.2) {
             for (int x = 1; x <=6 ; x++) {
                 y = (Math.pow(7, a)) - (Math.cos(x));
                 res = res + y;

             }
             System.out.printf("При а=%.2f Сумма y=%g%n", a, res);
             res=0;
         }
         System.out.println();
    }

    private static void step2() {
        double a = 0;
        double b = 0;
        for (double x = -5.5; x <=0.2; x=x+0.5) {
            if((x/2>-2) && (x/2)<=1) {
                b = sin(pow(x , 2));
                a = log10(abs(b+2.74));
                System.out.printf("При х/2=%.2f а=%f%n", x, a);
            }
            else {
                if ((x/2 <1) && ((x/2)<0.2)) {
                    b = cos(pow(x, 2));
                    a = log10(abs(b+2.74));
                    System.out.printf("При х/2=%.2f а=%f%n", x, a);
                }
                else if (x/2 == 0.2) {
                    b = 1/tan(pow(x, 2));
                    a = log10(abs(b+2.74));
                    System.out.printf("При х/2=%.2f а=%f%n", x, a);
                }
                else {
                    System.out.printf("При х/2=%.2f вычисления не определены!");
                }
            }
        }
    }
}