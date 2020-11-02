package by.it.hutnik.jd01;

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

//for (int i = 0; i < 16; i++) {
//final String bin = String
//.format("%4s", Integer.toBinaryString(i))
//.replace(' ', '0');
//System.out.printf("DEC:%1$03d OCT:%1$03o HEX:%1$03x BIN:%2$2s %n", i, bin);
//}

public class TaskC2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        String binA = String.format("%4s", Integer.toBinaryString(a)).replace(' ','0');
        String binB = String.format("%4s", Integer.toBinaryString(b)).replace(' ','0');
        String binSum = String.format("%4s", Integer.toBinaryString(sum)).replace(' ','0');

        System.out.printf("DEC:%1$d+%2$d=%3$d%n",a, b, sum);
        System.out.printf("BIN:%1$s+%2$s=%3$s%n",binA, binB, binSum);
        System.out.printf("HEX:%1$x+%2$x=%3$x%n",a, b, sum);
        System.out.printf("OCT:%1$o+%2$o=%3$o%n",a, b, sum);
    }
}

