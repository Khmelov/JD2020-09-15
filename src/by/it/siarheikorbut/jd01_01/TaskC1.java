package by.it.siarheikorbut.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/18ZAKGDaiKvwF1U0V06VUm6cKMQASZCRc/view?usp=sharing">Задание JD01_01</a>
 */

class TaskC1 {
    public static void main(String[] args) throws IOException {

        //Ввод двух числ с клавиатуры и вывод их на экран.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        int sum = a + b;

        System.out.println("Sum" + " = " + sum);
    }
}