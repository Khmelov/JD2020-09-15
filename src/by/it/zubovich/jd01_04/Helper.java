package by.it.zubovich.jd01_04;

import java.util.Scanner;

public class Helper {
    static void sort(double[] array){



    }
     static double findMax(double[] arr){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        double[] arr = new double[n];
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        }

    }
    public static double findMin(double[] arr){
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double i : arr) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        }

    }





}
