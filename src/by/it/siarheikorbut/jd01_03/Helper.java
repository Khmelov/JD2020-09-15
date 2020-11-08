package by.it.siarheikorbut.jd01_03;

import java.util.Arrays;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1L5Z3U4Iv8EyTak0vgQ3IvNlZMXvPONAH/view?usp=sharing">Задания JD01_03</a>
 */

public class Helper {

    //Поиск минимального значения в одномерном массиве типа double.
    static double findMin(double[] arr) {
        double minValue = arr[0];
        for (double v : arr) {
            if (v < minValue) {
                minValue = v;
            }
        }
        return minValue;
    }

    //Поиск максимального значения в одномерном массиве типа double.
    static double findMax(double[] arr) {
        double maxValue = arr[0];
        for (double v : arr) {
            if (v > maxValue) {
                maxValue = v;
            }
        }
        return maxValue;
    }

    //Сортировка по возрастанию одномерных массивов типа double.
    static void sort(double[] arr) {
        double arrSort = arr[0];
        Arrays.sort(arr);
        for (double v : arr) {
            if (v < arrSort) {
                arrSort = v;
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
                    resMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return resMatrix;
    }
}