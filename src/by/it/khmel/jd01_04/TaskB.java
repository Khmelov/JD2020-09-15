package by.it.khmel.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of people");
        int n = sc.nextInt();
        String[] sirnames = new String[n];
        int[][] salaries = new int[n][4];
        int[] sumsalary = new int[4];
        int summa=0;

        for (int i = 0; i < sirnames.length; i++) {
            System.out.println("Enter sirname");
            sirnames[i] = sc.next();
        }

        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Введите зарплату для " + sirnames[i]);
            for (int j = 0; j < 4; j++) {
                salaries[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < salaries[0].length; j++) {
                sumsalary[i] = sumsalary[i] + salaries[i][j];
                System.out.println(sumsalary [i]);
            }
        }
        // сумма всех выплат
        for (int i=0; i< sumsalary.length; i++){
            summa=summa+sumsalary[i];
        }
        // средняя
        double average=summa/(4.0*n);

//вывод в консоль
        System.out.printf("_____________________________________________________");
        System.out.println();
        System.out.printf("%7s  %8s  %8s  %8s  %8s  %5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3",
                "Квартал4", "Итого");
        System.out.println();

        for (int i = 0; i < salaries.length; i++) {
            System.out.printf("%7s: ", sirnames[i]);
            // (sirnames[i] + ": ");
            for (int j = 0; j < salaries[0].length; j++) {
                System.out.printf("%-10d", salaries[i][j]);

            }
            System.out.printf("%-5d", sumsalary[i]);
                        System.out.println();
        }
        System.out.printf("_____________________________________________________");
        System.out.println();
        System.out.printf("%7s  %-10d", "Итого", summa);
        System.out.println();
        System.out.printf("%7s  %-10.6f","Средняя", average);
    }
}





