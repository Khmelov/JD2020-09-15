package by.it.kolesnikov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] m = step1(4);
        System.out.println(Arrays.deepToString(m));
    }
    static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean minOk;
        boolean maxOk;
        do {
            maxOk=false;
            minOk=false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (arr[i][j] == n) maxOk = true;
                    if (arr[i][j] == -n) minOk = true;

                }
            }
        }
        while (!minOk || !maxOk);
        return arr;
    }

    }