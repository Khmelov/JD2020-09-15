package by.it.lapkovskiy.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        count = sc.nextInt(); //Integer.decode(sc.nextLine());
        String[] arraySurname = new String[count];// new String[count];
        for (int i = 0; i < count; i++) {
            arraySurname[i] = sc.next();
        }
        int[][] arrayDoh = new int[count][4];
        for (int i = 0; i < count; i++) {
            System.out.println("Введите зарплату для " + arraySurname[i]);
            for (int j = 0; j < 4; j++) {
                arrayDoh[i][j] = sc.nextInt();
            }
        }
        String li = "-----------------------------------------------------------------";
        System.out.println(li);
        System.out.printf("%-12s%-12s%-12s%-12s%-12s%-12s%n","Фамилия",  "Квартал1",  "Квартал2",  "Квартал3"  ,"Квартал4",  "Итого");
        System.out.println(li);
        double allSum = 0;
        for (int i = 0; i <count; i++) {
            System.out.printf("%-12s",arraySurname[i]+":");
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-12d",arrayDoh[i][j]);
                sum+=arrayDoh[i][j];
            }
            allSum+=sum;
            System.out.printf("%-12d%n",sum);
        }
        System.out.println(li);
        System.out.printf("%-12s%-12.0f%n","Итого",allSum);
        System.out.printf("%-12s%-12.4f","Средняя",allSum/(arraySurname.length*4));
    }
}
