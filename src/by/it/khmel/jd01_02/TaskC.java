package by.it.khmel.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int[][] m = step1(n);

        step2(m);
        step3(m);

    }

    public static int[][] step1(int n) {
        int[][] m = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = (int) (Math.random() * (n + 1) * (int) Math.pow(-1, (int) (Math.random() * 10)));
            }//m[i][j]=-n+(int)(Math.random());
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(m[i][j] + "  ");
            }
        }
        return m;
    }

    public static int step2(int[][] mas) {

        int a = 0;
        int sum = 0;
        //mas=m;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) {
                        sum = sum + mas[i][j];
                }
                //  System.out.println(sum);
            }
        }
        System.out.println(sum);
        return sum;

    }

    static void step3(int[][] array) {
    }


}

