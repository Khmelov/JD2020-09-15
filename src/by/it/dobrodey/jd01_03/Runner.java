package by.it.dobrodey.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string with 5 double number:");
        String line = sc.nextLine();


        double[] array =InOut.getArray(line);   //перевод из строки в массив

        InOut.printArray(array);   //вывод массива


        InOut.printArray(array, "A", 3);   //вывод массива типа А[i]=element

        double min = Helper.findMin(array);  // нахождение Min значения массива
        System.out.printf("MIN = %-8.2f", min );
        System.out.printf("MAX = %-8.2f\n", Helper.findMax(array) );

        Helper.sort(array);                         // сортировка массива по возрастанию

        int size = array.length;
        double [][] matrix = WorkMatrix.newMatrix(size);
        Helper.mul(matrix,array);               //умножение матрицы на строку
        double [][] matrixTwo = WorkMatrix.newMatrix(size);
        Helper.mul(matrix,matrixTwo);           // умножение  матрицы на матрицу




        }








    }





