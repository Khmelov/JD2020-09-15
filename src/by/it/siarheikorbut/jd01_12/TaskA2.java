package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] array2 = {5, 5, 5, 4, 6, 7, 8, 9, 9, 9, 10};

        List<Integer> list2 = Arrays.asList(array2);

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 100));
        Set<Integer> set2 = new TreeSet<>(list2);
        System.out.printf("set1=%s\n", set1);
        System.out.printf("set2=%s\n", set2);

        Set<Integer> union = getUnion(set1, set2);
        System.out.printf("union=%s\n", union);

        Set<Integer> cross = getCross(set1, set2);
        System.out.printf("cross=%s\n", cross);
    }

    private static Set<Integer> getCross(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> set1, Set<Integer> set2) {
        HashSet<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}