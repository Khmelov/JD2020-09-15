package by.it.hutnik.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> strLIST = new ArrayList<String>(){};
        String[] arr = {"Name1", "Name2", "Name3", "Name4"};
        System.out.println(process(strLIST));

        LinkedList<String> linkedList = new LinkedList<String>(){};
        System.out.println(process(linkedList));

    }

    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1)
        {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count == 2) {
                 iterator.remove();
                 count=1;
              }
                else count++;
         }
     }
        return  peoples.get(0);

    }
    static String process(LinkedList<String> peoples){
        int count = 1;
        while (peoples.size() > 1)
        {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count == 2) {
                    iterator.remove();
                    count=1;
                }
                else count++;
            }
        }
        return  peoples.get(0);
    }
}