package by.it.frolova.jd01_02;

import java.util.Scanner;

public class TaskA_test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        step1(arr);
        step2(arr);
        step3(arr);

    }

    private static void step1(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : arr) {
            if(min > element){
                min = element;
            }
            if(max < element){
                max = element;
            }
        }
        System.out.println("min = " + min + ", max = " + max);
    }

    private static void step2(int[] arr) {
        double sum = 0;
        for (int value : arr) {
            sum += value;
        }
        double avg = sum / arr.length;

        for (int i : arr) {
            
        }
    }
    

    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        
        for (int element : arr) {
            if(min > element){
                min = element;
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if(arr[i] == min){
                    System.out.println(i + "");
                }
            }
            }
    }
}
