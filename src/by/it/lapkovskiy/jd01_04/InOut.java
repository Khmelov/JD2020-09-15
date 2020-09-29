package by.it.lapkovskiy.jd01_04;

public class InOut {
    public static void main(String[] args) {

    }
   public static double[] getArray(String line){
        line = line.trim();
        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
       for (int i = 0; i < strArray.length; i++) {
           array[i]= Double.parseDouble(strArray[i]);
       }
         return array;
    }
    public static void printArray(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void printArray(double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f ",name,i,arr[i]);
        }
    }
}
