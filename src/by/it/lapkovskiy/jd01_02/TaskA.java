package by.it.lapkovskiy.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    public static void step1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min + " " + max);
    }

    public static void step2(int[] arr) {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += arr[i];
        }
        double mid = sum / 10;
        for (int i = 0; i < 10; i++) {
            if (mid > arr[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (min == arr[i]) {
                System.out.print(i + " ");
            }
        }

        System.out.println(min);
    }
}
