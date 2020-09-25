package by.it.khmel.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        step2();
    }


    private static void step1() {
        double y = 0;
        double a = 0;
        for (a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("при a= %4.1f  y=%6f", a, y);
        }
    }

    private static void step2() {
        double x=-6;
        double b, a;

        while (x>=-6 &&x <2) {

            if ((x / 2) > -2 && (x / 2) <= -1) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("при x/2= %5.2f a = %f", (x / 2), a);
            }
            if ((x / 2) > -1 && (x / 2) < 0.2) {
                b = cos(x * x);
                a = log10(abs(b + 2.74));
                System.out.printf("при x/2= %5.2f a = %f", (x / 2), a);

            }
            if ((x / 2) == 0.2) {
                b = 1 / tan(x * x);

                a = log10(abs(b + 2.74));
                System.out.printf("при x/2= %5.2f a = %f", (x / 2), a);

            }
                x = x + 0.5;
        }
    }
}



