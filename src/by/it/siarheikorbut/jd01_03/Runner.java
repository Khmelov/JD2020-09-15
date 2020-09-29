package by.it.siarheikorbut.jd01_03;

import java.util.Arrays;

import static by.it.siarheikorbut.jd01_03.InOut.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1L5Z3U4Iv8EyTak0vgQ3IvNlZMXvPONAH/view?usp=sharing">Проверка методов заданий JD01_03 ( A, B, C )</a>
 */

public class Runner {
    public static void main(String[] args) {

        //Ввод одномерного массива.
        double[] array = getArray("1.234 2 3 4 60000");
        System.out.println(Arrays.toString(array));

        //Простой вывод одномерного массива.
        printArray(array);

        //Форматный вывод одномерного массива.
        printArray(array, 3);

        //Поиск минимального значения в одномерном массиве типа double.
        double[] arr1 = {7.4, 8.2, 9.1, 3.3, 1.5, 2.2};
        double min = Helper.findMin(arr1);
        System.out.println(min);


        //Поиск максимального значения в одномерном массиве типа double.
        double[] arr2 = {7.4, 8.2, 9.1, 3.3, 1.5, 2.2};
        double max = Helper.findMax(arr2);
        System.out.println(max);

        //Сортировка по возрастанию одномерных массивов типа double.
        double[] arr3 = {8.5, 43.0, 54.0, 76.0, 21.0, 43.0};
        Helper.sort(arr3);
        for (double v : arr3) {
            System.out.print(v + " ");
        }
        System.out.println();

        //Умножение матрицы на вектор типа double.
        double[][] matrix = {{5.4, 2.1, 9.2, 8.9}, {4.6, 7.3, 6.8, 9.1}, {4.3, 9.9, 5.0, 6.1}};
        double[] vector = {3.0, 1.4, 6.7, 7.9};
        double[] res = Helper.mul(matrix, vector);
        for (double re : res) {
            System.out.print(Math.round(re * 100.0) / 100.0 + " | ");
        }
        System.out.println();

        //Умножение матрицы на матрицу типа double.
        double[][] matrixLeft = {{2.3, 3.5, 8.0, 4.2}, {7.4, 6.7, 3.1, 9.3}, {3.4, 4.0, 3.6, 1.9}};
        double[][] matrixRight = {{5.3, 8.1, 2.0, 5.8}, {7.2, 4.7, 9.5, 1.1}, {4.8, 9.9, 7.1, 5.5}};
        double[][] resMatrix = Helper.mul(matrixLeft, matrixRight);
        for (double[] doubles : resMatrix) {
            for (double aDouble : doubles) {
                System.out.print(Math.round(aDouble * 100.0) / 100.0 + " | ");
            }
        }
        System.out.println();
    }
}
