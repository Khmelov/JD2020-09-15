package by.it.siarheikorbut.jd01_04;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1hLOOxXWbCfr8iQZagfAMMBrUG-_0-yr4/view?usp=sharing">Задания JD01_04</a>
 */

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstArray = array[0];
        double lastArray = array[array.length - 1];
        InOut.printArray(array, 5);
        mergeSort(array);
        InOut.printArray(array, 4);
        int firstIndex = binarySearch(array, firstArray);
        int lastIndex = binarySearch(array, lastArray);
        System.out.printf("Index of first element=%d" + "\n" +
                "Index of last element=%d", firstIndex, lastIndex);
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length;
        int m = (left + right) / 2;
        int res = -1;
        do {
            if (array[m] == value) {
                res = m;
            }
            if (array[m] > value) {
                right = m;
                m = (left + right) / 2;
            }
            if (array[m] < value) {
                left = m;
                m = (left + right) / 2;
            }
        }
        while (res == -1);
        return res;
    }

    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length;
        int middle;
        if (array.length < 2) {
            return;
        }

        middle = (left + right) / 2;
        double[] part1 = new double[middle];
        double[] part2 = new double[right - middle];

        System.arraycopy(array, 0, part1, 0, middle);

        if (right - middle >= 0) System.arraycopy(array, middle, part2, 0, right - middle);
        mergeSort(part1);
        mergeSort(part2);
        double[] array1;
        array1 = merge(part1, part2);
        System.arraycopy(array1, 0, array, 0, array.length);
        InOut.printArray(array);
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] array = new double[part1.length + part2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < array.length; i3++) {
            if (i1 == part1.length) {
                array[i3] = part2[i2];
                i2++;
            } else if (i2 == part2.length) {
                array[i3] = part1[i1];
                i1++;
            } else if (part1[i1] < part2[i2]) {
                array[i3] = part1[i1];
                i1++;
            } else if (part1[i1] > part2[i2]) {
                array[i3] = part2[i2];
                i2++;
            }
        }
        return array;
    }
}