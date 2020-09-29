package by.it.yemialyanava.jd01_04;
import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String futureArray = sc.nextLine();
        buildOneDimArray(futureArray);
    }

    private static void buildOneDimArray(String line) {
        double[] sarray = InOut.getArray(line);
        double first = sarray[0];
        double last = sarray[sarray.length - 1];
        InOut.printArray(sarray, "V", 5);
        mergeSort(sarray);
        InOut.printArray(sarray, "V", 4);
        int firstPosition = binarySearch(sarray, first);
        System.out.printf("%s[% -3d]=% -10.2f%-25s", "V", firstPosition, first, "Index of first element\n");
        int lastPosition = binarySearch(sarray, last);
        System.out.printf("%s[% -3d]=% -10.2f%-25s", "V", lastPosition, last, "Index of last element");
    }

    private static void mergeSort(double[] array){
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(double[] array, int indexLeft, int middleIndex, int indexRight) {
        double[] tempArray = new double[indexRight - indexLeft + 1];
        int k = 0;
        int i = indexLeft;
        int j = middleIndex + 1;
        while ((i <= middleIndex) && (j <= indexRight)) {
            if (array[i] < array[j]) {
                tempArray[k] = array[i];
                i++;
                k++;
            } else {
                tempArray[k] = array[j];
                j++;
                k++;
            }
        }
        while (j <= indexRight) {
            tempArray[k] = array[j];
            j++;
            k++;
        }
        while (i <= middleIndex) {
            tempArray[k] = array[i];
            i++;
            k++;
        }
        int v = indexLeft;
        for (int l = 0; l < tempArray.length; l++) {
            array [v++]=tempArray[l];
        }
        System.out.println(Arrays.toString(tempArray));
    }


    static int binarySearch(double[] array, double value) {
        int position = 0;
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == value) {
                return middleIndex;
            }
            if (array[middleIndex] < value) {
                firstIndex = middleIndex + 1;
            }
            if (array[middleIndex] > value) {
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }
}
