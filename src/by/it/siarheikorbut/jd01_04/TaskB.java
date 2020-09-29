package by.it.siarheikorbut.jd01_04;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BZ7AGComLlo0VPQTnmOJxWjrZpv6hLzo/view?usp=sharing">Задание JD01_04 ( B )</a>
 */

public class TaskB {
    public static void main(String[] args) {

        //Ввод с консоли колличества работников.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //Ввод одномерного массива фамилий работников
        String[] surname = new String[n];
        for (int i = 0; i < n; i++) {
            surname[i] = sc.next();
        }
        //Обьявление и инициализация переменных.
        int sumSalary = 0;
        int totalSalary = 0;
        double averSalary = 0;

        //Ввод двумерного массива для зарплат работников за четыре квартала.
        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();

                //Подсчет общей суммы всех выплат
                totalSalary += salary[i][j];

                //Подсчет среднеарифметической квартальной зарплаты с точностью до четвертого знака.
                averSalary = totalSalary / (n * 4.0);
            }
        }

        //Построение таблицы доходов работников с фамилиями по кварталам и итогом за год.
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s%-12s%-12s%-12s%-12s%-12s\n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            sumSalary = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%7s:  %-12d%-12d%-12d%-12d%-12d\n", surname[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], totalSalary);
        }
        System.out.println("---------------------------------------------------------------");

        //Вывод общей суммы всех выплат.
        System.out.printf("%-10s%-12d\n", "Итого", sumSalary);

        //Вывод среднеарифметической квартальной зарплаты.
        System.out.printf("%-10s%-12.6f\n", "Средняя", averSalary);
    }
}