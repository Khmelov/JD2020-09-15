package by.it.kolesnikov.jd01_03;


import java.util.Scanner;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        int coloumnCount = sc.nextInt();
        InOut.printArray(array);
        InOut.printArray(array, "V", coloumnCount);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort (array);
    }
}
