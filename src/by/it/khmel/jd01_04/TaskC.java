package by.it.khmel.jd01_04;

public class TaskC {

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
       // Helper.sort(array);

        InOut.printArray(array, "V", 4);

        for (int i = 0; i < array.length; i++) {
            if (first == array[i]) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int j = 0; j < array.length; j++) {
            if (last == array[j])
                System.out.println("Index of last element=" + j);

        }
    }

    static void mergeSort(double[ ] array){
    }
}
