package by.it.frolova.jd01_04;

/**
 * @author Julia Frolova
 * @see "https://drive.google.com/file/d/1L5Z3U4Iv8EyTak0vgQ3IvNlZMXvPONAH/view?usp=sharing"
 *
 */
public class InOut {

    /**
     * Сonversion from string to array method
     * @param line input line
     * @return return array of doubles
     */
    static double[] getArray(String line) {
        line = line.trim();
        String strArr[] = line.split(" ");
        double doubleArr[] = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            doubleArr[i] = Double.parseDouble(strArr[i]);
        }
        return doubleArr;
    }

    static double[][] getMatrix(String line) {
        line = line.trim();
        String strArr[] = line.split(" ");
        double matrix[][] = new double[strArr.length][strArr.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]= Double.parseDouble(strArr[j]);
            }
        }
        return matrix;
    }

    /**
     *
     * @param doubleArr - input array
     */

    static void printArray(double[] doubleArr) {
        for (double v : doubleArr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    static void printArray(double[] doubleArr, String name, int columnCount) {
        for (int i = 0; i < doubleArr.length; i++) {

            System.out.printf("%s[% -3d]=%-7.4f", name, i, doubleArr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == doubleArr.length) {
                System.out.println();
            }
        }
    }
}
