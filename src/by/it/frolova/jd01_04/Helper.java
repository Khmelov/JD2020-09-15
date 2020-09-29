package by.it.frolova.jd01_04;


import static by.it.frolova.jd01_04.InOut.printArray;

public class Helper {
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
        return max;
    }

    static void sort(double[] arr) {
        printArray(arr);
        boolean swap;
        double lastElem = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < lastElem; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;
                }
            }
            lastElem--;
        } while (swap);

        printArray(arr);
    }

    static void sectionSort(double[] arr) {
        for (int start = 0; start < arr.length - 1; start++) {
            int min = start;
            for (int i = start + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = i;
                }
            }
           double tmp = arr[start];
            arr[start] = arr[min];
            arr[min] = tmp;
        }
        printArray(arr);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
            
        }
        printArray(result); //переделать - неправильный вывод
        return result;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] matrixresult = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    matrixresult[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return matrixresult;
    }

}
