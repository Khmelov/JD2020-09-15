package by.it.dobrodey.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {

        for (double a = 0; a <=2 ; a= a+0.2) {
            double y = 0;
            for (int x = 1; x <=6 ; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("For a = %3.1f our y = %f\n",a,y);
        }

    }

    private static void step2() {
        for (double x = -5.5; x <2 ; x=x+0.5) {
            double a = 0; double b = 0;
            if (-2<x/2.0 && ((x/2.0)<=-1)){b = sin(pow(x,2));}
            else if((-1 <(x/2.0)) && ((x/2.0)<0.2)) {b = cos(x*x);}
            else if (x/2.0==0.2){b = 1/tan(x*x);}
            a = log10(abs(b+2.74));
            System.out.printf("For x = %f b = %f and a = %f\n",x,b,a);
        }
    }
}
