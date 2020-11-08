package by.it.siarheikorbut.jd01_11;

import java.util.*;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1Dtmq3a65M1AIORy_S6eC7CHwxX6PCQGB/view?usp=sharing">Задание JD01_11</a>
 */

public class Runner {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("one");
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add(null);
        strings.add("124");
        System.out.println(strings.toString());
        System.out.println("contains \"one\": " + strings.contains("one"));
        System.out.println("remove: " + strings.remove(null));
        System.out.println("after remove:" + strings.toString());
        System.out.println("size: " + strings.size());
        System.out.println("isEmpty: " + strings.isEmpty());
        Set<String> strings1 = new HashSet<>();
        strings1.add("one");
        strings1.add("four");
        strings1.add("five");
        strings1.add("six");

        strings1.add("2");
        Set<String> strings2 = new HashSet<>();
        strings2.add("one");
        strings2.add("four");
        strings2.add("five");
        strings2.add("six");
        strings2.add("1");
        strings2.add("2");
        strings2.add("3");

        System.out.println("addAll: " + strings.addAll(strings1));
        System.out.println("strings: " + strings.toString());

        System.out.println("containsAll: " + strings.containsAll(strings2));
        System.out.println("removeAll: " + strings.removeAll(strings2));
        System.out.println(strings.toString());
        strings.clear();
        System.out.println(strings.toString());

        System.out.println("==============================");
        System.out.println("my realization ");

        //создание коллекции
        SetC<String> objects = new SetC<>();

        //заполнение коллекции
        objects.add("one");

        //получение возращаемого значения false при попытке добавить повторящийся элемент
        System.out.println(objects.add("one"));
        objects.add("one");
        objects.add("one");

        //получение возращаемого значения true при попытке добавить уникальный элемент
        System.out.println(objects.add("1"));
        objects.add("2");
        objects.add("3");
        objects.add(null);

        //печать полученной коллекции
        System.out.println("after add: " + objects.toString());

        //тест метода remove
        System.out.println("after remove: " + objects.toString());

        //тест метода size
        System.out.println("size: " + objects.size());

        //тест метода isEmpty
        System.out.println("isEmpty: " + objects.isEmpty());

        //печать коллекции которую необходимо добавит
        System.out.println("strings1: " + strings1.toString());

        //печать true/false если что-то добавилось/ничего не добавилось
        System.out.println("addAll: " + objects.addAll(strings1));

        //печать полученного объекта
        System.out.println("objects: " + objects.toString());
        System.out.println("size: " + objects.size());

        //создадим новую коллекцию для проверки методов containsAll и removeAll
        Set<String> strings3 = new HashSet<>();
        strings3.add("one");
        strings3.add("1");
        strings3.add("2");
        strings3.add("3");
        strings3.add(null);
        System.out.println("==============================");

        //печать коллекции для проверки containsAll и removeAll
        System.out.println("strings3: " + strings3.toString());

        //печать тестирумой коллекции
        System.out.println("objects: " + objects.toString());

        //тест метода containsAll
        System.out.println("containsAll string3: " + objects.containsAll(objects));

        //тест метода removeAll
        System.out.println("removeAll string3: " + objects.removeAll(objects));
        System.out.println("objects: " + objects.toString());
        System.out.println("size: " + objects.size());

        //проверка clear
        objects.clear();
        System.out.println("clear: " + objects.toString());
    }
}