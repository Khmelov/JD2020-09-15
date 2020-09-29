package by.it.hutnik.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in); // объявляем сканнер
        String str=scanner.nextLine(); // создаём строку str в которую записываем значения с клавиатуры
        double[] array=InOut.getArray(str); // наполняем массив double в который вносим данные, обработанные в классе InOut.getArray
        InOut.printArray(array); // выводим на печать массив
        InOut.printArray(array, "v", 3);
        System.out.println("Минимальное значение = " + Helper.findMin(array));
        System.out.println("Максимальное значение = " + Helper.findMax(array));
    }
}
