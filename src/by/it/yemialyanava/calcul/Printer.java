package by.it.yemialyanava.calcul;

import java.util.*;

public class Printer {
    void print(Var result){
        if (result!=null){
            System.out.println(result);
        }
    }
    static void printVar(HashMap<String, Var> varMap){
        Set<Map.Entry<String, Var>> entries = varMap.entrySet();
        for (Map.Entry<String, Var> entry : entries){
            System.out.println(entry.getKey().toString() + "=" + entry.getValue().toString());
        }
    }
    static  void sortVar(HashMap<String, Var> varMap){
        Map<String, Var> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        treeMap.putAll(varMap);
        Set<Map.Entry<String, Var>> entries = treeMap.entrySet();
        for (Map.Entry<String, Var> entry : entries){
            System.out.println(entry.getKey().toString() + "=" + entry.getValue().toString());
        }
    }
}
