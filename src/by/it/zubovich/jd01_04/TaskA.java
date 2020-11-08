package by.it.zubovich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    //    static void printMulTable() {
//        for (int i = 2; i < 10; i++) {
//            for (int j = 2; j < 10; j++) {
//                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
//            }
//            System.out.println();
//        }
//    }
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                String line = i + "*" + j + "=" + i * j + " ";
                if (line.length() < 7) {
                    line = line + " ";
                }
                System.out.print(line);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMulTable();
        System.out.println("введите числа через пробел для построения массива и его сортировкиЖ");
        Scanner sc = new Scanner(System.in);
        String strLine = sc.nextLine();
        buildOneDimArray(strLine);
    }

    //    static void buildOneDimArray(String line) {
//        double[] array = InOut.getArray(line);
//        double first = array[0];
//        double last = array[array.length-1];
//        InOut.printArray(array,"V", 5);
//        Helper.sort(array);
//        System.out.println();
//        InOut.printArray(array, "V", 4);
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == first) {
//                System.out.println("Index of first element=" + i);
//                break;
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] == last) {
//                System.out.println("Index of last element=" + i);
//                break;
//            }
//        }
//    }
    static void buildOneDimArray(String line) {

        String[] stringLine = line.trim().split(" ");
        Double[] arrLine = new Double[stringLine.length];
        // заполнение массива
        for (int i = 0; i < stringLine.length; i++) {
            double temp = Double.parseDouble(stringLine[i]);
            arrLine[i] = temp;
        }
        double firstElement = arrLine[0],
                lastElement = arrLine[arrLine.length - 1];

        // печать в 5 колонок
        printCount(arrLine, 5);
        System.out.println();
        Arrays.sort(arrLine);

        // печать в 4 колонки после сортировки
        printCount(arrLine, 4);

        int indexFirstElement = Arrays.asList(arrLine).indexOf(firstElement);
        int indexLastElement = Arrays.asList(arrLine).indexOf(lastElement);
        System.out.println("\nIndex of first element="+indexFirstElement);
        System.out.println("Index of last element="+indexLastElement);
    }

    static void printCount(Double[] arrayForPrint, int columnCount) {
        for (int i = 0; i < arrayForPrint.length; i++) {
            if (i % columnCount == 0) {
                System.out.println();
            }
            System.out.printf("%s[%2d]=%3f ", "V", i, arrayForPrint[i]);
        }
    }

}
