package by.it.fedorinhyk.jd02_04;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    void print(Var result) {
        if (result != null) {
            System.out.println(result);
        }
    }

    public void printvar(Map<String, Var> value) {
        Map<String, Var> hashmap;
        hashmap = value;
        Set<Map.Entry<String, Var>> set = hashmap.entrySet();
        Iterator<Map.Entry<String, Var>> iterator = set.iterator();
        while (iterator.hasNext()) { Map.Entry<String, Var> map = iterator.next();
            System.out.println(map.getKey()+"="+map.getValue());
        }
    }
}
