package by.it.frolova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);


    }

    static void printMulTable() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double first = arr[0];
        double last = arr[arr.length - 1];
        Helper.sort(arr);
        InOut.printArray(arr,"V",4);
        InOut.printArray(arr);
        int indexFirst = Arrays.binarySearch(arr, first);
        int indexLast = Arrays.binarySearch(arr, last);
        System.out.println("Index of first element=" + indexFirst + "\n" + "Index of last element=" + indexLast);

        }

    }

