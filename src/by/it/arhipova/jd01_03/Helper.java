package by.it.arhipova.jd01_03;

public class Helper {
    static void sort(double[] a){
        for (int last = a.length-1; last > 1; last--) {
            for (int i = 0; i < last; i++) {
                if(a[i] > a[i+1]){
                    double buf = a[i];
                    a[i] = a[i+1];
                    a[i+1] = buf;
                }
            }
        }
    }
    static double findMin(double [] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min>arr[i]) min=arr[i];
        }
        System.out.println(min);
        return min;

    }
    static double findMax(double [] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]) max=arr[i];
        }
        System.out.println(max);
        return max;

    }
}

