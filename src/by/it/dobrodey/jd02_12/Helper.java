package by.it.dobrodey.jd02_12;

import java.util.Random;

public class Helper {
    private static final int K_SPEED = 100;
   // public static final double K_PENSIONEER = 1.5;

    private static Random random = new Random();

    static int getRandom (int min,int max){return min + random.nextInt(max-min+1);}
    static int getRandom (int max){return getRandom(0,max);}
   // static double getRandomForPensionee(double min,double max){
     //   return min + random.nextDouble()*(K_PENSIONEER *(max-min));}


    static void timeout(int milisecond) {
        try {

            Thread.sleep(milisecond / K_SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
