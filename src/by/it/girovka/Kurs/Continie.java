package by.it.girovka.Kurs;

import com.sun.javaws.IconUtil;

public class Continie {
    public static void main(String[] args) {
       for (int i =0; i<=15; i++){
           if(i%2 ==0){
               continue;
           }
           System.out.println(i);
        }

    }

}
