package by.it.siarheikorbut.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int zeroPos=0;
        for(;;){
            String s= sc.next();
            if (s.equals("end")) break;
            int num= Integer.parseInt(s);
            if (num<0){
                list.add(num);
            }
            if(num==0){
                list.add(zeroPos,num);
            }
            if(num>0){
                list.add(zeroPos++, num);
            }
        }
        System.out.println(list);
    }
}