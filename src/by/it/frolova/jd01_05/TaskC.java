package by.it.frolova.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {

        int rndNum = 20 + (int) (Math.random() * 20);

        double arr[] = new double[rndNum];

        double x = 5.33;
        double d = (9 - 5.33) / (rndNum + 1);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = cbrt(pow(x, 2) + 4.5);
            x += d;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("A [%3d] = %f  ", i, arr[i]);
        }
        System.out.println();

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 3.5) {
                count++;
            }
        }
        System.out.println(count);
        double[] newArr = new double[count];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 3.5) {
                newArr[idx] = arr[i];
                idx++;
            }
        }

        for (int i = 0; i < newArr.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.printf("A [%3d] = %f  ", i, newArr[i]);
        }
        System.out.println();

        double pow = 0;
        for (int i = 0; i < newArr.length; i++) {
            pow *=newArr[i];
        }
        double avg = (double)(pow(pow,(double)(1/newArr.length)));
        System.out.println("Среднее геометрическое = " + avg);
    }
}

