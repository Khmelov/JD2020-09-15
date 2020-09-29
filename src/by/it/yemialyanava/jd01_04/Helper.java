package by.it.yemialyanava.jd01_04;

public class Helper {
    static double findMin (double[] arr) {
        double min;
        min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min >arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    static double findMax(double[ ] arr){
        double max;
        max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    static void sort(double[ ] arr){
        for (int j = 0; j<arr.length; j++) {
            int minimumindex = j;
            for (int i = j; i < arr.length; i++) {
                if (arr[minimumindex] > arr[i]) {
                    minimumindex = i;
                }
            }
            double temp = arr[j];
            arr[j] = arr[minimumindex];
            arr[minimumindex] = temp;
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mul[i][j] = mul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }

        }
        return mul;
    }
}

