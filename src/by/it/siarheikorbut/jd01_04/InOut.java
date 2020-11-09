package by.it.siarheikorbut.jd01_04;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1hLOOxXWbCfr8iQZagfAMMBrUG-_0-yr4/view?usp=sharing">Задания JD01_04</a>
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
    static void printArray(double[] arr, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f   ", "V", i, arr[i]);
            if ((i + 1) % columnCount == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
    }
}