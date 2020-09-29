package by.it.fedorinhyk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean minok;
        boolean maxok;


            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = (int) (Math.random() * (2 * n + 1));
                    if (arr[i][j] == n) maxok = true;
                    if (arr[i][j] == -n) minok = true;
                }

            }




    }
}