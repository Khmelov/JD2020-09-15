package by.it.fedorinhyk.jd01_04;

public class TaskC {
    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }

    static void mergeSort(double[] array) {
        mergeSort(array,0,array.length-1);

    }


    private static void mergeSort(double[] array, int left, int right) {
        int mid = left + ((right - left) / 2) + 1;
        if (mid > 0 && right > (left + 1)) {
            mergeSort(array, left, mid - 1);
            mergeSort(array, mid, right);
        }
        int[] buffer = new int[right - left + 1];
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            if (mid > right || array[cursor] > array[mid]) {
                buffer[i] = (int) array[cursor];
                cursor++;
            } else {
                buffer[i] = (int) array[mid];
                mid++;
            }
        }
        System.arraycopy(buffer, 0, array, left, buffer.length);

    }
    static void binarySearch(double[ ] array, double value){}


}
