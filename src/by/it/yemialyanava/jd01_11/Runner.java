package by.it.yemialyanava.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

        ListA list2 = new ListA<>();
        list2.add("one");
        list2.add("two");
        list2.add("tree");
        list2.add("four");
        list2.add("five");
        System.out.println(list2);
        list2.remove(1);
        System.out.println(list2);*/

        ListB list3 = new ListB();
        list3.add("one");
        list3.add("two");
        list3.add("tree");
        list3.add("four");
        list3.add("five");
        System.out.println(list3);
        list3.add(2, "Start");
        /*System.out.println(list3);
        list3.addAll(list3);
        list3.remove(1);
        System.out.println(list3);
        System.out.println(list3.get(0));
        System.out.println(list3.set(3, "Pram"));
        HashSet<String> hs= new HashSet<>();
        hs.add("Start");
        hs.add("Ancl");
        hs.add("Ant");
        System.out.println(hs);*/

        SetC<String> hs2= new SetC<>();
        hs2.add("Start");
        hs2.add("Ancl");
        hs2.add("Ant");
        System.out.println(hs2);
        hs2.addAll(list3);
        System.out.println(hs2);




    }
}
