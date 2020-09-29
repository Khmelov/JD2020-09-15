package by.it.siarheikorbut.jd01_02;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BOB3Xi2qWYN9DxaTMQBwnlKQAJzOx1IK/view?usp=sharing">Задание JD01_02 ( B )</a>
 */

public class TaskB {
    public static void main(String[] args) {

        //Ввод с консоли чисел от 1 до 12.
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        //Вызов методов.
        step1();
        step2(month);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    //Вывод чисел от 1 до 25 в виде матрицы N x N слева направо и сверху вниз.
    static void step1() {
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }

    }

    //Вывод в консоль названий месяцев.
    static void step2(int month) {
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }
    }

    //Расчёт и вывод корней квадратного уравнения.
    static void step3(double a, double b, double c) {
        double dis = b * b - 4 * a * c;
        if (dis < 0) {
            System.out.println("корней нет");
        } else if (dis == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            double x1 = (-b + Math.sqrt(dis)) / (a * 2);
            double x2 = (-b - Math.sqrt(dis)) / (a * 2);
            System.out.println(x1 + " " + x2);
        }
    }
}