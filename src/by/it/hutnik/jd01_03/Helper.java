package by.it.hutnik.jd01_03;

import java.util.Arrays;

public class Helper {
    static double findMin(double[ ] arr){
        if (0 == arr.length){
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double v : arr) {
                if (min>v) min=v;
            }
            return min;
        }
    }

    static double findMax(double[ ] arr){
        if (0 == arr.length){
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double v : arr) {
                if (max<v) max=v;
            }
            return max;
        }
    }
    static void sort (double[] arr){
        double arrSort = arr[0];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arrSort) arrSort = arr[i];
        }
    }

}
