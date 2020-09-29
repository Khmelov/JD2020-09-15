package by.it.fedorinhyk.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }


    private static void step4() {
        int x = 1;
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = (pow(7, a) - Math.cos(1)) + (pow(7, a) - Math.cos(2)) + (pow(7, a) - Math.cos(3)) +
                    (pow(7, a) - Math.cos(4)) + (pow(7, a) - Math.cos(5)) + (pow(7, a) - Math.cos(6));
            System.out.printf("При a=%3.2f Сумма y = %g\n", a, y);

        }

    }


    private static void step5() {
        double b;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 <= -1 && x / 2 > -2) {
                b = sin(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a = %g\n", x / 2, a);
            }
             else if (-1 < x / 2 && x / 2 < 0.2) {
                b = cos(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a = %g\n", x / 2, a);
            }
            else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a = %g\n", x / 2, a);
            }
            else {
                System.out.printf("При x/2=%3.2f вычисления не определены\n", x / 2);
            }

        }

    }

}