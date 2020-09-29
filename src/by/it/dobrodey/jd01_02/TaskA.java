package by.it.dobrodey.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input ten numbers:");
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();

        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (min > element) min = element;
            if (max < element) max = element;

        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double sum = 0;
        for (int element : arr) {
            sum += element;

        }
        double average = sum / arr.length;
        for (int element : arr) {
            if (element < average) {
                System.out.print(element + " ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (min > element) min = element;
        }
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == min) {
                System.out.print(i+" ");
                            }
            
        }
        System.out.println();

        
    }

}

