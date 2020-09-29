package by.it.kolesnikov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] name = new String[count];               //Ввод массива с фамилиями
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();
        }
        int[][] salary = new int[count][4];              //Ввод массива с зарплатами
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        double quantity = salary.length*4;               //Количество всех зарплат
        int sum = 0;                                     //Сумма всех зарплат
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
                sum += salary[i][j];
            }
        }
        int [] total = new int [count];                //Массив столбца "Итого"
        for (int i=0; i< salary.length; i++){
            for (int j=0; j< salary[i].length; j++) {
                total[i]=total[i]+salary[i][j];
            }
            System.out.println(total[i]);
        }
        double avg=sum/quantity;                       //Среднее арифметическое по всем зарплатам
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-12s%-12s%-12s%-12s%-12s%-6s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
            System.out.println();
            System.out.println("-----------------------------------------------------------------");
            int[][] salaryOut = new int[count][4];      //Массив на вывод зарплат в таблице
            for (int i = 0; i < salaryOut.length; i++) {
                System.out.printf("%7s" + ":" + "    ", name[i]);
                for (int j = 0; j < salaryOut[i].length; j++) {
                    System.out.printf("%-12s", salary[i][j]);
                }
                System.out.printf("%-10s" , total[i]);
                System.out.println();
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.printf("%-12s%-5s", "Итого", sum);
            System.out.println();
            System.out.printf("%-12s%-5s", "Средняя", avg);

        }
    }
