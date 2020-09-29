package by.it.zubovich.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("введите натуральное число, или не вводите ничего:");
        Scanner sc = new Scanner(System.in);
        int[][] n = step1(sc.nextInt());
        System.out.println(Arrays.deepToString(n));
    }
    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean minOk;
        boolean maxOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -5 + (int) (Math.random() * (2 * 5 + 1));
                    if (arr[i][j] == 5) maxOk = true;
                    if (arr[i][j] == -5) minOk = true;
                }
            }
        }
        while (!minOk || !maxOk);
        return arr;
    }
}
