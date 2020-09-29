package by.it.yemialyanava.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        buildOneDimArray(str);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line) {
        double[] sarray = InOut.getArray(line);
        double first = sarray[0];
        double last = sarray[sarray.length - 1];
        InOut.printArray(sarray, "V", 5);
        Helper.sort(sarray);
        InOut.printArray(sarray, "V", 4);
        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < sarray.length; i++) {
            if (sarray[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
}


