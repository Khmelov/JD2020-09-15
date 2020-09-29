package by.it.yemialyanava.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lName = readLastNames(sc);
        int [][] salary = readSalary(sc, lName);
        printTable(lName,salary);
    }

    private static String[] readLastNames (Scanner sc) {
        System.out.println("Введите количество людей");
        int n = sc.nextInt();
        sc.nextLine();
        String[] lName = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите фамилию");
            String lastName = sc.nextLine();
            lName[i] = lastName;
        }
        return lName;

    }
    private static int [][] readSalary (Scanner sc, String [] lName) {
        int[][] salary = new int[lName.length][4];
        for (int j = 0; j < lName.length; j++) {
            System.out.println("Введите зарплату для " + lName[j]);
            String salaryForQ = sc.nextLine();
            salary[j] = parseSalaryString(salaryForQ);
        }
        return salary;
    }

    private static int[] parseSalaryString(String line) {
        String[] strSalary = line.split(" ");
        int[] salaryArray = new int[strSalary.length];
        for (int i = 0; i < strSalary.length; i++) {
            salaryArray[i] = Integer.parseInt(strSalary[i]);
        }
        return salaryArray;
    }

    private static void printTable (String [] lName, int [][] salary){
        System.out.println();
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        int summForYearForAllPerson = 0;
        for (int lNameIndex = 0; lNameIndex < lName.length; lNameIndex++) {
            int sumForYear = 0;
            for (int quarter = 0; quarter < 4; quarter++) {
                sumForYear = sumForYear+salary[lNameIndex][quarter];
                summForYearForAllPerson = summForYearForAllPerson + salary[lNameIndex][quarter];
            }
            System.out.printf("%-10s:%-10d%-10d%-10d%-10d%-10d",
                    lName[lNameIndex], salary[lNameIndex][0], salary[lNameIndex][1], salary[lNameIndex][2], salary[lNameIndex][3],sumForYear);

            System.out.println();
        }
       System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10d", "Итого", summForYearForAllPerson);
        System.out.println();
        double avr4Quarter4Person = (double) summForYearForAllPerson/lName.length/4.0;
        System.out.printf("%-10s%-10.4f", "Средняя", avr4Quarter4Person);
    }
}



