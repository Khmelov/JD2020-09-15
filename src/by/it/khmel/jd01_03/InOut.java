package by.it.khmel.jd01_03;

/**
 * @author Hmel
 * @see <https://drive.google.com/drive/folders/1tGb6m1MWzSBvNC-pabSH3fECPy6b7-7u>
 * задание </a>
 */
public class InOut {
    /**
     * Метод преобразования строки в массив
     * @param line- входная строка (с числами)
     * @return Возвращаемый массив
     */
    static double[] getArray(String line) {

        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     * Метод вывода массива
     * @param arr- входной массив
     */
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     *
     * @param arr
     * @param name
     * @param columnCount
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            //v[i]=12.2156
            System.out.printf("%s[% -3d]=%-10.4f ", name,i, arr[i]);
            if((i+1)%columnCount==0||i+1==arr.length){
                System.out.println();
            }

        }
    }

}



