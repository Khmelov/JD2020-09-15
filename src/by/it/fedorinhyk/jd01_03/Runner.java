package by.it.fedorinhyk.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double[] array=InOut.getArray("1.342 40 60 99 10000");
        InOut.printArray(array);
        InOut.printArray(array,"v",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

    }
}
