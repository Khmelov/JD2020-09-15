package by.it.khmel.jd01_01;

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

import java.util.Scanner;
class TaskC2 {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner sc=new Scanner (System.in);
        int a =sc.nextInt();
        System.out.println("Enter number ");
        int b=sc.nextInt();
        int Sum=a+b;
        System.out.println("DEC:"+a+"+"+b+"="+(a+b));
        String converta2= Integer.toBinaryString(a);
        String convertb2= Integer.toBinaryString(b);
        System.out.println("BIN:"+converta2+"+"+convertb2+"="+(Integer.toBinaryString(Sum)));
        String converta16= Integer.toHexString(a);
        String convertb16= Integer.toHexString(b);
        System.out.println("HEX:"+converta16+"+"+convertb16+"="+(Integer.toHexString(Sum)));
        String converta8= Integer.toOctalString(a);
        String convertb8= Integer.toOctalString(b);
        System.out.println("OCT:"+converta8+"+"+convertb8+"="+(Integer.toOctalString(Sum)));




    }


}
