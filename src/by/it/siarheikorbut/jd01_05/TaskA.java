package by.it.siarheikorbut.jd01_05;

import static java.lang.Math.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1KNBofHHOxyARzccIFNqRvxU8ks8NY0n4/view?usp=sharing">Задание JD01_05 ( A )</a>
 */
public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    //Запись арифметического выражения.
    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double part1 = cos(pow(x * x + PI / 6, 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        System.out.printf("For x=%f and a=%f z=%f\n", x, a, z);
    }

    //Вычисление функции.
    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double result = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y = " + result);
    }

    //Табулирование функции.
    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При a=%6.2f f=%g\n", a, f);
        }

    }
}