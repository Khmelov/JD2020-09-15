package by.it.khmel.jd01_05;

import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

        double[] array;
        array = step1();
        System.out.println("Массив из 40-60 элементов");
        step2(array);
        double[] arrayres = step3(array);
        System.out.println("Массив с элементами > 3,5");
        step2(arrayres);
        step4(arrayres);
        System.out.println("Среднее геометрическое");
        System.out.println(step4(arrayres));

    }

    private static double[] step1() {

        int n = (int) (random() * 20 + 40);

        //  System.out.println(n);
        double[] array = new double[n];
        double x, z;
        int i = 0;
        for (x = 5.33; x <= 9; x = x + (9 - 5.33) / n) {
            if (i < n) {
                z = pow((x * x + 4.5), 1 / 3.0);
                //System.out.println(z);
                array[i] = z;
                i = i + 1;
            }
        }
        return array;
    }

    private static void step2(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("x[%d]=%5.3f  ", i, array[i]);
            System.out.println();
        }

    }

    private static double[] step3(double[] array) {
        int m = 0;
        int j = 0;

        // double[] arrayres=new double[8];

        for (int i = 0; i < array.length; i++) {

            if (array[i] > 3.5) {
                m = m + 1;
            }
        }
        double[] resarray = new double[m];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                resarray[j] = array[i];
                j = j + 1;
            }

        }
        return resarray;
    }


    private static double step4(double []array) {
        double avergeom=1;
        for (int i = 0; i < array.length; i++) {
            avergeom=avergeom*array[i];
        }
        avergeom=pow(avergeom,1/(array.length*1.0));
        return avergeom;
    }
}
