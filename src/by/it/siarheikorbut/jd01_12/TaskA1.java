package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskA1 {
    void clearBad(List<Integer> grades) {
        grades.removeIf(next -> next <= 3);
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        int n = 10 + rnd.nextInt(20);
        for (int i = 0; i < n; i++) {
            list.add(1 + rnd.nextInt(10));
        }
        System.out.println(list);
        new TaskA1().clearBad(list);
        System.out.println(list);
    }
}