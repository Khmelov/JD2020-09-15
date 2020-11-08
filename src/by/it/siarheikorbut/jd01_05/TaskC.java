package by.it.siarheikorbut.jd01_05;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1KNBofHHOxyARzccIFNqRvxU8ks8NY0n4/view?usp=sharing">Задание JD01_05</a>
 */

public class TaskC {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        System.out.println("Введите размер массива:");
        Scanner scan = new Scanner(System.in);
        int lengthArray = scan.nextInt();
        if (lengthArray < 1) return;
        int[] a = new int[lengthArray];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (random() * 348 + 103);
            if (a[i] * 0.1 >= i) j++;
            if (a.length == 4) {
                if (i == 0) System.out.print("╔════════════╦════════════╦════════════╦════════════╗\n");
                System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
                if (i == a.length - 1) {
                    System.out.print("║\n");
                    System.out.print("╚════════════╩════════════╩════════════╩════════════╝\n");
                }
            }
            if (a.length == 3) {
                if (i == 0) System.out.print("╔════════════╦════════════╦════════════╗\n");
                System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
                if (i == a.length - 1) {
                    System.out.print("║\n");
                    System.out.print("╚════════════╩════════════╩════════════╝\n");
                }
            }
            if (a.length == 2) {
                if (i == 0) System.out.print("╔════════════╦════════════╗\n");
                System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
                if (i == a.length - 1) {
                    System.out.print("║\n");
                    System.out.print("╚════════════╩════════════╝\n");
                }
            }
            if (a.length == 1) {
                System.out.print("╔════════════╗\n");
                System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
                System.out.print("║\n");
                System.out.print("╚════════════╝\n");
            }
            if (a.length > 4) {
                if (i == 0) {
                    System.out.print("╔════════════╦════════════╦════════════╦════════════╦════════════╗\n");
                }
                if ((i + 1) % 5 == 0 && i + 1 < a.length) {
                    System.out.printf("║ A[ %-2d]=%d ║\n", i, a[i]);
                    if (i == a.length - 1) System.out.printf("║ A[ %-2d]=%d ║", i, a[i]);
                    if ((i + 1) % 5 == 0 && i < a.length - 1) {
                        System.out.print("╠════════════╬════════════╬════════════╬════════════╬════════════╣\n");
                    }
                    if ((i + 1) % 5 == 0 && i == a.length - 1) {
                        System.out.println();
                    }
                } else System.out.printf("║ A[ %-2d]=%d ", i, a[i]);
                if ((i == a.length - 1) && (a.length % 5 == 1)) {
                    System.out.print("║            ║            ║            ║            ║\n");
                }
                if ((i == a.length - 1) && (a.length % 5 == 2)) {
                    System.out.print("║            ║            ║            ║\n");
                }
                if ((i == a.length - 1) && (a.length % 5 == 3)) {
                    System.out.print("║            ║            ║\n");
                }
                if ((i == a.length - 1) && (a.length % 5 == 4)) {
                    System.out.print("║            ║\n");
                }
                if ((i == a.length - 1) && (a.length % 5 == 0)) {
                    System.out.print("║\n");
                }
                if (i == a.length - 1) {
                    System.out.print("╚════════════╩════════════╩════════════╩════════════╩════════════╝\n");
                }
            }
        }
        int[] b = new int[j];
        getArrayTwo(a, b);
        printArrayTwo(b);
    }

    private static void getArrayTwo(int[] a, int[] b) {
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] * 0.1 >= i) {
                b[j] = a[i];
                j++;
            }
        }
    }

    private static void printArrayTwo(int[] b) {
        if (b.length == 1) {
            System.out.print("╔════════════╗\n");
            System.out.printf("║ B[ %-2d]=%d ║\n", 0, b[0]);
            System.out.print("╚════════════╝\n");
        }
        if (b.length == 2) {
            System.out.print("╔════════════╦════════════╗\n");
            System.out.printf("║ B[ %-2d]=%d ║ B[ %-2d]=%d ║\n", 0, b[0], 1, b[1]);
            System.out.print("╚════════════╩════════════╝\n");
        }
        if ((b.length > 2) && (b.length % 2 == 0)) {
            int leg = b.length / 2;
            for (int i = 0; i < b.length / 2; i++) {
                if (i == 0) {
                    System.out.print("╔════════════╦════════════╗\n");
                }
                System.out.printf("║ B[ %-2d]=%d ║", i, b[i]);
                System.out.printf(" B[ %-2d]=%d ║\n", leg, b[leg]);
                if (i + 1 != b.length / 2) System.out.print("╠════════════╬════════════╣\n");
                leg++;
            }
            System.out.print("╚════════════╩════════════╝\n");
        }
        if ((b.length > 2) && (b.length % 2 == 1)) {
            int leg = b.length / 2 + 1;
            for (int i = 0; i <= b.length / 2; i++) {
                if (i == 0) {
                    System.out.print("╔════════════╦════════════╗\n");
                }
                System.out.printf("║ B[ %-2d]=%d ║", i, b[i]);
                if (i == b.length / 2) break;
                System.out.printf(" B[ %-2d]=%d ║\n", leg, b[leg]);
                if (i != b.length / 2) System.out.print("╠════════════╬════════════╣\n");
                leg++;
            }
            System.out.print("            ║\n");
            System.out.print("╚════════════╩════════════╝\n");
        }
    }

    private static void step1() {
        int leg = (int) (random() * 21 + 20);
        double[] array = new double[leg];
        double x = 5.33;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = cbrt(x * x + 4.5);
            if ((i + 1) % 5 == 0 || i == array.length - 1) {
                System.out.printf("A[ %-2d]=%f\n", i, array[i]);
            } else System.out.printf("A[ %-2d]=%f   ", i, array[i]);
            if (array[i] > 3.5) j++;
        }
        double[] arrayMore = new double[j];
        double geomSum = 0;
        j = 0;
        for (double v : array) {
            if (v > 3.5) {
                arrayMore[j] = v;
                geomSum = geomSum * arrayMore[j];
                j++;
            }
        }
    }
}