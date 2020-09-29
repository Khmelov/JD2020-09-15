package by.it.yemialyanava.jd01_05;
import java.util.Arrays;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int numberArray = 20 + (int)(Math.random() + 20);
        double [] array = new double[numberArray];
        double x = 5.33;
        double st = (9 - 5.33)/(numberArray+1);
        for (int i = 0; i < array.length ; i++) {
                double z = cbrt((x * x) + 4.5);
                    array[i] = z;
                    x = x+st;
        }
        printArray(array, "V", 5);
        double [] arraySecond = recieveNewArray (array);
        double avrGeomValue = avrGeomValue (arraySecond);
        System.out.printf("Среднее геометрическое значение равно %10.5f ", avrGeomValue);
    }
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.5f", name,i, arr[i]);
            if ((i + 1)%columnCount ==0 || i +1 ==arr.length){
                System.out.println();
            }
        }
    }
    static double[] recieveNewArray (double [] array){
        double[] newArray = new double[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5){
                newArray[j] = array[i];
                j++;
            }
        }
        newArray = Arrays.copyOfRange(newArray, 0, j);
        printArray(newArray, "S", 5);
        return newArray;
    }
    static double avrGeomValue (double [] array) {
        int i =0;
        double proizvedenieValueArray = 1;
        for (i=0; i < array.length; i++){
            proizvedenieValueArray = proizvedenieValueArray * array[i];
        }
        double avrGeomValue = (double) pow(proizvedenieValueArray, (1.0/array.length));
        return avrGeomValue;
    }
}
