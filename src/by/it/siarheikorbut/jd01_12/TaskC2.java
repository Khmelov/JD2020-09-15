package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskC2 {
    public static void main(String[] args) {
        Set<Long> a = new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Long> b = new HashSet<>(Arrays.asList(4L, 5L, 6L, 7L, 8L, 9L));
        Set<Long> c = new HashSet<>(Arrays.asList(4L, 5L, 10L, 11L, 12L, 13L));
        Set<Double> d = new HashSet<>(Arrays.asList(4., 5., 20., 21.));

        System.out.printf("a=%s\n", a);
        System.out.printf("b=%s\n", b);
        System.out.printf("b=%s\n", c);
        System.out.printf("b=%s\n", d);

        Set<Double> union = getUnion(d, a, b, c);
        HashSet<Object> cross = getCross(d, a, b, c);
        System.out.println(union);
        System.out.println(cross);
    }

    @SafeVarargs
    private static HashSet<Object> getCross(Set<? extends Number>... args) {
        HashSet<Object> result = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            HashSet buffer = new HashSet<Double>();
            for (Number number : args[i]) {
                double k = number.doubleValue();
                buffer.add(k);
                if (i == 0) {
                    result.add(k);
                }
            }
            result.retainAll(buffer);
            buffer.clear();
        }
        return result;
    }

    @SafeVarargs
    private static Set<Double> getUnion(Set<? extends Number>... args) {
        HashSet<Double> result = new HashSet<>();
        for (Set<? extends Number> arg : args) {
            for (Number number : arg) {
                double k = number.doubleValue();
                result.add(k);
            }
        }
        return result;
    }
}