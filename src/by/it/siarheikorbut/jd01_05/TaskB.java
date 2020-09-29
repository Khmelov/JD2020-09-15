package by.it.siarheikorbut.jd01_05;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1KNBofHHOxyARzccIFNqRvxU8ks8NY0n4/view?usp=sharing">Задание JD01_05 ( B )</a>
 */

public class TaskB {
    public static void main(String[] args) {
        stet1();
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
}