package by.it.girovka.jd3;

public class Helper {
    public static void main(String[] args) {

    }
    static double findMin(double[ ] arr) {
        double min = arr[0];

        for (double element : arr){
            if (min > element) {
                min = element;
            }
        }
        System.out.println();
        return min;
    }
      static double findMax(double[ ] arr) {
          double max = arr[0];
          for (double element : arr) {

              if (max < element) {
                  max = element;
              }
              System.out.println();
          }
          return max;
      }
    static void sort(double[ ] arr){
        for (int i = arr.length-1; i >0; i--){
            for(int j = 0; j<i; j++){
            if ( arr[j]>arr[j+1]){
                double tmp = arr [j];
                arr[j] = arr [j+1];
                arr[j+1] = tmp;

            }
            }
        }
    }
}





