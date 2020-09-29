package by.it.frolova.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();
        String mr = sc.nextLine();
        String line = sc.nextLine();

        double[] arr = InOut.getArray(line);
        double[][] matrix = InOut.getMatrix(m);
        double[][] matrixLeft = InOut.getMatrix(m);
        double[][] matrixRight = InOut.getMatrix(mr);

        InOut.printArray(arr);
        InOut.printArray(arr, "S", 2);
        Helper.findMax(arr);
        Helper.findMin(arr);
        Helper.sort(arr);
        Helper.sectionSort(arr);
        Helper.mul(matrix, arr);
        Helper.mul(matrixLeft, matrixRight);

    }
}
