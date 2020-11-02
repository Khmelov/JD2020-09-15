package by.it.arhipova.jd01_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] lastname = new String[n];
        for (int i = 0; i < n; i++) {
            lastname[i] = sc.next();
        }
        int sumSalary = 0;
        int totalSalary = 0;
        double averSalary = 0;

        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + lastname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();


                totalSalary += salary[i][j];


                averSalary = totalSalary / (n * 4.0);
            }
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s\n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            sumSalary = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%7s:  %-12d%-12d%-12d%-12d%-12d\n", lastname[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], totalSalary);
        }
        System.out.println("---------------------------------------------------------------");


        System.out.printf("%-10s%-12d\n", "Итого", sumSalary);

        System.out.printf("%-10s%-12.6f\n", "Средняя", averSalary);
    }

}
