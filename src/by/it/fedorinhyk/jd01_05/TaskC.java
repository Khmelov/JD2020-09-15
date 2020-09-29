package by.it.fedorinhyk.jd01_05;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        step6();
    }

    private static void step6() {
        for (double x=5.33; x<=9; x=x+0.1) {
            double z = cbrt(pow(x, 2) + 4.5);
            int[] mas = new int[30];
            System.out.printf("x=%3.2f z=%3.2f", x, z);
            System.out.println();
            return;
        }

    }
}
