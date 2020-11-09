package by.it.siarheikorbut.jd01_12;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskB2 {
    public static void main(String[] args) {
        int n = 10;
        ArrayList<String> strings1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings1.add(String.valueOf(i + 1));
        }
        LinkedList<String> strings2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            strings2.add(String.valueOf(i + 1));
        }
        String s1 = process(strings1);
        String s2 = process(strings2);

        System.out.println(s1);
        System.out.println(s2);
    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> strings = new ArrayList<>(peoples);
        int check = 1;
        while (strings.size() > 1) {
            for (int i = 0; i < strings.size(); ) {
                if (check == 1) {
                    check = 2;
                    i++;
                    continue;
                }
                strings.remove(i);
                check = 1;
            }
        }
        return strings.get(0);
    }

    static String process(LinkedList<String> peoples) {
        List<String> strings = new LinkedList<>(peoples);
        int check = 1;
        while (strings.size() > 1) {
            ListIterator<String> stringListIterator = strings.listIterator();
            while (stringListIterator.hasNext()) {
                stringListIterator.next();
                if (check == 1) {
                    check = 2;
                    stringListIterator.hasNext();
                    continue;
                }
                stringListIterator.remove();
                check = 1;

            }
        }
        return strings.get(0);
    }
}