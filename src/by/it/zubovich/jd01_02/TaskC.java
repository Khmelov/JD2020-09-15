package by.it.zubovich.jd01_02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("введите натуральное число, или не вводите ничего:");
        Scanner sc = new Scanner(System.in);
        int[][] arr = step1(sc.nextInt());
        System.out.println(Arrays.deepToString(arr));
        step2(arr);
        step3(arr);
    }
    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean maxOk, minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < arr.length; ++i) {
                for (int j = 0; j < arr[i].length; ++j) {
                    int min = -n;
                    int diff = n - min;
                    Random random = new Random();
                    int r = random.nextInt(diff + 1);
                    r += min;
                    arr[i][j] = r;
                    if (arr[i][j] == n) maxOk = true;
                    if (arr[i][j] == -n) minOk = true;
                }
            }
        }
        while (!(minOk || maxOk));
        return arr;
    }
    private static int step2(int[ ][ ] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int i1 = 0; i1 < arr[i].length - 1; i1++) {
                if (arr[i][i1] > 0) {
                    temp += 1;
                }
                if (arr[i][i1 + 1] < 0 && temp == 1) {
                    sum += arr[i][i1 + 1];
                }
            }
        }
        System.out.println("\n" + sum);
        return sum;
    }
    private static int[ ][ ] step3(int[ ][ ] arr){
        
        return arr;
    }
}
