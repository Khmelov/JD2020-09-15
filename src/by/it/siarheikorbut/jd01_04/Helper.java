package by.it.siarheikorbut.jd01_04;

import java.util.Arrays;


public class Helper {

    //Поиск минимального значения в одномерном массиве типа double.
    static double findMin(double[] arr) {
        double minValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        return minValue;
    }

    //Поиск максимального значения в одномерном массиве типа double.
    static double findMax(double[] arr) {
        double maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //Сортировка по возрастанию одномерных массивов типа double.
    static void sort(double[] arr) {
        double arrSort = arr[0];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arrSort) {
                arrSort = arr[i];
            }
        }
    }

    //Умножение матрицы на вектор типа double.
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resVector = new double[matrix.length];
        for (int i = 0; i < resVector.length; i++) {
            double res = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                res += matrix[i][j] * vector[j];
            }
            resVector[i] = res;
        }
        return resVector;
    }

    //Умножение матрицы на матрицу типа double.
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double m = matrixLeft.length;
        double n = matrixRight[0].length;
        double o = matrixRight.length;
        double[][] resMatrix = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    resMatrix[i][j]+=matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }
        return resMatrix;
    }
}
