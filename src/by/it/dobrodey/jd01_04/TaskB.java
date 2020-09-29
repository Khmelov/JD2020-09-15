package by.it.dobrodey.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                   //n-quantity people
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
        }

        int[][] wage = new int[n][4];
        int[] res = new int[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                wage[i][j] = sc.nextInt();
                res[i] += wage[i][j];
                total += wage[i][j];
            }
        }

        double mean = total / n / 4;
        System.out.println("--------------------------------------------------");
        System.out.println("Фамилия  Квартал1 Квартал2 Квартал3 Квартал4 Итого");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%7s: %-8d %-8d %-8d %-8d %-5d\n", name[i],
                    wage[i][0], wage[i][1], wage[i][2], wage[i][3], res[i]);
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("Итого     %3d\n", (int) total);
        System.out.printf("Средняя   %-7.4f", mean);
    }
}
