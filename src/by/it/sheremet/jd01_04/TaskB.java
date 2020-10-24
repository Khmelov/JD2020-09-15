package by.it.sheremet.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Str=0;
        int sumStr=0;
        double averStr=0;
        int n;
        n=sc.nextInt();
        String[] personArr=new String[n];
        for (int i = 0; i <=personArr.length-1; i++) {
            personArr[i]=sc.next();
        }
        int[][] moneyArr=new int[n][4];
        for (int i = 0; i < personArr.length; i++) {
            System.out.println("Введите зарплату для "+personArr[i]);
            for (int j = 0; j < moneyArr[i].length; j++) {
                moneyArr[i][j] = sc.nextInt();
                sumStr=moneyArr[i][j]+sumStr;
                averStr=(double) sumStr/(double)(personArr.length*4);
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4","Итого");
        System.out.println("-------------------------------------------------------");
        for (int l = 0; l < personArr.length ; l++) {
            Str=moneyArr[0+l][0]+moneyArr[0+l][1]+moneyArr[0+l][2]+moneyArr[0+l][3];
            System.out.printf("%-10s%-10d%-10s%-10s%-10s%-10s%n",personArr[0+l],moneyArr[0+l][0],moneyArr[0+l][1],moneyArr[0+l][2],moneyArr[0+l][3],Str);
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10d%n","Итого",sumStr);
        System.out.printf("%-10s%-10f%n","Средняя",averStr);

    }
}
