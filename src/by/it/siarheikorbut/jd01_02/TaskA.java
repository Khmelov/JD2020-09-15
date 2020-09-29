package by.it.siarheikorbut.jd01_02;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BOB3Xi2qWYN9DxaTMQBwnlKQAJzOx1IK/view?usp=sharing">Задание JD01_02 ( А )</a>
 */

public class TaskA {
    public static void main(String[] args) {

        //Ввод десяти чисел с консоли в массив arr.
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        //Вызов методов.
        step1(arr);
        step2(arr);
        step3(arr);
    }

    //Поиск самого маленького и самого большого числа массива
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
        System.out.println(min + " " + max);
    }

    //Вывов в консоль чисел значение которых строго меньше среднего арифметического.
    private static void step2(int[] arr) {
        double sum = 0;
        for (int value : arr) {
            sum += value;
        }
        double avg = sum / arr.length;
        for (int value : arr) {
            if (value < avg) {
                System.out.println(value + " ");
            }
        }
        System.out.println();
    }

    //Поиск и вывод индекса самого маленького числа
    private static void step3(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
