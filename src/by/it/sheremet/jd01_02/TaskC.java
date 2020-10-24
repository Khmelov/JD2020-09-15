package by.it.sheremet.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        step1(n);
       // System.out.println(step1(n));
    }
        private static void step1(int n){
            for (int i = 0; i <= n; i++) {
                n = (int) (Math.random()*n-n);
                System.out.print(n+" ");

            }
            

            //return n ;
        }



}
