package by.it.lapkovskiy.jd01_04;

public class Helper {
    public static void main(String[] args) {

    }

    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double unit : arr) {
            if (unit < min) {
                min = unit;
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double unit : arr) {
            if (unit > max) {
                max = unit;
            }
        }
        return max;
    }

    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
           System.out.println(arr[i]);
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] += matrix[i][j] * vector[j];
            }
        }
        return resultVector;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; ++i)
            for (int j = 0; j < matrixRight[0].length; ++j)
                for (int k = 0; k < matrixRight.length; ++k) {
                    resultMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
        return resultMatrix;
    }
    static int find(double[] arr,int index){
        while (true){

            break;
        }
        return index;
    }
}
