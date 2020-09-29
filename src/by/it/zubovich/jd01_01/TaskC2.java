package by.it.zubovich.jd01_01;

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
        Scanner scSum4 = new Scanner(System.in);
        System.out.println("Ввод:");
        int i = scSum4.nextInt();
        int j = scSum4.nextInt();
        int sum = i + j;
        System.out.println("DEC:" + i + "+" + j + "=" + sum);

        String conBini = Integer.toBinaryString(i);
        String conBinj = Integer.toBinaryString(j);
        String conBinSum = Integer.toBinaryString(sum);
        System.out.println("BIN:" + conBini + "+" + conBinj + "=" + conBinSum);

        String conHexi = Integer.toHexString(i);
        String conHexj = Integer.toHexString(j);
        String conHexSum = Integer.toHexString(sum);
        System.out.println("HEX:" + conHexi + "+" + conHexj + "=" + conHexSum);

        String conOcti = Integer.toOctalString(i);
        String conOctj = Integer.toOctalString(j);
        String conOctSum = Integer.toOctalString(sum);
        System.out.println("OCT:" + conOcti + "+" + conOctj + "=" + conOctSum);
    }


}
