package by.it.lapkovskiy.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        /*System.out.println((int) 3 / 2);
        double[] array = new double[]{10, 9, 10, 5, 21, 7, 2, 0};
        mergeSort(array);
        InOut.printArray(array);*/
        System.out.println('^'+'^');
    }

    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        double start = arr[0];
        double stop = arr[arr.length - 1];
        InOut.printArray(arr, "V", 5);
        Helper.sort(arr);
        InOut.printArray(arr, "V", 5);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == stop) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }
    }
    static void mergeSort(double[] array) {
         mergeSort(array, array.length);
    }
    static void mergeSort(double[] array, int highIndex) {
        if (highIndex < 2) {
            return;
        }
        int mid = highIndex/2;
        double[]l = new double[mid];
        double[]r = new double[highIndex - mid];

        for (int i = 0; i < mid; i++) {
            l[i]= array[i];
        }
        for (int i = mid; i < highIndex; i++) {
            r[i - mid]= array[i];
        }
        mergeSort(l, mid);
        mergeSort(r, highIndex - mid);

        merge(array, l, r, mid, highIndex - mid);
    }
    public static void merge(double[] array, double[]l, double[]r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i]<= r[j]) {
                array[k++]= l[i++];
            }
            else {
                array[k++]= r[j++];
            }
        }
        while (i < left) {
            array[k++]= l[i++];
        }
        while (j < right) {
            array[k++]= r[j++];
        }
    }
    static int binarySearch(double[ ] array, double value){
        int start = 0;
        int end = array.length;
        int mid = (start + end)/2;
        while( start <= end ){
            if ( array[mid] < value ){
                start = mid + 1;
            }else if ( array[mid] == value ){
                return mid;
            }else{
                end = mid - 1;
            }
            mid = (start + end)/2;
        }
        if ( start > end ){
            System.out.println("Element is not found!");
        }
        return start;
    }
}
