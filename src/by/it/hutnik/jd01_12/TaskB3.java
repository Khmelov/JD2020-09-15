package by.it.hutnik.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        int a = 4096;
        for (int i = 0; i < a; i++) {
            arrayList.add(i, "Name" + i);
            linkedList.add(i, "Name" + i);
        }
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }
    static String process(ArrayList<String> narod) {
        int i;
        int size;
        while (narod.size() > 1) {
            if (narod.size() % 2 != 0) {
                i = 0;
                size = narod.size() / 2;
                for (int j = 0; j < size; j++) {
                    narod.remove(i + 1);
                    i++;
                }
                narod.remove(0);
            } else {
                i = 0;
                size = narod.size() / 2;
                for (int j = 0; j < size; j++) {
                    narod.remove(i + 1);
                    i++;
                }
            }
        }
        System.out.println(narod.get(0));
        return narod.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int i;
        while (peoples.size() > 1) {
            if (peoples.size() % 2 != 0) {
                i = 0;
                peoples.remove(i + 1);
                i++;
                if (i == peoples.size()) {
                    peoples.remove(0);
                }
            } else {
                i = 0;
                peoples.remove(i + 1);
                i++;
            }
        }
        System.out.println(peoples.getLast());
        return peoples.getLast();
    }
}