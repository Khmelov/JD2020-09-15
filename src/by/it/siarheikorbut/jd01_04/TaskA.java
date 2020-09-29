package by.it.siarheikorbut.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1BZ7AGComLlo0VPQTnmOJxWjrZpv6hLzo/view?usp=sharing">Задание JD01_04 ( A )</a>
 */

public class TaskA {

    //Вывов в консоль таблицы умножения.
    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {

        //Формирование из строки массива вещественных чисел.
        double[] array = InOut.getArray(line);

        //Вывод массива в пять колонок.
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];

        //Сортировка массива по возростанию.
        Helper.sort(array);

        //Вывод массива в четыре колонки
        InOut.printArray(array, "V", 4);

        //Вычисление после сортировки новых индексов первого и последнего элементов и вывод их в консоль.
        int indexFirst = Arrays.binarySearch(array, first);
        System.out.printf("Index of first element=%d\n", indexFirst);
        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }

    public static void main(String[] args) {

        //Вызов метода printMulTable
        printMulTable();

        //Ввод с консоли строки из чисел через пробел.
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        //Вызов метода buildOneDimArray с переменной s в качестве аргумента.
        buildOneDimArray(s);
    }
}