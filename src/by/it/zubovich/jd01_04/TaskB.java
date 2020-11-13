package by.it.zubovich.jd01_04;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("введите число людей:");

        Scanner scNumber = new Scanner(System.in);
        int strNumber = scNumber.nextInt();
        String[] lastName = new String[strNumber];

        for (int i = 0; i < lastName.length; i++) {
            System.out.println("введите фамилию:");
            lastName[i] = scNumber.next();
        }
        int[][] salary = new int[strNumber][4];
        AtomicIntegerArray result = new AtomicIntegerArray(new int[strNumber]);

        for (int i = 0; i < strNumber; i++) {
            System.out.println("введите зарплату для " + lastName[i] + ":");
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scNumber.nextInt();
                result.getAndAdd(i, (salary[i][j]));
            }

        }
        //вывод квартальной зарплаты
        String fr = "---------------------------------------------------";
        System.out.printf("%-51s%n%8s %9s%9s%9s%9s%6s%n%-51s", fr, "Фамилия",
                "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого", fr);
        for (int i = 0; i < strNumber; i++) {
            int sumHalfTotal = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%n%8s: %-9d%-9d%-9d%-9d%-6d", lastName[i], salary[i][0],
                    salary[i][1], salary[i][2], salary[i][3], sumHalfTotal);
        }
        //находим итого
        int total = 0;
        for (int[] hints : salary) {
            for (int anInt : hints) {
                total += anInt;
            }
        }
        //вывод в консоль итого и среднее в конце таблицы
        System.out.printf("%n%-51s%n%-10s%-9d", fr, "Итого", total);
        double avgOfTotal = (double) total / (strNumber * 4);
        System.out.printf("%n%-10s%-9.4f%n", "Средняя", avgOfTotal);
    }
}
