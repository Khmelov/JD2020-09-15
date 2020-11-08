package by.it.zubovich.jd01_04;

import java.util.Scanner;

public class TaskB_old {
    public static void main(String[] args) {

        System.out.println("Введите количество людей для рачета ЗП");
        Scanner scNumber = new Scanner(System.in);
        Scanner scZp = new Scanner(System.in);
        Scanner scNameEmployee = new Scanner(System.in);
        int ppl = scNumber.nextInt();
        String[] arr = new String[ppl];
        int i = 1;
        while (ppl >= i) {
            System.out.println("Введите Фамилию человека под номером " + i);
            String namePpl = scNameEmployee.nextLine();
            arr[i - 1] = namePpl;
            i++;
        }
        System.out.println("Список претендентов на ЗП");

        int[] arrZp = new int[ppl * 5];
        int r = 0;
        arrZp[0] = r;
        for (String s : arr) {
            System.out.println("Вводите ЗП за каждый из 4х кварталов для " + "\"" + s + "\"" + " и нажимайте Enter");
            int totalLine = 0;
            for (int j = 0; j < 4; j++) {
                int zp = scZp.nextInt();
                arrZp[r] = zp;
                r++;
                totalLine += zp;
            }
            arrZp[r] = totalLine;
            r++;
            System.out.println(totalLine);
        }

        for (String i1 : arr) {
            System.out.print(i1 + ": ");
            for (int i2 : arrZp) {
                System.out.print(" " + i2 + " ");

            }
            System.out.println();



//            for (int i2 = 0; i2 <= arrZp.length-1; i2++) {
//                if (((arrZp[i2]+1) % 5) == 0) {
//                    System.out.print(" " + i2 + " ");
//                }
//            }
            }

        }
    }

