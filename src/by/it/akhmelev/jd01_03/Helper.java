package by.it.akhmelev.jd01_03;

import java.util.Arrays;

class Helper {
    static void sort(double[] array){
        array[0]=10;
        Arrays.sort(array);
        InOut.printArray(array);
    }
}
