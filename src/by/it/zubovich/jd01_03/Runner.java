package by.it.zubovich.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("введите через пробел числа для постоения массива:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V", 4);
        System.out.println();
        Helper.sort(array);
        InOut.printArray(array,"V", 3);
        double min = Helper.findMin(array);
        System.out.println(min);
        double max = Helper.findMax(array);
        System.out.println(max);
        double[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        double[] vector = {7, 8, 9};
        double[][] matrixLeft = {{10, 11, 12}, {13, 14, 15}};
        double[][] matrixRight = {{16, 17, 18}, {19, 20, 21}, {22, 23, 24}, {25, 26, 27}};
        double[] mulMatrixOnVector = Helper.mul(matrix, vector);
        System.out.println(Arrays.toString(mulMatrixOnVector));
        double[][] mulMatrixOnMatrix = Helper.mul(matrixLeft,matrixRight);
        System.out.println(Arrays.deepToString(mulMatrixOnMatrix));


    }

}
