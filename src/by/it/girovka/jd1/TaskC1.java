package by.it.girovka.jd1;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60


 */
import java.util.Scanner;


class TaskC1 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: i = ");
        int i = sc.nextInt();
        System.out.println("Введите число: j = ");
        int j = sc.nextInt();
        int Sum = i + j;
        System.out.println("Sum = "+ Sum );

    }





}
