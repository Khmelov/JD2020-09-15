package by.it.dobrodey.jd01_04;


import java.util.Scanner;

public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double finish = array[array.length - 1];
        //Helper.sort(array);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = binarySearch(array, first);
        System.out.println("Index of first element=" + indexFirst);
        int indexFinish = binarySearch(array, finish);
        System.out.println("Index of last element=" + indexFinish);

    }

    public static void main(String[] args) {
        System.out.println("Input line:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }


    static void mergeSort(double[] array) {
        int n = array.length;
        if (n < 2) {
            return;
        }
        int mid = (int) (n / 2);
        double[] l = new double [mid];
        double[] r = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int j = mid; j < n; j++) {
            r[j - mid] = array[j];
        }
        mergeSort(l,0, mid);
        mergeSort(r, mid, n);

        merge(array, l, r, mid, n - mid);
    }



    private static void mergeSort(double[] array, int left, int right) {
        int n = -(left - right);
        if (n < 2) {
            return;
        }
        int mid = (int) (n / 2);
        double[] l = new double [mid];
        double[] r = new double[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int j = mid; j < n; j++) {
            r[j - mid] = array[j];
        }
        mergeSort(l,0, mid);
        mergeSort(r, mid, n);

        merge(array, l, r, mid, n - mid);

    }

    public static void merge(double[] array, double[] l, double[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }


    static int binarySearch(double[] array, double value) {
        int l = 0;
        int r = array.length;
        while (l <= r) {
            int m = (int) ((l + r) / 2);
            if (array[m] == value) {
                return m;
            } else if (array[m] > value) {
                r = m - 1;
            } else
                l = m + 1;
        }
        return -1;
    }


}








