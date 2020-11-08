package by.it.siarheikorbut.jd01_03;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1L5Z3U4Iv8EyTak0vgQ3IvNlZMXvPONAH/view?usp=sharing">Задания JD01_03</a>
 */

public class InOut {

    //Ввод одномерного массива.
    static double[] getArray(String line) {
        line = line.trim();
        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
        }
        return array;
    }

    //Простой вывод одномерного массива.
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    //Форматный вывод одномерного массива.
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f   ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
    }
}