package by.it.dobrodey.jd01_12;
/*
 TaskB2. Считалка. В кругу стоят N человек.
  При ведении счета по кругу итератором вычеркивается каждый второй человек, пока не останется один.
  Нужно составить два метода, моделирующие процесс и возвращающие имя оставшегося человека:
 static String process(ArrayList<String> peoples) static String process(LinkedList<String> peoples)
  Покажите работу методов в main

 */

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> peopleList1 = new ArrayList<>();
        LinkedList<String> peopleList2 = new LinkedList<>();
        String[] arr = {"Ann", "Olga", "Kate", "Sasha", "Maks", "Dasha", "Pavel"};
        for (String s : arr) {
            peopleList1.add(s);
            peopleList2.add(s);
        }
        System.out.println(peopleList1);
        System.out.println(peopleList2);
        String name1 = process(peopleList1);
        System.out.println("name1 = " + name1);
        String name2 = process(peopleList2);
        System.out.println("name2 = " + name2);
    }

    static String process(ArrayList<String> peoples) {
        int n = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() != 1) {
            while (it.hasNext()) {
                it.next();
                if (n == 1) {
                    it.remove();
                    n = 0;
                    continue;
                }
                n = 1;
            }
            it = peoples.iterator();
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        return result;
    }


    static String process(LinkedList<String> peoples) {
        int n = 1;
        while (!(peoples.size() == 1)) {
            int length = peoples.size();
            for (int i = n; i < peoples.size(); i++) {
                peoples.remove(i);
            }
            if (!(length % 2 == 0)) {
                if (n == 1) n = 0;
                else n = 1;
            }
        }
        String result = peoples.toString();
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("]", "");
        return result;
    }
}
