package by.it.siarheikorbut.jd01_05;

import static java.lang.Math.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1KNBofHHOxyARzccIFNqRvxU8ks8NY0n4/view?usp=sharing">Задание JD01_05 ( B )</a>
 */

public class TaskB {
    public static void main(String[] args) {
        stet1();
        step2();
    }

    private static void stet1() {

        //Вычисление суммы
        double y;
        double result = 0;
        for (double i = 0; i <= 2; i = i + 0.2) {
            for (int j = 1; j <= 6; j++) {
                y = (Math.pow(7, i)) - (Math.cos(j));
                result += y;
            }
            System.out.printf("При а = %.2f Сумма y = %g%n", i, result);
            result = 0;
        }
        System.out.println();
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if (x / 2 > -1 && x / 2 <= 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if (x / 2 == 0.2) {
                double b = cos(x * x);
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%f; a=%e\n", x / 2, a);
            }
            if ((x / 2 <= -2) || (x / 2 > 0.2)) {
                System.out.printf("При x/2=%f; вычисления не определены\n", x / 2);
            }
        }
    }
}