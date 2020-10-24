package by.it.zubovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        int position = 0;
        while (!(str = sc.next()).equals("end")){
            Integer value = Integer.valueOf(str);
            if (value > 0){
                arr.add(position++,value);
            }
            else if (value == 0){
                arr.add(position,0);
            }
            else {
                arr.add(value);
            }
            System.out.println(arr);
        }
    }
}
