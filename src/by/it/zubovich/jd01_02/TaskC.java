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
        //step2(arr);
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

/*    private static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) { //TODO
                int tempPositive = 0;
                int tempNegative = 0;
                for (int k = 1; k < arr[i].length - 1; k++) {
                    if (arr[i][j] > 0 && arr[i][k] < 0 && arr[i][k] > 0) {
                        sum = sum + arr[i][j];
                    }
                }
                *//*if (arr[i][j+1]<0){
                    tempNegative = tempNegative + 1;
                }

                if (arr[i][j + 1] < 0 && tempPositive == 1 && arr[i][j + 2] > 0) {
                    sum = sum + arr[i][j + 1];
                }*//*
            }
        }
        return sum;
    }*/
//        System.out.println("\n" + sum + "\n");
//        return sum;


        private static int[ ][ ] step3(int[ ][ ] arr){
            int max = arr[0].length;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }
            System.out.println(max);

            boolean[] line = new boolean[arr.length];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == max) {
                        line[i] = true;
                    }
                }
            }
            //System.out.println(Arrays.toString(line));

            boolean[] vertLine = new boolean[arr.length];
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j][i] == max) {
                        vertLine[i] = true;
                    }
                }
            }
            //System.out.println(Arrays.toString(vertLine));

            int lines = 0;
            int vertLines = 0;
            for (int i = 0; i < line.length; i++) {
                if (!line[i]) {
                    lines++;
                }
            }
            for (int i = 0; i < vertLine.length; i++) {
                if (!vertLine[i]) {
                    vertLines++;
                }
            }
            System.out.println("line " + lines + ", top " + vertLines);

            int[][] arrFinal = new int[lines][vertLines];

            int iN = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!line[i]) {
                    int jN = 0;
                    for (int j = 0; j < arr[i].length; j++) {
                        if (!vertLine[j]) {
                            arrFinal[iN][jN] = arr[i][j];
                            jN++;
                        }
                    }
                    iN++;
                }

            }

            for (int i = 0; i < arrFinal.length; i++) {
                System.out.println();
                for (int i1 = 0; i1 < arrFinal[i].length; i1++) {
                    System.out.print(arrFinal[i][i1] + " ");
                }
            }
            return arrFinal;
        }
    }

