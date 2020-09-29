package by.it.dobrodey.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number1 and number2");
        int i1 = sc.nextInt();
        int i2 = sc.nextInt();
        int sum = i1 + i2;

        // Десятиный формат числа
        System.out.println("DEC:".toUpperCase() + i1 + "+" + i2 + "=" + sum);
        // Бинарный формат числа
        String i1_2 = Integer.toBinaryString(i1);
        String i2_2 = Integer.toBinaryString(i2);
        String sum_2 = Integer.toBinaryString(sum);
        System.out.println("BIN:" + i1_2 + "+" + i2_2 + "=" + sum_2);

        // Шеснадцатиричная форма
        String i1_16 = Integer.toHexString(i1);
        String i2_16 = Integer.toHexString(i2);
        String sum_16 = Integer.toHexString(sum);
        System.out.println("HEX:" + i1_16 + "+" + i2_16 + "=" + sum_16);

        /* Восьмиричная форма */
        String i1_8 = Integer.toOctalString(i1);
        String i2_8 = Integer.toOctalString(i2);
        String sum_8 = Integer.toOctalString(sum);
        System.out.println("OCT:"+ i1_8 + "+" + i2_8 + "=" + sum_8);


    }


}