package by.it.kolesnikov.jd01_01;

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
    public static void main(String[] args) {   //объявление функции, начало кода
        Scanner sc = new Scanner(System.in);    //класс для считывания значения с клавиатуры
        int i = sc.nextInt();                   //переменная которая вводится с клавиатуры
        int j = sc.nextInt();                   //переменная которая вводится с клавиатуры
        int c=i+j;
        System.out.print("DEC:");
        System.out.print(i + "+" + j+"=");
        System.out.println(c);
        System.out.print("BIN:");
        System.out.print( Integer.toBinaryString(i)+ "+" + Integer.toBinaryString(j)+"=");
        System.out.println( Integer.toBinaryString(c));
        System.out.print("HEX:");
        System.out.print( Integer.toHexString(i)+ "+" + Integer.toHexString(j)+"=");
        System.out.println( Integer.toHexString(c));
        System.out.print("OCT:");
        System.out.print( Integer.toOctalString(i)+ "+" + Integer.toOctalString(j)+"=");
        System.out.println( Integer.toOctalString(c));


    }

}
