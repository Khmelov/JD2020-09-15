package by.it.lapkovskiy.jd01_02;

import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(step2(step3(step1(n))));

    }

    public static int[][] step1(int n) {
        int[][] arr = new int[n][n];
        final Random random = new Random();
        boolean min = false;
        boolean max = false;
        do {
            min = false;
            max = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] =n - random.nextInt(2*n+1);
                }
            }
            for (int[] row : arr)
                for (int i : row) {
                    if (i == -n) {
                        min = true;
                    }
                    if (i == n){
                        max = true;
                    }
                }
        } while (!(min && max));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return arr;
    }
    public static int step2(int[][] arr){
        int sum = 0;
        int sumLine = 0;
        boolean begin = false;
        boolean end = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(begin && arr[i][j]>0){
                  end = true;
                  break;
                }
                if(begin) {
                    sum+=arr[i][j];
                }
                if(arr[i][j]>0 && begin == false){
                    begin = true;
                }
            }
            if(end){
                sum+=sumLine;
            }
            begin = false;
            end = false;
            sumLine = 0;
        }
        return sum;
    }
    public static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[][] arrMark = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(max<arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(max==arr[i][j]){
                    for (int y = 0; y < arr.length; y++) {
                        for (int u = 0; u < arr[y].length; u++) {
                            if(i==y || j==u) arrMark[y][u]+=1;
                        }
                    }
                }
            }
        }

        int height=0;
        int width=0;

      /*  System.out.println("--------------------");
        for (int i = 0; i < arrMark.length; i++) {
            for (int j = 0; j < arrMark[i].length; j++) {
                System.out.print(arrMark[i][j]+" ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < arrMark.length; i++) {
            boolean ss = false;
            for (int j = 0; j < arrMark[i].length; j++) {
                if(arrMark[i][j] ==0)
                {
                    ss =true;
                }
            }
            if(ss) height++;
        }
        for (int i = 0; i < arrMark.length; i++) {
            boolean ss = false;
            for (int j = 0; j < arrMark.length; j++) {
                if(arrMark[j][i] ==0)
                {
                    ss =true;
                }
            }
            if(ss) width++;
        }
       // System.out.println("h="+height+" w="+width);

        int[][] resultArr = new int[height][width];
        int mi = 0;
        int mj = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arrMark[i][j]==0) {
                    resultArr[mi][mj] = arr[i][j];
                    mj++;
                }
            }
            if(mj>0) mi++;
            mj=0;
        }
        for (int i = 0; i < resultArr.length; i++) {
            for (int j = 0; j < resultArr[i].length; j++) {
                System.out.print(resultArr[i][j]+" ");
            }
            System.out.println();
        }
        return resultArr;
    }
}
