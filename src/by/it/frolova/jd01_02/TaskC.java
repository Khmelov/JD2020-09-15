package by.it.frolova.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = step1(n);
        step2(arr);
        step3(arr);

    }

    private static int[][] step1(int n) {

        int[][] arr = new int[n][n];

        boolean min = false;
        boolean max = false;

        do {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int) (Math.random() * (2 * n + 1)); //(int) (rnd.nextDouble() * 2 * n - n);
                    if (arr[i][j] == n) {
                        max = true;
                    }
                    if (arr[i][j] == -n) {
                        min = true;
                    }
                }
            }
        } while (!min || !max);

        for (int i = 0; i < arr.length; i++, System.out.println()) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean start = false;
            int tempSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (start) {
                    if (arr[i][j] <= 0) {
                        tempSum += arr[i][j];
                    } else {
                        start = false;
                        break;
                    }
                } else if (arr[i][j] > 0) {
                    start = true;
                }
            }
            if (!start) {
                sum += tempSum;
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;

        // find max value
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);

        boolean[] delRows = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delRows[i] = true;
                }
            }
        }
        System.out.println(Arrays.toString(delRows));

        boolean[] delCols = new boolean[arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j][i] == max) {
                    delCols[i] = true;

                }
            }
        }
        System.out.println(Arrays.toString(delCols));

        int rows = 0;
        int cols = 0;
        for (int i = 0; i < delRows.length; i++) {
            if (!delRows[i]) {
                rows++;
            }
        }
        for (int i = 0; i < delCols.length; i++) {
            if (!delCols[i]) {
                cols++;
            }
        }
        System.out.println("rows: " + rows + ", cols: " + cols);

        int arrNew[][] = new int[rows][cols];

        int iN = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!delRows[i]) {
                int jN = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!delCols[j]) {
                        arrNew[iN][jN] = arr[i][j];
                        jN++;
                    }
                }
                iN++;
            }

        }

        // print result
        for (int i = 0; i < arrNew.length; i++, System.out.println()) {
            for (int j = 0; j < arrNew[i].length; j++) {
                System.out.print(arrNew[i][j] + " ");
            }
        }
        return arrNew;
    }
}