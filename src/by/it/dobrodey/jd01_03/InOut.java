package by.it.dobrodey.jd01_03;


public class InOut {
    /**
     * @param line -входная строка, которую переобразуют в массив

     */

    static double[ ] getArray(String line){
        line = line.trim();                        //убираем пробелы в конце
        String[] strArray = line.split(" ");    // переыодмс стороку в массив строк
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);

        }
        return array;
    }

    /**
     *
     * @param arr -вводится массив для вывода на экран
     */

    static void printArray(double[] arr){
        for (double element :arr){
            System.out.print(element+" ");
                    }
        System.out.println();

    }
    // выводим массив с помощью prinf
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.2f",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i== arr.length-1){
                System.out.println();
            }

        }

    }










    // static void printArray(double[ ] arr)
    //static void printArray(double[ ] arr, String name, int columnCount)
}
