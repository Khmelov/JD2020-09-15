package by.it.girovka.jd5;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1() {

        for (double a = 0; a <= 2; a = a+0.2) {
            double y = pow(7, a) * 6;
            for (double x = 1; x <= 6; x++)
                y = y - cos(x);

            System.out.println(y);
        }
    }
    private static void step2() {

            for(double x = -5.5; x<2; x=x+0.5){
                double b;
                if ( -2 < x/2 && x/2 <= -1){
                b = sin(pow(x,2));
                    double a = log10(abs(b+2.74));
                    System.out.println(a+""+x);}

                else if ( -1 < x/2 && x/2 <0.2){
                b = cos(pow(x,2));
                    double a = log10(abs(b+2.74));
                    System.out.println(a+""+x);}

                 else if ( x/2 == 0.2) {
                b = 1/(tan(pow(x,2)));
                    double a = log10(abs(b+2.74));
                    System.out.println(a+""+x);
                }
                }
            }
    }

