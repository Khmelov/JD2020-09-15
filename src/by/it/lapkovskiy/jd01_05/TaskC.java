package by.it.lapkovskiy.jd01_05;

import javax.sound.sampled.AudioFormat;
import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
        Random random = new Random();
         step1(random.nextInt(20)+20);
    }
    static void  step1(int a){
        Random random = new Random();
        double[] arrayA = new double[a];
        int row = 0;
        double x = 5.33;
        double z;
        int unitM =0;
        System.out.println("Массив A[]");
        double step = 3.67/ arrayA.length;
        for (int i = 0; i < arrayA.length; i++) {
           // x = (random.nextInt(367) + 533) / 100.0;
            z = Math.pow(x * x + 4.5, 1 / 3.0);
            if(z>3.5){
                unitM++;
            }
            arrayA[i] = z;
            System.out.printf("A[ %-2d] = %-10.5f ", i, z);
            if (row == 4) {
                System.out.println();
                row = 0;
                x+=step;
                continue;
            }
            row++;
            x+=step;
        }
        System.out.println();
        double[] arrayB = new double[unitM];
        int arr=0;
        double mulArr = 1;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i]>3.5){
                arrayB[arr] = arrayA[i];
                mulArr= mulArr * arrayB[arr];
                arr++;
            }
        }
        row = 0;
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < arrayB.length; i++) {
            System.out.printf("B[ %-2d] = %-10.5f ", i, arrayB[i]);
            if (row == 4) {
                System.out.println();
                row = 0;
                continue;
            }
            row++;
        }
        System.out.printf("\n %.5f",Math.pow(mulArr,1.0/unitM));
    }

}
