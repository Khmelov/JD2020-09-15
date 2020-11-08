package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Object, Object> map = new HashMap<>();
        for (; ; ) {
            String s = sc.next();
            if (s.equals("end")) break;
            long key=System.nanoTime();
            map.put(key,s);
        }
        System.out.println(map);

        HashMap<Object, Object> map1 = new HashMap<>(expandHashMap(map));

        HashMap<Object, Object> map2 = new HashMap<>(expandHashMap(map1));
        System.out.println(map2);

    }

    private static HashMap<Object, Object>  expandHashMap(HashMap<Object, Object> map) {
        Set keys = map.keySet();
        System.out.println(keys);
        Iterator it = keys.iterator();
        HashMap<Object, Object> map1 = new HashMap<>();
        while (it.hasNext()){
            Object key= it.next();
            Object value=  map.get(key);
            if (map1.containsKey(value)) {
            }
            else {map1.put(value,key);}
        }
        return map1;
    }
}