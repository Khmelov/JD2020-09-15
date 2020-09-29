package by.it.dobrodey.jd01_01;

import java.awt.*;
import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/


class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number1 and number2");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int sum = i1 + i2;
        System.out.println("Sum = " + sum);
    }
}
