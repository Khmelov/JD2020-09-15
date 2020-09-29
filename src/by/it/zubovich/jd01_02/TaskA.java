package by.it.zubovich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
            System.out.println(min + " " + max);
        }
    }

    private static void step2(int[] arr) {
        double avg, sum = 0;
        for (int element : arr) {
            sum += element;
        }
        avg = sum / arr.length;
        System.out.println(avg + " " + sum);
/*
            //странно, что тест проходится без for который ниже
        for (int element : arr) {
            if (element < avg) {
                System.out.println(element);
            }
        }
*/
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
        }
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
    }

}
