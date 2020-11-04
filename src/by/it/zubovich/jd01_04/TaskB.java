package by.it.zubovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("введите число людей:");
        Scanner scNumber = new Scanner(System.in);
        int strNumber = scNumber.nextInt();
        int[][] salary = new int[strNumber][4];
        String[] lastName = new String[strNumber];

        for (int i = 0; i < strNumber; i++) {
            System.out.println("введите фамилию:");
            Scanner scPeople = new Scanner(System.in);
            lastName[i] = scPeople.nextLine();
        }

        for (int i = 0; i < strNumber; i++) {
            System.out.println("введите зарплату для " + lastName[i] + ":");
            Scanner sc = new Scanner(System.in);
            String[] arrForSalary = sc.nextLine().split(" ");
            int[] arrSalaryPeople = new int[arrForSalary.length];
            for (int j = 0; j < arrForSalary.length; j++) {
                arrSalaryPeople[j] = Integer.parseInt(arrForSalary[j]);
            }
            salary[i] = arrSalaryPeople;
        }
        //вывод квартальной зарплаты
        String fr = "---------------------------------------------------";
        System.out.printf("%-51s%n%9s%9s%9s%9s%9s%6s%n%-51s", fr, "Фамилия",
                "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого", fr);
        for (int i = 0; i < strNumber; i++) {
            int sumTotal = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%n%8s: %-9d%-9d%-9d%-9d%-6d", lastName[i], salary[i][0],
                    salary[i][1], salary[i][2], salary[i][3], sumTotal);
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
