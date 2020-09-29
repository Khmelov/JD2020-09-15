package by.it.frolova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double sum = 0;
            for (int i = 1; i < 7; i++) {
                sum += pow(7, round(a)) - cos(i);
            }
            System.out.println("При а=" + a + " Сумма y = " + sum);

        }
    }

    private static void step2() {
        double b;
        double a;

        for (double x = -5.5; x < 2; x += 0.5) {
            if (((x / 2) > -2) && ((x / 2) <= -1)) {
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, a);
            } else if (((x / 2) > -1) && ((x / 2) < 0.2)) {
                b = cos(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, a);
            } else if ((x / 2) == 0.2) {
                b = 1/tan(pow(x,2));
                a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%.2f a = %e\n", x/2, a);
            } else {
                System.out.println("При x/2=" + x / 2 + " вычисления не определены");
            }
        }

    }

}
