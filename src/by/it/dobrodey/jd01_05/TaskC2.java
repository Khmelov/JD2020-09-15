package by.it.dobrodey.jd01_05;

import java.util.Arrays;



public class TaskC2 {
    public static void main(String[] args) {
        int [] arrA = new int[31];
        int sizeB=0;
        for (int i = 0; i < 31; i++) {
            arrA[i] = (int) (Math.random()*(450-103))+103;
            if (0.1*arrA[i]>i){sizeB=sizeB+1;}
        }
        System.out.println("Array A:");
        InOut.printArray(arrA,"A",5);
        int[] arrB = new int[sizeB];
        int elementB = 0;
        for (int i = 0; i < 31.0; i++) {
            if ((double) i<(arrA[i]/10.0)){
                arrB[elementB]=arrA[i];
                elementB = elementB+1;
            }

        }
        int lineArrB = (int) (Math.ceil(sizeB/5.0));
        Arrays.sort(arrB);
        for (int i = 0; i < lineArrB; i++) {
            for (int j = i; j < sizeB; j = j + lineArrB) {
                System.out.printf("B[% -3d]=%-4d", j, arrB[j]);
            }
            System.out.println();


        }
    }


}
