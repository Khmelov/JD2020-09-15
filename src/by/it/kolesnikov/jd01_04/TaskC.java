package by.it.kolesnikov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V", 5);
        double first=array[0];
        double last=array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array,"V", 4);
        int indexFirst= Arrays.binarySearch(array, first);                         //Вариант со скоростью log n
        System.out.printf("Index of first element=%d\n", indexFirst);

        for (int i = 0; i < array.length; i++) {                               //Вариант со скоростью n
            if(last==array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }
}
