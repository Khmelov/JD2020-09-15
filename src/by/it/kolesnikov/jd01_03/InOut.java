package by.it.kolesnikov.jd01_03;
import java.util.Arrays;

/**
 * @author Valeriy Kolesnikov
 * @see  <a href = http://bit.ly/jd2020-09-15 target=_blank>
 *    Задание </a>
 */
class InOut {
    /**
     * Метод преобразования строки в массив
     * @param line - Входная строка (с числами)
     * @return  - Возвращаемый массив действительных чисел
     */
    static double[ ] getArray(String line){
       line=line.trim();
        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i]=Double.parseDouble(strArray[i]);
        }
        return array;
    }

    /**
     * Метод вывода массива на консоль
     * @param arr - Входной массив
     */
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
    static void printArray(double[ ] arr, String name, int coloumnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if ((i+1)%coloumnCount==0 || i+1== arr.length)
                System.out.println();
            
        }
        
    }

}
