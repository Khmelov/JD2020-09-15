package by.it.frolova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int peopleNum = sc.nextInt();
        String[] names = new String[peopleNum];
        int[][] salaries = new int[peopleNum][4];
        int res[] = new int[peopleNum];
        for (int i = 0; i < names.length; i++) {
            names[i] = sc.next();
        }
        System.out.println(Arrays.toString(names));

        for (int i = 0; i < salaries.length; i++) {
            System.out.println("Введите зарплату для " + names[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                salaries[i][j] = sc.nextInt();
            }

        }

        for (int i = 0; i < salaries.length; i++) {
            for (int j = 0; j < salaries[i].length; j++) {
                res[i] += salaries[i][j];
            }
        }
        System.out.println(Arrays.toString(res));

        //total sum
        int sum = 0;
        for (int i = 0; i < peopleNum; i++) {
            sum += res[i];
        }

        //avg
        int tempSum = 0;
        for (int i = 0; i < salaries.length; i++) {
            for (int j = 0; j < salaries[i].length; j++) {
                tempSum += salaries[i][j];
            }
        }
        double avg = (double)(tempSum) / (double) ((salaries.length * salaries[0].length));

        //table output
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%7s:  ",names[i]);
            for (int j = 0; j < salaries[i].length; j++) {
                System.out.printf("%-10d",salaries[i][j]);

            }
            System.out.printf("%d",res[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10d%n","Итого",sum);
        System.out.printf("%-10s%-10f%n","Средняя",avg);


    }

}





