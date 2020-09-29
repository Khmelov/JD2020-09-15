package by.it.yemialyanava.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double sum = 0;
        for (double a = 0; a <= 2 ; a = a + 0.2){
            for (int x = 1; x <=6; x = x + 1)  {
                sum = sum + (pow(7,a)-cos(x));
            }
            System.out.printf("При a=%6.2f сумма=%g\n", a, sum);
        }
    }

    private static void step2() {
        double b =0;
        double a = 0;
        for (double x = -5.5; x < 2; x = x+0.5) {
            if ((x / 2) > -2 && (x / 2) <= -1){
                b = sin(pow(x, 2));
                System.out.println("При х/2 = " + x/2 + "а = " + a);
            }
            if (((x / 2) > -1) && ((x / 2) < 0.2)){
                b =cos(pow(x, 2));
                System.out.println("При х/2 = " + x/2 + "а = " + a);
            }
            if ((x / 2) == 0.2){
                b = 1.0/tan(pow(x,2));
                System.out.println("При х/2 = " + x/2 + "а = " + a);
            }
            if (b==0){
                System.out.println("При х/2 = " + x/2 + "вычисления не опрделены");
            } else {
                a = log10(abs(b + 2.74));
            }

        }

    }
}


