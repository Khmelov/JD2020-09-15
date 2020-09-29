package by.it.dobrodey.jd01_02;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input matrix size (int n):");
        int n = sc.nextInt();
        int[][] arr = step1(n);
        int sum = step2(arr);
        int[][] arrNew = step3(arr);

    }

    private static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        boolean max;
        boolean min;
        do {
            max = false;
            min = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (2 * n + 1)) + (-n);
                    if (arr[i][j] == n) {
                        max = true;
                    }
                    if (arr[i][j] == -n) {
                        min = true;
                    }
                }
            }
        } while (!(max || min));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int ch = 0;
            for (int j = 0; j < arr[i].length - 1; j++) {
                if (arr[i][j] > 0)
                    ch = ch + 1;
                if (arr[i][j + 1] < 0 && ch == 1)
                    sum = sum + arr[i][j + 1];
            }
        }
        System.out.println("Summa = " + sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        int max = -arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println("max =" + max);              /////удалить
        int[] stroka = new int[arr.length];
        int[] column = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    stroka[i] = arr.length + 2;         //значение которого не может быть в массиве
                    column[j] = arr[0].length + 2;         //
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {         /////удалить
            System.out.print(" " + stroka[i]);

        }
        System.out.println();                           //   /////удалить
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + column[i]);

        }
        System.out.println();
        // Найдем параметры новой матрицы
        int quantityStrok = 0;
        int quantityColum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stroka[i] != (arr.length + 2))
                quantityStrok += 1;
            if (column[i] != (arr.length + 2))
                quantityColum += 1;
        }
        System.out.println("quantityStrok = " + quantityStrok);         ///del
        System.out.println("quantityColum = " + quantityColum);

        int[][] arrNew = new int[quantityStrok][quantityColum];
        for (int i = 0; i < quantityStrok; i++) {
            for (int j = 0; j < quantityColum; j++) {
                System.out.print(arrNew[i][j]);
            }
            System.out.println();
        }
        // a и b счетчик нового массива
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (stroka[i] != (arr.length + 2)) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (column[j] != (arr.length + 2)) {

                        arrNew[a][b] = arr[i][j];
                        System.out.print(arrNew[a][b] + " ");
                        b++;
                    }
                }
                System.out.println();
                a++;
                b = 0;
            }


        }

        return arrNew;
    }

}


