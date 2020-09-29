package by.it.akhmelev.jd01_02;


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
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
            if (max < element) {
                max = element;
            }
        }
        System.out.println(min+" "+max);
    }

    private static void step2(int[] arr) {
        int sum=0;
        for (int value : arr) {
            sum+=value;
        }
        double avg=sum/arr.length;
        for (int value : arr) {
            if (value<avg){
                System.out.print(value+" ");
            }
        }
        System.out.println();
    }

    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]==min) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }


}
