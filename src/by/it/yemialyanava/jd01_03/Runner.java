package by.it.yemialyanava.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double min = Helper.findMin(array);
        double max = Helper.findMax(array);
        Helper.sort(array);
        double[] vector = {1, 7, 6, 8};
        double[][] matrixLeft = {{1, 5, 2, 7}, {4, 8, 1, 2}};
        double[][] matrixRight = {{5, 6, 2, 6}, {8, 4, 2, 2}, {2, 0, 6, 7}, {8,0,6,4}};
        double[] nMul = Helper.mul(matrixLeft, vector);
        System.out.println(Arrays.toString(nMul));
        double[][] newMatrix = Helper.mul(matrixLeft, matrixRight);
        System.out.println(Arrays.deepToString(newMatrix));
    }
}
