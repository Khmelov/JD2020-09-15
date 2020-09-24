package by.it.khmel.jd01_04;

//import java.util.Random;
//import java.util.Scanner;

public class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }


    static void sort(double[] arr) {
        double b;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    b = arr[i];
                    arr[i] = arr[j];
                    arr[j] = b;
                }
            }
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {

        // matrix * vector
        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] = mul[i] + matrix[i][j] * vector[j];
            }
        }
        return mul;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight.length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    mul[i][j] = mul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return mul;
    }

    static void printArray(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}



