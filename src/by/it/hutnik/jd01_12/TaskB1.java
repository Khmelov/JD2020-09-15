package by.it.hutnik.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
            Map<String, Integer> occurrences = new HashMap<>();
        while (!(text=scanner.next()).equals("end")) {
            List<String> list = Arrays.asList(text.split("[\\,?—;:.\\s]"));
            for ( String word : list ) {
                Integer oldCount = occurrences.get(word);
                if ( oldCount == null ) {
                    oldCount = 0;
                }
                occurrences.put(word, oldCount+1);
            }
        }
            System.out.println(occurrences.entrySet());
    }
}