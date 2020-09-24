package by.it.khmel.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double min = Helper.findMin(array);
        System.out.println("Минимальный элемент  " + min);
        double max = Helper.findMax(array);
        System.out.println("Максимальный элемент  " + max);
        Helper.sort(array);
        System.out.println("Массив по возрастанию");
        InOut.printArray(array);
        System.out.println("Умножение матрицы на вектор");
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        double[] vector = {1, 2, 3};
        double[] mull = Helper.mul(matrix, vector);
        InOut.printArray(mull);

        System.out.println("Умножение матрицы на матрицу");
//        double[][] Left = {{1, 2}, {3, 4}};
//        double[][] Right = {{5, 6}, {7, 8}};
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        double[][] arr = Helper.mul(left, right);
        Helper.printArray(arr);

    }
}
