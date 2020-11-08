package by.it.siarheikorbut.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/18ZAKGDaiKvwF1U0V06VUm6cKMQASZCRc/view?usp=sharing">Задание JD01_01</a>
 */

class TaskC2 {
    public static void main(String[] args) throws IOException {

        //Ввод с клавиатуры двух чисел и вывод их суммы на экран в различных системах счисления.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        int sum = a + b;

        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(a) + "+" + Integer.toBinaryString(b) + "=" + Integer.toBinaryString(sum));
        System.out.println("HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) + "=" + Integer.toHexString(sum));
        System.out.println("OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) + "=" + Integer.toOctalString(sum));
    }
}