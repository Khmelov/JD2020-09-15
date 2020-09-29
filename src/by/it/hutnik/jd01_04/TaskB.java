package by.it.hutnik.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] surname = new String[n];
        for (int f = 0; f < n; f++) {
            surname[f] = scanner.next();
        }
              int[][] zp = new int[n][4];
                int resYear=0;
                int resTotal = 0;
                double resAverage = 0;
                String resAve = String.format("%.4f",resAverage);
              for (int i = 0; i < zp.length; i++) {
                  System.out.println("Введите зарплату для " + surname[i]);
                  for (int j = 0; j < zp[i].length; j++) {
                      zp[i][j] = scanner.nextInt();
                      //resYear =
                      resTotal = zp[i][j] + resTotal;
                      resAverage = resTotal / (n*4.0);
                  }
            }
            System.out.println("--------------------------------------------------------");
            System.out.printf("%-10s %-8s  %-8s  %-8s  %-8s  %-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
            System.out.println("--------------------------------------------------------");
              for (int t = 0; t < n; t++) {
                resYear = zp[0+t][0]+zp[0+t][1]+zp[0+t][2]+zp[0+t][3];
                System.out.printf("%9s: %-8d  %-8d  %-8d  %-8d  %-5d%n",surname[0+t], zp[0+t][0], zp[0+t][1], zp[0+t][2], zp[0+t][3], resYear);
              }
            System.out.println("--------------------------------------------------------");
            System.out.printf("%-7s    %-5d%n", "Итого", resTotal);
            System.out.printf("%-7s    %.4f", "Средняя", resAverage);

    }

}
