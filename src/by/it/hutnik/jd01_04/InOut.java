package by.it.hutnik.jd01_04;

/**
 * @author M.Hutnik
 *@see  <a href=http://bit.ly/jd2020-09-15 target=_blank>
 *     Задание </a>
 *
 */

public class InOut {
    /**
     * Метод преобразования строки в масиив
     * @param line входная строка (с числами)
     * @return возвращаемый массив действительных чисел
     */
    static double[ ] getArray(String line){
        String[] strArr = line.split(" ");
        double [] res= new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        return res;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f",name,i,arr[i]);
            if ((i+1)%columnCount == 0 || i+1 == arr.length)
                System.out.println("");
        }
    }
//        static double findMin(double[ ] arr){
//            if (0 == arr.length){
//                return Integer.MIN_VALUE;
//            } else {
//                double min = arr[0];
//                for (double v : arr) {
//                    if (min>v) min=v;
//                    System.out.println(v);
//                }
//                return min;
//            }
//        }

}
