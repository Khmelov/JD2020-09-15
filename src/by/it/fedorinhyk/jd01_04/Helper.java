package by.it.fedorinhyk.jd01_04;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double v : arr) {
                if (min > v) min = v;

            }
            return min;


        }
    }


    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double v : arr) {
                if (max < v) max = v;

            }
            return max;
        }
    }


    static void sort(double[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int l=i;
            for (int j = i+1; j < arr.length ; j++) {
                if
                ((true && arr[j] < arr[l]) ||
                        (false && arr[j] > arr[l]))
                {
                    l=j;
                }
            }
            double buf= arr[i];
            arr[i]=arr[l];
            arr[l]=buf;
        }

    }


    static double[] mul(double[][] matrix, double[] vector) {
        double[] buff = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < vector.length; j++) {
                buff[i]=buff[i]+matrix[i][j]*vector[j];

            }
        }


        return buff;
    }


    static double[][] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] buff= new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    buff[i][j]=buff[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }

            }
            
        }
        return buff;

    }
}

