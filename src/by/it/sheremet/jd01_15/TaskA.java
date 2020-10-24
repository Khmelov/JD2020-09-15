package by.it.sheremet.jd01_15;

/*Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
         Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15. При выводе для
        каждого числа нужно предусмотреть для него три знакоместа, после чисел – один пробел.
         Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskA {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";
    public static final String MATRIX_TXT = "matrix.txt";

    private static String getPath(Class<?> bClass) {
        String packageName = bClass
                .getPackage()
                .getName()
                .replace(".", File.separator)
                .concat(File.separator);
        String root = System.getProperty(USER_DIR);
        return root + File.separator + SRC + File.separator + packageName;
    }
    public static void main(String[] args) {



        int[][] matrix = new int[6][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                matrix[i][j]= -15 +(int) (Math.random()*31);
            }
        }
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
        String filenameText = getPath(TaskA.class) + MATRIX_TXT;
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(filenameText);
            for (int[] row : matrix) {
                for (int value : row) {
                    printWriter.printf("%3d ", value);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }


    }
}
