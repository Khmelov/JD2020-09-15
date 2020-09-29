package by.it.hutnik.jd01_02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][]m = step1(n);
        System.out.println(Arrays.deepToString(m));
    }

    static int[][] step1(int n)

    {
        int[][] arr = new int[n][n];
        boolean minOK;
        boolean maxOK;
        do {
            minOK = false;
            maxOK = false;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = -n + (int) (Math.random() * (2 * n + 1));
                    if (arr[i][j] == -n) minOK = true;
                    if (arr[i][j] == n) maxOK = true;
                }
            }
        } while ((!minOK || !maxOK));
        return arr;

    }
}
