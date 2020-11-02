package by.it.hutnik.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

    }
}


