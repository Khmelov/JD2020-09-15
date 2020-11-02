package by.it.fedorinhyk.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    void print(CreateVar result) {
        if (result != null) {
            System.out.println(result);
        }
    }

    public void printvar(Map<String, CreateVar> value) {
        Map<String, CreateVar> hashmap;
        hashmap = value;
        Set<Map.Entry<String, CreateVar>> set = hashmap.entrySet();
        Iterator<Map.Entry<String, CreateVar>> iterator = set.iterator();
        while (iterator.hasNext()) { Map.Entry<String, CreateVar> map = iterator.next();
            System.out.println(map.getKey()+"="+map.getValue());
        }
    }
}
