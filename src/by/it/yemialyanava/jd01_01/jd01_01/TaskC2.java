package by.it.yemialyanava.jd01_01.jd01_01;

import java.util.Scanner;

class TaskC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int x = sc.nextInt();
        System.out.println("Введите число");
        int y = sc.nextInt();
        int sum = x + y;
        System.out.println("DEC:" + x + "+" + y + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(x) + "+" + Integer.toBinaryString(y) + "=" + Integer.toBinaryString(sum));
        System.out.println("HEX:" + Integer.toHexString(x) + "+" + Integer.toHexString(y) + "=" + Integer.toHexString(sum));
        System.out.println("OCT:" + Integer.toOctalString(x) + "+" + Integer.toOctalString(y) + "=" + Integer.toOctalString(sum));

    }
}