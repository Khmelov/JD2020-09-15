package by.it.yemialyanava.jd01_01.jd01_01;

import java.util.Scanner;

class TaskC3 {
    static double Earth = 9.81;
    static double Mars = 3.86;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите вес человека в килограммах");
        int weight = sc.nextInt();
        double x = getWeight(weight);
        System.out.println(x);
    }

    public static double getWeight(int weight) {
        double weightMars = ((weight / Earth) * Mars);
        double newWeightMars = Math.round(weightMars * 100.0) / 100.0;
        return newWeightMars;
    }
}



