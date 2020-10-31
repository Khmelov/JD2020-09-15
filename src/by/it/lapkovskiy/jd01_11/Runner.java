package by.it.lapkovskiy.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.fail;

public class Runner {
    public static void main(String[] args) {
        Set<Integer> hashSet =  new HashSet<>();
        SetC<Integer> s = new SetC<>();

        for (int i = 0; i < 10; i++) {
            hashSet.add((i * 2));
            s.add((i * 2));
        }

        List<Integer> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add(1000);
        added.add(1000);
        added.add(1001);
        added.add(1002);

        hashSet.remove(0);
        hashSet.remove(8);
        hashSet.remove(4);

        s.remove(0);
        s.remove(8);
        s.remove(4);
        hashSet.addAll(added);
        s.addAll(added);

        hashSet.removeAll(added);
        s.removeAll(added);

        System.out.println(hashSet.size()!=s.size());
        System.out.println("s="+s.size());
        System.out.println("h="+hashSet.size());
        System.out.println(hashSet);
        System.out.println(s);

        for (Integer i : hashSet) {
            if (!s.contains(i)) {
                System.out.println(i+"=i ");
            }
        }
    }
}
