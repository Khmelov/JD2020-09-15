package by.it.fedorinhyk.jd01_01;

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
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c =a+b;
        System.out.println("DEC:"+a+"+"+b+"="+c);

        String convertbin = Integer.toBinaryString(c);
        String convert1 = Integer.toBinaryString(a);
        String convert2 = Integer.toBinaryString(b);
        System.out.println("BIN:"+convert1+"+"+convert2+"="+convertbin);

        String converthex = Integer.toHexString(c);
        String converthex1 = Integer.toHexString(a);
        String converthex2 = Integer.toHexString(b);
        System.out.println("HEX:"+converthex1+"+"+converthex2+"="+converthex);

        String convertoct = Integer.toOctalString(c);
        String convertoct1 = Integer.toOctalString(a);
        String convertoct2 = Integer.toOctalString(b);
        System.out.println("OCT:"+convertoct1+"+"+convertoct2+"="+convertoct);

    }
}
