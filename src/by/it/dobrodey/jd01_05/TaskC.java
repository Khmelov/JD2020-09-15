package by.it.dobrodey.jd01_05;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        step();

    }

    private static void step() {
        int size =(int) (Math.random()*20+20);
        double delta = (9-5.33)/(size-1);
        double[] arr = new double[size];
        int i = 0; int sizeB = 0;
        System.out.println("Array A");
        for (double x = 5.33; x <=9 ; x=x+delta) {
            arr[i] = Math.cbrt(x*x+4.5);
            if (arr[i]>3.5){
                 sizeB = sizeB+1;
            }
            i++;
        }
        InOut.printArray(arr,"A",5);
        Arrays.sort(arr);
        double[] arrB = new double[sizeB];
        i=0; int j = 0;
        double sum = 0;
        for (double x = 5.33; x <=9 ; x=x+delta) {
            if (arr[i]>3.5){ arrB[j++] = arr[i]; sum=sum+arr[i];}
            i++;
        }
        double srgeom = sum/(double)sizeB;
        System.out.println("Array B[],when elements > 3.5");
        InOut.printArray(arrB,"B",5);
        System.out.println("srednee geometricheskoe = "+ srgeom);

    }


}
