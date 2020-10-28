package by.it.siarheikorbut.jd01_02;

import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BOB3Xi2qWYN9DxaTMQBwnlKQAJzOx1IK/view?usp=sharing">Задание JD01_02 ( C )</a>
 */

public class TaskC {

    public static void main(String[] args) {
        System.out.println("Введите размер массива");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr;
        arr = step1(n);
        step2(arr);
        step3(arr);
    }

    public static int[][] step1(int n) {
        System.out.println("step1");
        int[][] array = new int[n][n];

        //int detector - проверка на наличие максимального и минимального
        for (int detector = 0; detector == 0; ) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                }
            }
            boolean detector1 = false;//проверка наличия максимума в массиве
            boolean detector2 = false;//проверка наличия минимума в массиве
            for (int[] ints : array) {
                for (int anInt : ints) {
                    if (anInt == n) detector1 = true;
                    if (anInt == -n) detector2 = true;
                }
            }
            if (detector1 & detector2) detector = 1;
        }
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        return array;
    }

    public static int step2(int[][] arr) {
        System.out.println("step2");
        int sum = 0;
        int sumAll = 0;

        //подсчет суммы элементов между 1 и 2 положительным элементами в строке
        for (int[] ints : arr) {
            int det = 0;
            int det2 = 0;
            for (int anInt : ints) {
                if (det == 1 & anInt <= 0 & det2 == 0) {
                    sum = sum + anInt;
                } else if (det == 0 & anInt > 0) {
                    det = 1;
                } else if (det == 1 & anInt > 0) {
                    det = 0;
                    det2 = 1;
                }
                if (det2 == 1) sumAll = sumAll + sum;
            }
        }
        System.out.println("sum=" + sum);
        return sum;
    }

    public static int[][] step3(int[][] arr) {
        System.out.println("step3");
        int max = maxArray(arr);

        //подсчет количества максимумов в массиве
        int numberMax = 0;
        for (int[] value : arr) {
            for (int i : value) {
                if (max == i) numberMax = numberMax + 1;
            }
        }
        System.out.println("max=" + max);
        System.out.println("numberMax(количество максимумов)=" + numberMax);

        //Массив содержащий координаты максимальных элементов внутри исходного массива
        int[][] coordinate = new int[numberMax][2];
        System.out.println("coordinates:");

        //Заполнение массива с координатами максимума
        fillingArrayCoordinate(arr, coordinate, max);

        System.out.println("coordinates:");
        for (int[] ints : coordinate) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        //Перепишем все строки и столбцы в которых есть max элементами равными max
        for (int[] ints : coordinate) {
            for (int b = 0; b < 1; b++) {
                for (int c = 0; c < arr.length; c++) {
                    arr[ints[b]][c] = max;
                }
            }
        }

        for (int[] ints : coordinate) {
            for (int b = 1; b < 2; b++) {
                for (int c = 0; c < arr.length; c++) {
                    arr[c][ints[b]] = max;
                }
            }
        }
        System.out.println("arr измененная:");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        int detector = 0; //счетчик внутренний
        int numberColumns = 0; //счетчик наружный
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != max) detector = detector + 1;
            }

            if (numberColumns < detector) numberColumns = detector;
            detector = 0;
        }

        detector = 0; //счетчик внутренний
        int numberStrings = 0; //счетчик наружный
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != max) detector = detector + 1;
            }
            if (detector != 0) numberStrings = numberStrings + 1;
            detector = 0;
        }

        int[][] out = new int[numberStrings][numberColumns];
        detector = 0;
        int detector2 = 0;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt != max) {
                    out[detector][detector2] = anInt;
                    detector2 = detector2 + 1;
                    if (detector2 == numberColumns) {
                        detector2 = 0;
                        detector = detector + 1;
                    }
                }
            }
        }
        return out;
    }

    private static void fillingArrayCoordinate(int[][] arr, int[][] coordinate, int max) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int c2 = 0; c2 < arr[i].length; c2++) {
                if (arr[i][c2] == max) {
                    coordinate[x][0] = i;
                    coordinate[x][1] = c2;
                    x = x + 1;
                }
            }
        }
    }

    private static int maxArray(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (max < anInt) max = anInt;
            }
        }
        return max;
    }
}