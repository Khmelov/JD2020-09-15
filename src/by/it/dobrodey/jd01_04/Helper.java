package by.it.dobrodey.jd01_04;

import by.it.dobrodey.jd01_03.WorkMatrix;

import java.util.Arrays;

public class Helper {
    /**
     * Метод нахождения минимального элемента массива
     *
     * @param arr - входной массив
     * @return min - минимальное значение
     */
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Метод нахождения максимального элемента массива.
     *
     * @param arr - входной массив
     * @return max - максимальное значение
     */

    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Методы sort и sort1 методы сортировки от минимального до максимального значения
     *
     * @param arr -входной массив
     */

    static void sort(double[] arr) {
        Arrays.sort(arr);

    }

    static void sort1(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //Сравниваем элементы попарно,если они имеют неправильный порядок,
                //              то меняем местами
                if (arr[j] > arr[j + 1]) {
                    double tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("Sorted array:");
        InOut.printArray(arr);
    }

    /**
     * @param matrix - входная матрица
     * @param vector - входной вектор
     * @return mul- вектор, результат произведения матрицы и векотора
     */


    static double[] mul(double[][] matrix, double[] vector) {
        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] += matrix[i][j] * vector[j];
            }

        }
        System.out.println("Result of matrix and array multiplication:");
        InOut.printArray(mul, "mul", 5);
        return mul;
    }

    /**
     * @param matrixLeft   -вводимая матрица
     * @param matrixRight- вводимая матрицы
     * @return -выводит результат произведения 2-х матриц
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resMul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++)
                    resMul[i][j] = resMul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
            }

        }
        System.out.println("Result of matrix and matrix multiplication:");
        WorkMatrix.printMatrix(resMul, "A");

        return resMul;
    }


}
