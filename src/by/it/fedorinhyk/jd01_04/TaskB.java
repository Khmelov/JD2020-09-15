package by.it.fedorinhyk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String people[] = new String[3];
        for (int i = 0; i < people.length; i++) {
        }
        Scanner scfam = new Scanner(System.in);
        String fam = scfam.next();
        String family[] = new String[people.length];
        for (int j = 0; j < fam.length(); j++) {
            System.out.println("Ведите зарплату для " + family[j]);
        int zp[][]= new int[n][4];
            Scanner zpfam = new Scanner(System.in);
            int a=zpfam.nextInt();
        }
            System.out.printf("%-9s%-9s%-9s%-9s%-9s%-7s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3","Квартал4","Итого");
            System.out.println("-----------------------------------------------------");
        for (int i = 0; i < people.length; i++) {
            final String bin = String.format("%4s", Integer.toBinaryString(i));
            System.out.printf("%-9s%-4d%-4d%-4d%-4d%-5d%n", people[i], bin);
        }


    }

}
