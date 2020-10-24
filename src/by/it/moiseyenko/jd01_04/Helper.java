package by.it.moiseyenko.jd01_04;

import java.util.Arrays;

public class Helper {
    static double findMin(double[ ] arr){
                double min=arr[0];
                for(double m:arr){
                    if(min>m) min=m;
                }
                return min;
        }
    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double n:arr){
            if(max<n) max=n;
        }
       return max;
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] res=new double[matrix.length];
        for (int i = 0; i < res.length; i++)
            for(int j = 0; j<vector.length;j++)
                res[i]=res[i]+matrix[i][j]*vector[j];
            return res;
    }
    static void sort(double[]arr){
        double arrSort = arr[0];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<arrSort){
                arrSort=arr[i];
            }
        }
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] res = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    res[i][j]=res[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                return res;
    }

}


