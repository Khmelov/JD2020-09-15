package by.it.girovka.jd2;

import java.util.Scanner;

public class TaskC {
     static int [][] step1(int n) {
        int [][] arr = new int[n][n];
        boolean minOk;
        boolean maxOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (arr[i][j] == n) maxOk = true;
                    if (arr[i][j] == -n) minOk = true;
                }
            }
        } while (!minOk || !maxOk);
        return arr;

    }
    static int [][] step3(int [][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (element > max) max = element;
            }
        }
        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }
        int rows = 0;
        int cols = 0;
        for (boolean r : delRow) if (!r) rows++;
        for (boolean c : delCol) if (!c) cols++;

        int[][] res = new int[rows][cols];
        int ir = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!delRow[i]) {
                int ic = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!delCol[j]){
                        ir=0;
                    }
                }
            }


        }
        return arr;

    }
}
