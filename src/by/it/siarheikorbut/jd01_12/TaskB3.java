package by.it.siarheikorbut.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Ryp9d5F9tODmNRVG6-eStmPl4TFplV3-/view?usp=sharing">Задание JD01_12</a>
 */

public class TaskB3 {
    static String process(ArrayList<String> peoples)
    {
        do {
            peoples.add(peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
        } while (peoples.size() != 1);
        return peoples.get(0);
    }
    static String process(LinkedList<String> peoples)
    {
        do {
            peoples.addLast(peoples.get(0));
            peoples.remove(0);
            peoples.remove(0);
        } while (peoples.size() != 1);
        return peoples.get(0);
    }
}