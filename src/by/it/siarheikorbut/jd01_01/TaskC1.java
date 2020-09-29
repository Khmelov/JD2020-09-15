package by.it.siarheikorbut.jd01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

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
