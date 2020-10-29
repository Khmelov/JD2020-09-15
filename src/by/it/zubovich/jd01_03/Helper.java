package by.it.zubovich.jd01_03;

public class Helper {

    static void sort(double[ ] massive) {
        for (int last = massive.length - 1; last >= 0; last--) {
            for (int i = 0; i < last; i++) {
                if (massive[i]>massive[i+1]){
                    double tmp=massive[i];
                    massive[i]=massive[i+1];
                    massive[i+1]=tmp;
                }
            }
        }
    }

    static double findMax(double[ ] arr) {
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

    static double findMin(double[] arr) {
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
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[ ] arr = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < vector.length; i1++) {
                arr[i] = arr[i] + matrix[i][i1] * vector[i1];
            }
        }
        return arr;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[ ][ ] arr = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    arr [i][j] = arr [i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return arr;
    }
}

